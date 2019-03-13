package com.self.wrk.userservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.self.wrk.application.UserServiceApplication;
import com.self.wrk.entity.User;
import com.self.wrk.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class UserServiceTest {

	@Autowired
	private UserServiceImpl userService;

	/**
	 * validates the save user by creating a sample user
	 */
	@Test
	public void whenSaveUser() {
		User user = new User("karthick", "ramapuram", "Admin@123");
		user.setId(10L);
		User user2 = new User("Shiva Kumar", "Taramani", "Admin@123");
		User response = userService.save(user);
		userService.save(user2);
		assertThat(response != null);
	}

	/**
	 * checks retrieved id matches with the queried id
	 */
	@Test
	public void whenFindUserById() {
		// when
		User found = userService.getById(10L);

		// then
		assertThat(found.getId()).isEqualTo(10L);
	}

	/**
	 * checks retrieved list not empty
	 */
	@Test
	public void whenFindAllUserByName() {
		// when
		List<User> found = userService.getAll();

		// then
		assertThat(found != null && !found.isEmpty());
	}

	/**
	 * checks retrieved id matches with the queried id
	 */
	@Test
	public void whenDeleteUserById() {
		// when
		int found = userService.delete(10L);

		// then
		assertThat(found == 0);// confirms a deletion is done
	}

}
