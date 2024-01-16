package org.ics.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.ics.ejb.Student;
import org.ics.ejb.StudentStudy;

public class StudentStudyAuditor {
	@PostLoad
	public void logOperation(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

	@PrePersist
	public void logCreate(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

	@PostPersist
	public void onPostPersist(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

	@PreUpdate
	public void logPreUpdate(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

	@PostUpdate
	public void onPostUpdate(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

	@PreRemove
	public void onPreRemove(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

	@PostRemove
	public void onPostRemove(StudentStudy st) {
		System.out.print("@PostLoad on id: " + st.getStudentStudyId());
		System.out.print(" from StudentStudyAuditor - ");
		System.out.print("Start Date: " + st.getStartDate() + " ");
		System.out.println("End Date: " + st.getEndDate());
	}

}
