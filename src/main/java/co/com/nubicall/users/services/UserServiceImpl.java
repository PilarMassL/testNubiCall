package co.com.nubicall.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nubicall.users.entities.UserEntity;
import co.com.nubicall.users.exceptions.BusinessException;
import co.com.nubicall.users.exceptions.UserNotFoundException;
import co.com.nubicall.users.model.User;
import co.com.nubicall.users.repositories.UserRepository;
import co.com.nubicall.users.util.ModelMapperUtil;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void save(User user) {

		UserEntity userEntity = (UserEntity) ModelMapperUtil.convert(user, UserEntity.class);

		if (!userRepository.exists(userEntity.getUserName())) {
			userRepository.save(userEntity);
		} else {
			throw new BusinessException("User already exist.");
		}
	}

	@Override
	public void update(User user) {

		UserEntity userEntity = (UserEntity) ModelMapperUtil.convert(user, UserEntity.class);

		if (userRepository.exists(userEntity.getUserName())) {
			userRepository.save(userEntity);
		} else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public void delete(String username) {
		if (userRepository.exists(username)) {
			userRepository.delete(username);
		} else {
			throw new UserNotFoundException();
		}

	}

	@Override
	public List<User> getAll() {

		List<UserEntity> usersEntity = new ArrayList<>();
		userRepository.findAll().forEach(usersEntity::add);

		return usersEntity.stream().map(user -> (User) ModelMapperUtil.convert(user, User.class))
				.collect(Collectors.toList());
	}

	@Override
	public User getByUserName(String username) {

		if (userRepository.exists(username)) {

			UserEntity userEntity = userRepository.findOne(username);

			return (User) ModelMapperUtil.convert(userEntity, User.class);
		} else {
			throw new UserNotFoundException();
		}
	}

}
