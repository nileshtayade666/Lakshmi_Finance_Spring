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

import com.fleeter.entities.roles.AccountHead;
import com.fleeter.repository.AccountHeadRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/accountHead")
public class AccountHeadController {
	
	
	@Autowired
	private AccountHeadRepository accountHeadRepository;
	
	@PostMapping("/") 
	public AccountHead saveAccountHead(@RequestBody AccountHead accountHead)
	{
		try {
			accountHead.setRole("accountHead");
			return accountHeadRepository.save(accountHead);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<AccountHead> getAllAccountHead()
	{

		try {
			return accountHeadRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public AccountHead getAccountHeadById(@PathVariable("id") int id)
	{

		try {
			return accountHeadRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteAccountHeadById(@PathVariable("id") int id)
	{

		try {
			accountHeadRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PutMapping("/{id}")
	public AccountHead updateAccountHeadById(@RequestBody AccountHead accountHead,@PathVariable("id") int id)
	{

		try {
			
			accountHead.setId(id);
			return accountHeadRepository.save(accountHead);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
