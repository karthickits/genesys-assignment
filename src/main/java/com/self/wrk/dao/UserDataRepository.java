package com.self.wrk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.self.wrk.entity.User;

@Repository
public interface UserDataRepository extends JpaRepository<User, Long> {

	@Query(value = "select user from User user where user.name = ?1 and user.password = ?2")
	public User findUser(String name, String password);

}
