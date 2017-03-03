/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package base;

<<<<<<< HEAD:src/main/java/base/ContentDatabase.java
import org.springframework.data.repository.CrudRepository;
=======
import java.util.List;
>>>>>>> c72673220e80db08818a9575f498a32682df4b8e:src/main/java/base/PostRepository.java

public interface PostRepository {

	Iterable<Post> findAll();

	Post save(Post post);

	List<Post> save(List<Post> posts);

	Post findPost(int id);

	Post deletePost(int id);

}
