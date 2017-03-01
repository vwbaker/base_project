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

package base;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryPostRepositoy implements PostRepository {

	private static AtomicLong counter = new AtomicLong();

	// changed to a concurrent sorted hash
	private final ConcurrentMap<Long, Post> posts = new ConcurrentSkipListMap<Long, Post>();

	@Override
	public Iterable<Post> findAll() {
		return this.posts.values();
	}

	@Override
	public Post save(Post post) {
		Long id = post.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			post.setId(id);
		}
		this.posts.put(id, post);

		return post;
	}

	@Override
	public List<Post> save(List<Post> posts) {
		for (Post c : posts) {
			save(c);
		}
		return posts;
	}

	@Override
	public Post findPost(Long id) {
		return this.posts.get(id);
	}

	@Override
	public Post deletePost(Long id) {
		return this.posts.remove(id);
	}

}
