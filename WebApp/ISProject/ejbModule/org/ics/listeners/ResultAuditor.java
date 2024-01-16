package org.ics.listeners;

import org.ics.ejb.Result;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ResultAuditor {
	
	@PostLoad
	public void logOperation(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}

	@PrePersist
	public void logCreate(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}

	@PostPersist
	public void onPostPersist(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}

	@PreUpdate
	public void logPreUpdate(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}

	@PostUpdate
	public void onPostUpdate(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}

	@PreRemove
	public void onPreRemove(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}

	@PostRemove
	public void onPostRemove(Result r) {
		System.out.print("@PostLoad on id: " + r.getResultId());
		System.out.print(" from ResultAuditor - ");
		System.out.print("Points: " + r.getPoints() + " ");
		System.out.println("StudentID: " + r.getStudent());
		System.out.println("ExamID: " + r.getExam());
	}
}
