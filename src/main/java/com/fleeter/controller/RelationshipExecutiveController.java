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

import com.fleeter.entities.roles.RelationshipExecutive;
import com.fleeter.repository.RelashionshipExecutiveRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/relationshipExecutive")
public class RelationshipExecutiveController {
	
	
	@Autowired
	private RelashionshipExecutiveRepository relashionshipExecutiveRepository;
	
	@PostMapping("/")
	public RelationshipExecutive saveRelationshipExecutive(@RequestBody RelationshipExecutive relationshipExecutive)
	{
			try {
				relationshipExecutive.setRole("relationshipExecutive");
				return relashionshipExecutiveRepository.save(relationshipExecutive);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return null;
	}
	
	@GetMapping("/")
	public List<RelationshipExecutive> getAllApplicant()
	{
		try {
			return relashionshipExecutiveRepository.findAll();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public RelationshipExecutive getRelationshipExecutiveById(@PathVariable("id") int id)
	{
		try {
			return relashionshipExecutiveRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteRelationshipExecutiveById(@PathVariable("id") int id)
	{
		try {
			relashionshipExecutiveRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/{id}")
	public RelationshipExecutive updateRelationshipExecutiveById(@RequestBody RelationshipExecutive relationshipExecutive,@PathVariable("id") int id)
	{
		try {
			relationshipExecutive.setId(id);
			return relashionshipExecutiveRepository.save(relationshipExecutive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
