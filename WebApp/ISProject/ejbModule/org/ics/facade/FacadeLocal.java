package org.ics.facade;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Course;
import org.ics.ejb.Exam;
import org.ics.ejb.Result;
import org.ics.ejb.ResultId;
import org.ics.ejb.Student;
import org.ics.ejb.StudentStudy;

@Local
public interface FacadeLocal {
	public Student createStudent(Student student);

	public Student updateStudent(Student student);

	public void deleteStudent(String id);

	public Student findByStudentId(String id);

	public List<Student> findAllStudents();

	public String generateStudentId();

	public Exam findByExamId(String id);

	public Exam createExam(Exam exam);

	public StudentStudy createStudentStudy(StudentStudy studentStudy);

	public StudentStudy findByStudentStudyId(String StudentId, String CourseId);

	public List<StudentStudy> findAllStudentStudyByStudentId(String id);

	public void deleteStudentStudy(String StudentId, String CourseId);

	public Exam updateExam(Exam exam);

	public void deleteExam(String id);

	public Course findByCourseId(String courseId);

	public List<Exam> findAllExams();

	public List<Course> findAllCourses();

	public void deleteResult(String studentId, String examId);

	public Result updateResult(Result result);

	public Result createResult(Result result);

	public Result findResult(String studentId, String examId);

	public List<Result> findAllResult();

	public List<Student> findAllStudent();

	public List<Result> findAllResultsByStudentId(String id);

	public Result findResult(ResultId resultId);

	public List<StudentStudy> findAllStudentStudy();

	public String generateExamId();

	public List<Exam> findExamsByStudentId(String studentId);
}
