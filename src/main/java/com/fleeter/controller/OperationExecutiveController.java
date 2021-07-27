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

import com.fleeter.entities.roles.OperationExecutive;
import com.fleeter.repository.OperationalExecutiveRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/operationExecutive")
public class OperationExecutiveController {
	
	
	@Autowired
	private OperationalExecutiveRepository operationalExecutiveRepository;
	
	@PostMapping("/")
	public OperationExecutive saveOperationExecutive(@RequestBody OperationExecutive operationExecutive)
	{
		try {
			operationExecutive.setRole("operationExecutive");
			return operationalExecutiveRepository.save(operationExecutive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<OperationExecutive> getAllOperationExecutive()
	{
		try {
			return operationalExecutiveRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public OperationExecutive getOperationExecutiveById(@PathVariable("id") int id)
	{
		try {
			return operationalExecutiveRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteOperationExecutiveById(@PathVariable("id") int id)
	{
		try {
			 operationalExecutiveRepository.deleteById(id);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public OperationExecutive updateOperationExecutiveById(@RequestBody OperationExecutive operationExecutive,@PathVariable("id") int id)
	{
		try {
			operationExecutive.setId(id);
			return operationalExecutiveRepository.save(operationExecutive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
