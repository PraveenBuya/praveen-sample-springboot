/**
 * 
 */
package com.example.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.Idao.IStudentDao;
import com.example.entity.Student;

/**
 * @author praveen
 *
 */

@Repository
public class StudentDao implements IStudentDao {

	private static Map<Integer, Student> students;

	static {

		students = new HashMap<Integer, Student>() {
			{
				put(1, new Student(1, "Ram", "CSE"));
				put(2, new Student(2, "Sham", "EEE"));
				put(3, new Student(3, "TEST", "FSDF"));
			}

		};
	}

	public Collection<Student> getAllStudents() {
		return this.students.values();
	}

	@Override
	public Student getStudentById(int id) {
		return this.students.get(id);
	}

	@Override
	public void removeStudentById(int id) {
		students.remove(id);

	}

	public void updateStudent(Student student) {

		Student s = students.get(student.getId());
		s.setName(student.getName());
		s.setCourse(student.getCourse());
		students.put(student.getId(), student);

	}

	@Override
	public void insertStudent(Student student) {
		this.students.put(student.getId(), student);

	}
}
