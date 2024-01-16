package org.ics.ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class StudentStudyId implements Serializable {
	private String studentId;
	private String courseId;

	public StudentStudyId() {
	}

	public StudentStudyId(String studentId, String courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	@Column(name = "StudentId", nullable = false)
	@NotNull
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name = "CourseId", nullable = false)
	@NotNull
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof StudentStudyId)) {
			return false;
		}

		StudentStudyId castOther = (StudentStudyId) other;
		return ((this.getStudentId() == castOther.getStudentId()) || (this.getStudentId() != null
				&& castOther.getStudentId() != null && this.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getCourseId() == castOther.getCourseId()) || (this.getCourseId() != null
						&& castOther.getCourseId() != null && this.getCourseId().equals(castOther.getCourseId())));

	}

	public int hashCode() {
		return super.hashCode();
	}

}


