package com.self.wrk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.self.wrk.entity.User;
import com.self.wrk.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/")
	public @ResponseBody String goToHome(Model model) {
		return "home";
	}

	/**
	 * Saves a new User to the database, updates if the user is already exists in
	 * the table
	 * 
	 * @param user saves it when the input is without id, updates with a valid Id
	 * @return User
	 * @throws Exception
	 */
	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	public @ResponseBody User save(@RequestBody User user) throws Exception {
		return userService.save(user);

	}

	@DeleteMapping(value = "/users/{id}")
	public @ResponseBody String deleteById(@PathVariable("id") String id) {

		int delStatus = 0;
		try {
			if (!StringUtils.isEmpty(id)) {
				delStatus = userService.delete(Long.valueOf(id));
			}

		} catch (Exception e) {
			// will be replaced by logger
			System.out.println("Error while deleting a user" + e);
		}
		return delStatus == 0 ? "User removed from DB! " : "Failed to remove user!";

	}

	@GetMapping(value = "/users/{id}")
	public @ResponseBody User getById(@PathVariable("id") String id) {

		User user = null;
		try {
			if (!StringUtils.isEmpty(id)) {
				user = userService.getById(Long.valueOf(id));
			}

		} catch (Exception e) {
			// will be replaced by logger
			System.out.println("Error while getting a user" + e);

		}
		return user;

	}

	/**
	 * Lists down the users from the table
	 * 
	 * @return list of users from the user_info table
	 * @throws Exception
	 */
	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public @ResponseBody List<User> list() throws Exception {
		return userService.getAll();

	}

	/**
	 * Logs the user in to the application if credentials match.
	 * 
	 * @param name, user's name
	 * @param password, password chosen by the user
	 * @return Success/failure login message based on matching data
	 */
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestParam("name") String name, @RequestParam("password") String password) {
		User user = userService.login(name, password);
		if (user == null) {
			return "Not a valid User, Please check the credentials";
		}
		return "Login Successfull! Welcome " + user.getName();
	}
}
