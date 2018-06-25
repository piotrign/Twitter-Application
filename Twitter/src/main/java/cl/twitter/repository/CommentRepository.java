package cl.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.twitter.entity.Comment;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findAllCommentsByTweetOrderByCreatedDesc();
	
	List<Comment> findAllCommentsByTweetIdOrderByCreatedDesc(long id);
	
}
