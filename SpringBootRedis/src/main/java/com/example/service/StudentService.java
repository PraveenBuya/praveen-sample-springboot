/**
 * 
 */
package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Idao.IStudentDao;
import com.example.Iservice.IStudentService;
import com.example.entity.Student;

/**
 * @author praveen
 *
 */

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	public Collection<Student> getAllStudents() {
		return this.studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}

	@Override
	public void removeStudentById(int id) {
		this.studentDao.removeStudentById(id);

	}

	@Override
	public void updateStudent(Student student) {
		this.studentDao.updateStudent(student);

	}

	@Override
	public void insertStudent(Student student) {
		this.studentDao.insertStudent(student);

	}

}
