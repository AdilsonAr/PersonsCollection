package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age)
	{
		Person p=personService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName)
	{
		return personService.findByFirstName(firstName);
	}
	
	@RequestMapping("/getAll")
	public List<Person> getAll()
	{
		return personService.getAll();
	}
	
	@RequestMapping("/update")
	public String updatePerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age)
	{
		Person p=personService.update(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/delete")
	public String deletePerson(@RequestParam String firstName)
	{
		personService.delete(firstName);
		return "Deleted "+firstName;
	}
	
	@RequestMapping ("deleteAll")
	public String deleteAllPersons() {
		personService.deleteAll();
		return "Deleted";
	}
	
	
	//using multiple http methods for future integration
	
	@PutMapping("/put")
	public String test()
	{
		return "put operation";
	}
	
	@PostMapping("/write/{message}")
	public String message(@PathVariable(name="message") String message)
	{
		return message;
	}
	
	@PostMapping("/see")
	public Person see(@RequestBody Person person)
	{
		person.setAge(person.getAge()+1);
		return person;
	}
}
