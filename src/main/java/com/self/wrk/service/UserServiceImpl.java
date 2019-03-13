package com.self.wrk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.self.wrk.dao.UserDataRepository;
import com.self.wrk.entity.User;

@Service
@Qualifier("userService")
public class UserServiceImpl {

	@Autowired
	private UserDataRepository userDataRepository;

	public User save(User user) {
		return userDataRepository.save(user);
	}

	public User getById(Long id) {
		return userDataRepository.getOne(id);
	}

	public List<User> getAll() {
		return userDataRepository.findAll();
	}

	public int delete(Long id) {

		if (userDataRepository.existsById(id)) {
			userDataRepository.delete(new User(id));
			return 0;
		}
		return -1;
	}

	public User login(String name, String password) {
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			return null;
		}
		return userDataRepository.findUser(name, password);
	}
}
