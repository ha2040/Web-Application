package org.ics.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ics.listeners.StudentAuditor;

@NamedQuery(name = "Student.findAllStudents", query = "SELECT s FROM Student s")

@Entity
@EntityListeners(StudentAuditor.class)
@Table(name = "Student")
public class Student implements Serializable {
	private String studentId;
	private String studentName;
	private String address;
	private Set<StudentStudy> studyList;
	private Set<Result> resultList;

	public Student() {

	}

	public Student(String id, String name, String address) {
		studentId = id;
		studentName = name;
		this.address = address;
	}

	@Id
	@Column(name = "StudentID")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String id) {
		this.studentId = id;
	}

	@Column(name = "StudentName")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		this.studentName = name;
	}

	@Column(name = "Address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	public Set<StudentStudy> getStudyList() {
		return studyList;
	}

	public void setStudyList(Set<StudentStudy> studyList) {
		this.studyList = studyList;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Result> getResultList() {
		return resultList;
	}

	public void setResultList(Set<Result> resultList) {
		this.resultList = resultList;
	}

}
