package org.ics.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.ics.ejb.Student;

public class StudentAuditor {
	@PostLoad
	public void logOperation(Student s) {
		System.out.print("@PostLoad on id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}

	@PrePersist
	public void logCreate(Student s) {
		System.out.print("@PrePersist id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}

	@PostPersist
	public void onPostPersist(Student s) {
		System.out.print("@PostPersist id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}

	@PreUpdate
	public void logPreUpdate(Student s) {
		System.out.print("@PreUpdate id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}

	@PostUpdate
	public void onPostUpdate(Student s) {
		System.out.print("@PostUpdate id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}

	@PreRemove
	public void onPreRemove(Student s) {
		System.out.print("@PreRemove id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}

	@PostRemove
	public void onPostRemove(Student s) {
		System.out.print("@PostRemove id: " + s.getStudentId());
		System.out.print(" from StudentAuditor - ");
		System.out.print("Name: " + s.getStudentName() + " ");
		System.out.println("Address: " + s.getAddress());
	}
}
