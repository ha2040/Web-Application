package org.ics.ejb;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EmbeddedId; 
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.ics.listeners.StudentAuditor;
import org.ics.listeners.StudentStudyAuditor;

import javax.persistence.Column;
@Entity
@EntityListeners(StudentStudyAuditor.class)
@NamedQueries({
	@NamedQuery(name = "StudentStudy.findAllStudentStudy", query = "SELECT s FROM StudentStudy s"),
	@NamedQuery(name = "StudentStudy.findAllStudentStudyByStudentId", query = "SELECT s FROM StudentStudy s WHERE s.id.studentId =: studentId")
})
@Table(name = "StudentStudy")
public class StudentStudy implements Serializable {
	private StudentStudyId id;
	private Date startDate;
	private Date endDate;
	private Student student;
	private Course course;
	
	
	
	public StudentStudy(Date startDate, Date endDate, Student student, Course course) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
		this.course = course;
	}

	public StudentStudy() {
		super();
	}

	@EmbeddedId
	public StudentStudyId getStudentStudyId() {
		return id;
	}
	
	public void setStudentStudyId(StudentStudyId id) {
	    this.id = id;
	}
	
	public void setId(String studentId, String courseId) {
		StudentStudyId id = new StudentStudyId();
		id.setCourseId(courseId);
		id.setStudentId(studentId);
		this.id = id;
	}
	
	
	@Column
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	} 
	
	@ManyToOne
	@JoinColumn(name = "CourseID", referencedColumnName="courseID", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@ManyToOne
	@JoinColumn(name = "StudentID", referencedColumnName="studentID", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getStudentId(Student student) {
		return student.getStudentId();
	}
	
	public String getCourseId(Course course) {
		return course.getCourseId();
	}
}
