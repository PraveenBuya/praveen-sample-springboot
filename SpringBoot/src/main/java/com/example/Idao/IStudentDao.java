/**
 * 
 */
package com.example.Idao;

import java.util.Collection;

import com.example.entity.Student;

/**
 * @author praveen
 *
 */
public interface IStudentDao {
	
	public Collection<Student> getAllStudents();
	
	public Student getStudentById(int id);
	
	public void removeStudentById(int id);
	
	public void updateStudent(Student student);
	
	public void insertStudent(Student student);

}
