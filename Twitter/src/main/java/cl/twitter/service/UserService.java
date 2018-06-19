package cl.twitter.service;


import cl.twitter.entity.User;

public interface UserService {
		public User findUserByEmail(String email);
		public void saveUser(User user);
}
