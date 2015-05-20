package org.bigtech.hbase.rest.resource;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.bigtech.hbase.dao.UserDAO;
import org.bigtech.hbase.dao.object.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

/**
 * A REST resource to retrieve data from HBase
 * 
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
@RestController
@RequestMapping("/hbase")
public class HBaseResource {
	private final AtomicInteger atomicInteger;

	/**
	 * 
	 */
	public HBaseResource() {
		atomicInteger = new AtomicInteger();
	}

	@RequestMapping(value = "/user/{id}", method = { RequestMethod.GET })
	public String getData(@PathVariable("id") int id) {
		System.out.println("Getting data for user " + id);

		try {
			UserDAO retrieval = new UserDAO();
			User user = new User(null, id);
			String userName = retrieval.getUserName(user);
			return userName;
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}

	@RequestMapping(value = "/user", method = { RequestMethod.POST })
	public String addUser(@RequestBody String userName) {
		int userId = atomicInteger.getAndIncrement();
		User user = new User(userName, userId);
		UserDAO userDAO;
		try {
			userDAO = new UserDAO();
			userDAO.writeUserName(user);
		} catch (IOException e) {
			System.err.println(e);
		}
		return "User Added";
	}

	@RequestMapping("/user/list")
	public List<User> allUsers() {
		List<User> users = Lists.newArrayList();
		try {
			UserDAO userDAO = new UserDAO();
			users = userDAO.getAllUsers();
		} catch (IOException e) {
			System.err.println(e);
		}
		return users;
	}
}
