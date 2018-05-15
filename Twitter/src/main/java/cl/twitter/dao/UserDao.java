package cl.twitter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cl.twitter.entity.User;


@Component
@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager entityManager;

	public void addUser(User entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	public void updateUser(User entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}

	public User findById(long id) {
		return entityManager.find(User.class, id);
	}

	public void deleteById(long id) {
		User entity = entityManager.find(User.class, id);
		entityManager.remove(entity);
	}

	public List<User> getAllUsers() {
		
		Query query = entityManager.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<User> allUsers = query.getResultList();
		return allUsers;
	}
	
}
