package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ResultId implements Serializable {
	private String studentId;
	private String examId;

	public ResultId() {
	}

	public ResultId(String studentId, String examId) {
		this.studentId = studentId;
		this.examId = examId;
	}
	 
	@Column(name = "StudentID", nullable = false)
	@NotNull
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "ExamID", nullable = false)
	@NotNull
	public String getExamId() {
		return examId;
	}


	public void setExamId(String examId) {
		this.examId = examId;

	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ResultId))
			return false;
		ResultId castOther = (ResultId) other;
		return ((this.getStudentId() == castOther.getStudentId()) || (this.getStudentId() != null
				&& castOther.getStudentId() != null && this.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getExamId() == castOther.getExamId())
						|| (this.getExamId() != null && castOther.getExamId() != null
								&& this.getExamId().equals(castOther.getExamId())));
	}

	public int hashCode() {
		return super.hashCode();
	}
}