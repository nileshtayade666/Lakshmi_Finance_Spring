package com.fleeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleeter.entities.master.LoginRequest;
import com.fleeter.entities.master.User;
import com.fleeter.repository.UserRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public User saveUser(@RequestBody LoginRequest loginRequest)
	{
		try {
			return userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
		try {
			 userRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/")
	public List<User> getUsers()
	{
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return  userRepository.findAll();

		}
		return null;
	}
}
