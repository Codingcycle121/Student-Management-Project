package com.Practice.itm.practiceProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Practice.itm.practiceProject.entity.Student;
import com.Practice.itm.practiceProject.studentservice.StudentService;

@RestController
public class Controller {

	@Autowired
	StudentService service;
	
	@CrossOrigin("*")
	@RequestMapping(value="/student/getAll",method =RequestMethod.GET)
	public List<Student> getAllStudents()
	{
		return service.getAllStudents();
	}
	@CrossOrigin("*")
	@RequestMapping(value="/student/add",method =RequestMethod.POST)
	public boolean addStudent(@RequestBody Student s)
	{
		return service.addStudent(s);
	}
	@RequestMapping(value="/student/get/{id}",method = RequestMethod.GET)
	public Student getStudentById(@PathVariable long id)
	{
		return service.getStudentById(id);
	}
	@RequestMapping(value="/student/updatename/{id}",method =RequestMethod.PUT)
	public Student update(@PathVariable long id, @RequestBody String name)
	{
		return service.updateStudent(id, name);
	}
	@RequestMapping(value="/student/delete/{id}",method =RequestMethod.DELETE)
	public Student delete(@PathVariable long id)
	{
		return service.deleteStudentById(id);
	}
	@RequestMapping(value="/student/sortstds",method = RequestMethod.GET)
	public int sortStudent(@PathVariable long id)
	{
		return service.sortStudentById(id);
	}
	
}
