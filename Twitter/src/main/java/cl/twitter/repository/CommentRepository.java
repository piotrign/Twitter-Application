package cl.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.twitter.entity.Comment;
import cl.twitter.entity.Tweet;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("SELECT c FROM Comment c, Tweet t WHERE t.id = c.id ORDER BY t.created DESC")
	List<Comment> findAllCommentByTweetOrderByCreatedDesc(long id);

}
