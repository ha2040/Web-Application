package org.ics.eao;

import java.util.List;

import org.ics.ejb.StudentStudy;

public interface StudentStudyEAOLocal {
	public StudentStudy findByStudentStudyId(String StudentId, String CourseId);
	public StudentStudy createStudentStudy(StudentStudy studentStudy);
	public void deleteStudentStudy(String StudentId, String CourseId);
	public List<StudentStudy> findAllStudentStudy();
	public List<StudentStudy> findAllStudentStudyByStudentId(String id);

}
