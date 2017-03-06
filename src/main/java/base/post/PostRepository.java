package base.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("select p from Post p where p.createdBy.id = ?#{principal.id}")  // Spring Expression Language
    Iterable<Post> findAllToCurrentUser();

//    @PostAuthorize("hasPermission(returnObject,'read')") // dont worry about this for now
    @Query("select p from Post p where p.createdBy.id = ?#{principal.id}")  // Spring Expression Language
    Post findOne(Long id);
}
