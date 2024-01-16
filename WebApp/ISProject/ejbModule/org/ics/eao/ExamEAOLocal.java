package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Exam;



@Local
public interface ExamEAOLocal {
	public Exam findByExamId(String id);
	public Exam createExam(Exam exam);

	public Exam updateExam(Exam exam);

	public void deleteExam(String id);
	public List<Exam> findAllExams();
	public String generateId();
	public List<Exam> findExamsByStudentId(String studentId);
}
