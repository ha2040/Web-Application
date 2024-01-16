package org.ics.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Course")
@NamedQuery(name = "Course.findAllCourses", query = "SELECT c FROM Course c")
public class Course implements Serializable {
	private String courseID;
	private String facultyId;
	private String description;
	private String empId;
	private int credits;
	private Set<Exam> exams;

	
	public Course() {
		super();
	}

	public Course(String courseID, String facultyId, String description, String empId, int credits) {
		super();
		this.courseID = courseID;
		this.facultyId = facultyId;
		this.description = description;
		this.empId = empId;
		this.credits = credits;
	}

	@Id
	@Column(name = "CourseID")
	public String getCourseId() {
		return courseID;
	}

	public void setCourseId(String courseId) {
		this.courseID = courseId;
	}

	@Column(name = "FacultyID")
	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "EmpID")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Column(name = "Credits")
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

}
