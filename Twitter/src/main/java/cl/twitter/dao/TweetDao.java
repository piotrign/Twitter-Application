package cl.twitter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cl.twitter.entity.Tweet;


@Component
@Transactional
public class TweetDao {

	@PersistenceContext
	EntityManager entityManager;

	public void addTweet(Tweet entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	public void updateTweet(Tweet entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}

	public Tweet findById(long id) {
		return entityManager.find(Tweet.class, id);
	}

	public void deleteById(long id) {
		Tweet entity = entityManager.find(Tweet.class, id);
		entityManager.remove(entity);
	}

	public List<Tweet> getAllTweets() {

		Query query = entityManager.createQuery("SELECT t FROM Tweet t");
		@SuppressWarnings("unchecked")
		List<Tweet> allTweets = query.getResultList();
		return allTweets;
	}

	public List<Tweet> getAllTweetsByUserId(long Id) {

		Query query = entityManager.createQuery("SELECT t FROM Tweet t WHERE User.id = ?1");
		@SuppressWarnings("unchecked")
		List<Tweet> allTweets = query.getResultList();
		return allTweets;
	}

}
