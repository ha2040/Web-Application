package org.ics.ejb;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
@NamedQueries({ @NamedQuery(name = "Exam.findAllExams", query = "SELECT e FROM Exam e"),
		@NamedQuery(name = "Exam.findExamsByStudentId", query = "SELECT e FROM Exam e WHERE e.course.courseId IN (SELECT ss.course.courseId FROM StudentStudy ss WHERE ss.student.studentId = :studentId)"), })

public class Exam implements Serializable {
	private String examId;
	private Course course;
	private String room;
	private Date examDate;
	private int credit;

	public Exam() {

	}

	public Exam(String examId, Course course, String room, Date date, int credit) {
		this.examId = examId;
		this.course = course;
		this.room = room;
		this.examDate = date;
		this.credit = credit;
	}

	@Id
	@Column(name = "ExamID")
	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	@ManyToOne
	@JoinColumn(name = "CourseID", referencedColumnName = "courseID", nullable = false, insertable = true, updatable = true)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "Room")
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Column(name = "ExamDate")
	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	@Column(name = "Credits")
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@PrePersist
	public void onPrePersist() {
		System.out.println("@PrePersist on Exam with examId " + this.getExamId() + " and courseId "
				+ this.getCourse().getCourseId());
	}

	@PostPersist
	public void onPostPersist() {
		System.out.println("@PostPersist on Exam with examId " + this.getExamId() + " and courseId "
				+ this.getCourse().getCourseId());
	}

	@PreUpdate
	public void onPreUpdate() {
		System.out.println("@PreUpdate on Exam with examId " + this.getExamId() + " and courseId "
				+ this.getCourse().getCourseId());
	}

	@PostUpdate
	public void onPostUpdate() {
		System.out.println("@PostUpdate on Exam with examId " + this.getExamId() + " and courseId "
				+ this.getCourse().getCourseId());
	}

	@PreRemove
	public void onPreRemove() {
		System.out.println("@PreRemove on Exam with examId " + this.getExamId() + " and courseId "
				+ this.getCourse().getCourseId());
	}

	@PostRemove
	public void onPostRemove() {
		System.out.println("@PostRemove on Exam with examId " + this.getExamId() + " and courseId "
				+ this.getCourse().getCourseId());
	}

	@PostLoad
	public void logOperation() {
		System.out.print("@PostLoad on id: " + this.getExamId());
		System.out.print(" @PostLoad: " + this.getCourse().getDescription() + " ");
		System.out.println(this.getRoom());
	}

}
