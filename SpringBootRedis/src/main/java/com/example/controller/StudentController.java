/**
 * 
 */
package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Iservice.IStudentService;
import com.example.entity.Student;

/**
 * @author praveen
 *
 */

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		return this.studentService.getStudentById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeStudentById(@PathVariable("id") int id) {
		this.studentService.removeStudentById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student) {
		this.studentService.updateStudent(student);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertStudent(@RequestBody Student student) {
		this.studentService.insertStudent(student);
	}
}
