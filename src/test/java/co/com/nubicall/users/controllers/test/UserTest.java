package co.com.nubicall.users.controllers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.nubicall.users.controllers.UserController;
import co.com.nubicall.users.entities.UserEntity;
import co.com.nubicall.users.exceptions.BusinessException;
import co.com.nubicall.users.exceptions.UserNotFoundException;
import co.com.nubicall.users.model.User;
import co.com.nubicall.users.repositories.UserRepository;
import co.com.nubicall.users.services.UserServiceImpl;
import co.com.nubicall.users.util.ModelMapperUtil;
import co.com.nubicall.users.util.UserStatusEnum;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	
	private UserController userController;
	
	@Mock
	UserRepository  userRepository;
	
	UserServiceImpl userService;
	
	UserEntity  userEntity;
	User  user;
	
	@Before
	public void before() {
		
		userEntity = new UserEntity();
		userEntity.setUserName("pilarmass");
		userEntity.setFirstName("Stephany");
		userEntity.setLastName("Lopez");
		userEntity.setEmail("pilar.st@jhotmail.com");
		userEntity.setPassword("pilar123");
		userEntity.setPhone("1234567891");
		userEntity.setUserStatus(UserStatusEnum.Active);
		
		user = (User) ModelMapperUtil.convert(userEntity, User.class);
		
		userService = new UserServiceImpl(userRepository);
		userController =  new UserController(userService);
		
		
	}
	
	@Test
	public void saveUserSuccess() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(false);
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		
		String result = userController.save(user);
		
		assertEquals("User Created", result);
	}
	
	@Test(expected=BusinessException.class)
	public void saveUserFail() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(true);
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		userController.save(user);
	}
	
	@Test
	public void updateUserSuccess() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(true);
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		
		String result = userController.update("pilarmass", user);
		
		assertEquals("User Modified", result);
	}
	
	@Test(expected=UserNotFoundException.class)
	public void updateUserFail() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(false);
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		
		String result = userController.update("pilarmass", user);
		
		assertEquals("User Modified", result);
	}
	
	@Test
	public void deleteUserSuccess() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(true);
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		
		String result = userController.delete("pilarmass");
		
		assertEquals("User Deleted", result);
	}
	
	@Test(expected=UserNotFoundException.class)
	public void deleteUserFail() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(false);
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
		
		String result = userController.delete("pilarmass");
		
		assertEquals("User Deleted", result);
	}
	
	@Test
	public void getAllUser() {
		List<UserEntity> userEntityList = new ArrayList<>();
		userEntityList.add(userEntity);
		
		Mockito.when(userRepository.findAll()).thenReturn(userEntityList);
		
		List<User> listUser = userController.getAll();
		
		assertNotNull(listUser);
		assertEquals(1,listUser.size());
		
	}
	
	@Test
	public void getUserByUsernameSuccess() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(true);
		
		Mockito.when(userRepository.findOne("pilarmass")).thenReturn(userEntity);
		
		User user = userController.getByUserName("pilarmass");
		
		assertNotNull(user);
		assertEquals("pilarmass",user.getUserName());
	}
	
	@Test(expected=UserNotFoundException.class)
	public void getUserByUsernameFail() {
		Mockito.when(userRepository.exists("pilarmass")).thenReturn(false);
		
		Mockito.when(userRepository.findOne("pilarmass")).thenReturn(userEntity);
		
		User user = userController.getByUserName("pilarmass");
		
		assertNotNull(user);
		assertEquals("pilarmass",user.getUserName());
	}
	

}
