package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.ics.listeners.ResultAuditor;

@Entity
@EntityListeners(ResultAuditor.class)
@NamedQueries({
	@NamedQuery(name = "Result.findAllResults", query = "SELECT r FROM Result r"),
	@NamedQuery(name = "Result.findAllResultsByStudentId", query = "SELECT r FROM Result r WHERE r.resultId.studentId =:studentId"),
})
@Table(name = "Result")
public class Result implements Serializable {
	private ResultId resultId;	
	private int points;
	private Student student;
	private Exam exam;
	
	
	

	public Result(int points, Student student, Exam exam) {
		super();
		this.points = points;
		this.student = student;
		this.exam = exam;
	}

	public Result() {
		super();
	}

	@EmbeddedId
	public ResultId getResultId() {
		return resultId;
	}
	
	 public void setResultId(ResultId resultId) {
	        this.resultId = resultId;
	    }

	public void setResultId(String studentId, String examId) {
	    ResultId resultId = new ResultId();
	    resultId.setStudentId(studentId);
	    resultId.setExamId(examId);
	    this.resultId = resultId;
	}


	@Column(name = "Points")
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@ManyToOne
	@JoinColumn(name = "StudentID", referencedColumnName = "studentID", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student studentId) {
		this.student = studentId;
	}
	
	@ManyToOne
	@JoinColumn(name = "ExamID", referencedColumnName = "examID", nullable = false, insertable = false, updatable = false)
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public String getExamId(Exam exam) {
		return exam.getExamId();
	}
	
	public String getStudentId(Student student) {
		return student.getStudentId();
	}
}
