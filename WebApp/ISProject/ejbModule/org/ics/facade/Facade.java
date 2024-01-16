package org.ics.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.ics.eao.CourseEAOLocal;
import org.ics.eao.ExamEAOLocal;
import org.ics.eao.ResultEAOLocal;
import org.ics.eao.StudentEAOLocal;

import org.ics.eao.StudentStudyEAOLocal;

import org.ics.ejb.Course;
import org.ics.ejb.Exam;

import org.ics.eao.StudentStudyEAOLocal;
import org.ics.ejb.Course;
import org.ics.ejb.Exam;
import org.ics.ejb.Result;
import org.ics.ejb.ResultId;
import org.ics.ejb.Student;
import org.ics.ejb.StudentStudy;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {
	@EJB
	StudentEAOLocal studentEAO;

	@EJB
	StudentStudyEAOLocal personEAO;

	@EJB
	CourseEAOLocal courseEAO;
	
	@EJB
	ExamEAOLocal examEAO;
	
	
	@EJB
	ResultEAOLocal resultEAO;

	public Facade() {
		// TODO Auto-generated constructor stub
	}

	public Student createStudent(Student student) {
		return studentEAO.createStudent(student);
	}

	public Student updateStudent(Student student) {
		return studentEAO.updateStudent(student);
	}

	public void deleteStudent(String id) {
		studentEAO.deleteStudent(id);
	}

	public Student findByStudentId(String id) {
		return studentEAO.findByStudentId(id);
	}
	
	public List<Student> findAllStudents(){
		return studentEAO.findAllStudents();
	}
	
	public String generateStudentId() {
		return studentEAO.generateId();
	}
	public StudentStudy createStudentStudy(StudentStudy studenStudy) {
		return personEAO.createStudentStudy(studenStudy);
	}

	public StudentStudy findByStudentStudyId(String StudentId, String CourseId) {
		return personEAO.findByStudentStudyId(StudentId, CourseId);
	}


	public void deleteStudentStudy(String StudentId, String CourseId) {
		personEAO.deleteStudentStudy(StudentId, CourseId);

	}

	public Exam createExam(Exam exam) {
		return examEAO.createExam(exam);

	}


	public Exam updateExam(Exam exam) {
		return examEAO.updateExam(exam);
	}

	public void deleteExam(String id) {
		examEAO.deleteExam(id);
	}

	public Exam findByExamId(String id) {
		return examEAO.findByExamId(id);
	}

	public Course findByCourseId(String courseId) {
		return courseEAO.findByCourseId(courseId);
	}

	public List<Exam> findAllExams() {
		return examEAO.findAllExams();
	}

	public List<Course> findAllCourses() {
		return courseEAO.findAllCourses();
	}

	public List<Result> findAllResult(){
		return resultEAO.findAllResult();
	}
	public List<Result> findAllResultsByStudentId(String id){
		return resultEAO.findAllResultsByStudentId(id);
	}
	
	public List<Student> findAllStudent(){
		return studentEAO.findAllStudents();
	}
	
	public Result findResult(String studentId, String examId) {
		return resultEAO.findResult(studentId, examId);
	}
	
	public Result createResult(Result result) {
		return resultEAO.createResult(result);
	}
	
	public Result updateResult(Result result) {
		return resultEAO.updateResult(result);
	}
	
	public void deleteResult(String studentId, String examId) {
		resultEAO.deleteResult(studentId, examId);
	}
	
	public Result findResult(ResultId resultId) {
		return resultEAO.findResult(resultId);
	}
	
	public List<StudentStudy> findAllStudentStudy(){
		return personEAO.findAllStudentStudy();
	}
	public List<StudentStudy> findAllStudentStudyByStudentId(String id) {
		return personEAO.findAllStudentStudyByStudentId(id);
	}
	public String generateExamId() {
		return examEAO.generateId();
	}
	public List<Exam> findExamsByStudentId(String studentId) {
		return examEAO.findExamsByStudentId(studentId);
	}
}
