package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Student;

@Local
public interface StudentEAOLocal {
	public Student findByStudentId(String id);

	public Student createStudent(Student student);

	public Student updateStudent(Student student);

	public void deleteStudent(String id);

	public List<Student> findAllStudents();
	
	public String generateId();
}
