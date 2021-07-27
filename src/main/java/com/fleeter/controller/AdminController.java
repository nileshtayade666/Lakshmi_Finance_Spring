package com.fleeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleeter.entities.roles.Admin;
import com.fleeter.repository.AdminRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@PostMapping("/") 
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		try {
			admin.setRole("admin");
			return adminRepository.save(admin);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<Admin> getAllAdmin()
	{
		try {
			return adminRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public Admin getAdminById(@PathVariable("id") int id)
	{
		try {
			return adminRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteAdminById(@PathVariable("id") int id)
	{
		try {
			adminRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PutMapping("/{id}")
	public Admin updateAdminById(@RequestBody Admin admin,@PathVariable("id") int id)
	{
		try {
			admin.setId(id);
			return adminRepository.save(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
