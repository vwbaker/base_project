/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package base.data;

import base.model.Course;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryCourseRepositoy implements CourseRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, Course> courses = new ConcurrentHashMap<Long, Course>();

	@Override
	public Iterable<Course> findAll() {
		return this.courses.values();
	}

	@Override
	public Course save(Course course) {
		Long id = course.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			course.setId(id);
		}
		this.courses.put(id, course);

		return course;
	}

	@Override
	public List<Course> save(List<Course> courses) {
		for (Course c : courses) {
			save(c);
		}
		return courses;
	}

	@Override
	public Course find(Long id) {
		return this.courses.get(id);
	}

	@Override
	public Course delete(Long id) {
		return this.courses.remove(id);
	}

}
