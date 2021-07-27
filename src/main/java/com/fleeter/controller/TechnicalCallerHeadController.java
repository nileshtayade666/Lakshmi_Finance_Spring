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

import com.fleeter.entities.roles.TechnicalCallerHead;
import com.fleeter.repository.TechnicalCallerHeadRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/technicalCallerHead")
public class TechnicalCallerHeadController {
	
	
	@Autowired
	private TechnicalCallerHeadRepository technicalCallerHeadRepository;
	
	@PostMapping("/") 
	public TechnicalCallerHead saveTechnicalCallerHead(@RequestBody TechnicalCallerHead technicalCallerHead)
	{
			try {
				
				technicalCallerHead.setRole("technicalCallerHead");
				return technicalCallerHeadRepository.save(technicalCallerHead);
				} catch (Exception e) {
					e.printStackTrace();
				}
			return null;
	}
	
	@GetMapping("/")
	public List<TechnicalCallerHead> getAllTechnicalCallerHead()
	{
		try {
			return technicalCallerHeadRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public TechnicalCallerHead getTechnicalCallerHeadById(@PathVariable("id") int id)
	{
		try {
			return technicalCallerHeadRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteTechnicalCallerHeadById(@PathVariable("id") int id)
	{
		try {
			technicalCallerHeadRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PutMapping("/{id}")
	public TechnicalCallerHead updateTechnicalCallerHeadById(@RequestBody TechnicalCallerHead technicalCallerHead,@PathVariable("id") int id)
	{
		try {
			technicalCallerHead.setId(id);
			return technicalCallerHeadRepository.save(technicalCallerHead);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
