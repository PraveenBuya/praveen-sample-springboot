/**
 * 
 */
package com.example.Iservice;

import java.util.Collection;

import com.example.entity.Student;

/**
 * @author praveen
 *
 */
public interface IStudentService {

	public Collection<Student> getAllStudents();

	public Student getStudentById(int id);

	public void removeStudentById(int id);

	public void updateStudent(Student student);

	public void insertStudent(Student student);

}
