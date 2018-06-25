package cl.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.twitter.entity.Tweet;
import cl.twitter.entity.User;

@Repository("twitterRepository")
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findByUser(User user);

	List<Tweet> findByUserId(long id);

	@Query("select t from Tweet t order by t.created desc")
	List<Tweet> findAllByOrderByCreatedDesc();
	
	List<Tweet> findAllTweetByUserId(long id);

}
