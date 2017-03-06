package base.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("select p from Post p where p.createdBy.id = ?#{principal.id}")  // Spring Expression Language
    Iterable<Post> findAllToCurrentUser();

    @PostAuthorize("hasPermission(returnObject,'read')") // Look at the class MessagePermissionEvaluator
    Post findOne(@Param("id") Long id); // Need the @Param for the @Query annotation to map :id to method param id
}
