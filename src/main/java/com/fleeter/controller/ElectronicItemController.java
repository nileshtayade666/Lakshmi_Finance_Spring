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

import com.fleeter.entities.master.ElectronicItem;
import com.fleeter.repository.ElectronicItemRepositoy;



@RestController
@CrossOrigin("*")
@RequestMapping("/electronicItem")
public class ElectronicItemController {
	
	
	@Autowired
	private ElectronicItemRepositoy electronicItemRepository;
	
	@PostMapping("/") 
	public ElectronicItem saveElectronicItem(@RequestBody ElectronicItem electronicItem)
	{
		try {
			return electronicItemRepository.save(electronicItem);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/")
	public List<ElectronicItem> getAllElectronicItem()
	{
		try {
			return electronicItemRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public ElectronicItem getElectronicItemById(@PathVariable("id") int id)
	{
		try {
			return electronicItemRepository.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteElectronicItemById(@PathVariable("id") int id)
	{
		try {
			electronicItemRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PutMapping("/{id}")
	public ElectronicItem updateElectronicItemById(@RequestBody ElectronicItem electronicItem,@PathVariable("id") int id)
	{
		try {
			electronicItem.setId(id);
			return electronicItemRepository.save(electronicItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}


}
