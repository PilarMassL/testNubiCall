package co.com.nubicall.users.services;

import java.util.List;

import co.com.nubicall.users.model.User;

public interface UserService {

	public void save(User user);

	public void update(User user);

	public void delete(String username);

	public List<User> getAll();

	public User getByUserName(String username);

}
