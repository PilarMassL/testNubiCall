package co.com.nubicall.users.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.nubicall.users.model.User;
import co.com.nubicall.users.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody

	public String save(@RequestBody @Valid User user) {

		userService.save(user);

		return "User Created";

	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String update(@PathVariable("username") String username, @RequestBody @Valid User user) {
		user.setUserName(username);
		userService.update(user);

		return "User Modified";

	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String delete(@PathVariable("username") String username) {

		userService.delete(username);

		return "User Deleted";

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> getAll() {

		return userService.getAll();
	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User getByUserName(@PathVariable("username") String username) {

		return userService.getByUserName(username);

	}

}
