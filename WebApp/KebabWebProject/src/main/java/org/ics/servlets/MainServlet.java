package org.ics.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import java.util.List;

import javax.ejb.EJB;
import javax.json.JsonException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.ejb.Course;
import org.ics.ejb.Exam;
import org.ics.ejb.Result;
import org.ics.ejb.Student;
import org.ics.ejb.StudentStudy;
import org.ics.ejb.StudentStudy;
import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeLocal facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		String action = request.getParameter("action");

		// Get hidden field
		try {
			if (action == null) {
				url = "/Home.jsp";
			} else if (action.equals("Home")) {
				url = "/Home.jsp";
			} else if (action.equals("addResult")) {
				// String studentId = request.getParameter("txtId");
				List<Student> studentListResult = facade.findAllStudents();
				// List<Exam> examListResult = facade.findExamsByStudentId(studentId);
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				// request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);
				url = "/FindStudentForResult.jsp";
			} else if (action.equals("findResult")) {
				List<Student> studentListResult = facade.findAllStudents();
				List<Exam> examListResult = facade.findAllExams();
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);
				url = "/FindDeleteUpdateResult.jsp";
			} else if (action.equals("showResult")) {
				List<Student> studentListResult = facade.findAllStudents();
				List<Exam> examListResult = facade.findAllExams();
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);

				String studentId = request.getParameter("studentId");
				String examId = request.getParameter("examId");
				Result r = facade.findResult(studentId, examId);
				request.setAttribute("result", r);
				url = "/ShowResult";
			} else if (action.equals("Update Result")) {
				List<Student> studentListResult = facade.findAllStudents();
				List<Exam> examListResult = facade.findAllExams();
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);

				url = "/FindDeleteUpdateResult";
			} else if (action.equals("manageCourse")) {
				List<Student> studentListStudentSudy = facade.findAllStudents();
				List<Course> courseListStudentStudy = facade.findAllCourses();
				List<StudentStudy> studentStudyList = facade.findAllStudentStudy();

				request.setAttribute("studentList", studentListStudentSudy);
				request.setAttribute("courseList", courseListStudentStudy);
				request.setAttribute("studentStudyList", studentStudyList);

				url = "/StudentStudy.jsp";
			} else if (action.equals("Remove Student from Course")) {
				List<Student> studentListStudentSudy = facade.findAllStudents();
				List<Course> courseListStudentStudy = facade.findAllCourses();
				List<StudentStudy> studentStudyList = facade.findAllStudentStudy();

				request.setAttribute("studentList", studentListStudentSudy);
				request.setAttribute("courseList", courseListStudentStudy);
				request.setAttribute("studentStudyList", studentStudyList);

				url = "/StudentStudy.jsp";

			} else if (action.equals("addExam")) {
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				List<Course> courseList = facade.findAllCourses();
				request.setAttribute("courseList", courseList);

				url = "/Exam.jsp";
			} else if (action.equals("findExam")) {
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				List<Course> courseList = facade.findAllCourses();
				request.setAttribute("courseList", courseList);

				url = "/FindExam.jsp";
			} else if (action.equals("Update Exam")) {

				List<Course> courseList = facade.findAllCourses();
				request.setAttribute("courseList", courseList);
				System.out.println("hej hej hej");
				url = "/ShowExam.jsp";

			} else if (action.equals("findStudent")) {
				List<Student> studentList = facade.findAllStudents();
				request.setAttribute("studentList", studentList);
				url = "/FindStudent.jsp";
			} else if (action.equals("addStudent")) {

				List<Student> studentList = facade.findAllStudents();
				request.setAttribute("studentList", studentList);
				url = "/AddStudent.jsp";

			} else if (action.equals("about")) {
				url = "/About.jsp";
			} else {
				url = "/Home.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error",
					"An error occurred while processing your request, Error message: " + e.getMessage());
			url = "/ErrorPage.jsp";
		}
		System.out.println(url);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		// Get hidden field
		String action = request.getParameter("action");
		try {
			if (action.equals("Home")) {
				url = "/Home.jsp";
			} else if (action.equals("addStudent")) {
				String firstName = request.getParameter("txtFirstName");
				String lastName = request.getParameter("txtLastName");
				String fullName = firstName + " " + lastName;
				String address = request.getParameter("txtAddress");
				// String id = facade.generateStudentId();
				String id = request.getParameter("txtId");
				Student student = new Student(id, fullName, address);
				facade.createStudent(student);
				List<Student> studentList = facade.findAllStudents();
				request.setAttribute("studentList", studentList);
				url = "/AddStudent.jsp";

			} else if (action.equals("findStudent")) {
				String id = request.getParameter("txtId");

				List<Result> resultList = facade.findAllResultsByStudentId(id);
				List<StudentStudy> studyList = facade.findAllStudentStudyByStudentId(id);
				request.setAttribute("studyList", studyList);
				request.setAttribute("resultList", resultList);
				Student s = facade.findByStudentId(id);
				if (s != null) {
					request.setAttribute("student", s);
					System.out.println(id);
					url = "/ShowStudent.jsp";
				} else {
					request.setAttribute("error",
							"An error occurred while processing your request, Student could not be found! ");
					url = "/ErrorPage.jsp";
				}

			} else if (action.equals("Delete student")) {
				String id = request.getParameter("txtId");
				List<Result> studentResults = facade.findAllResult();
			    for (Result result : studentResults) {
			        facade.deleteResult(result.getResultId().getStudentId(), result.getResultId().getExamId());
			    }
				facade.deleteStudent(id);
				List<Student> studentList = facade.findAllStudents();
				request.setAttribute("studentList", studentList);
				url = "/FindStudent.jsp";
			} else if (action.equals("Update student")) {
				String id = request.getParameter("txtId");
				Student s = facade.findByStudentId(id);
				String name = request.getParameter("txtName");
				String address = request.getParameter("txtAddress");
				s.setStudentName(name);
				s.setAddress(address);

				facade.updateStudent(s);
				List<Student> studentList = facade.findAllStudents();
				request.setAttribute("studentList", studentList);
				url = "/FindStudent.jsp";

			} else if (action.equals("backFromFindStudent")) {

				List<Student> studentList = facade.findAllStudents();
				request.setAttribute("studentList", studentList);
				url = "/FindStudent.jsp";

			} else if (action.equals("addResult")) {
				String studentId = request.getParameter("txtId");
				String examId = request.getParameter("examId");
				String points = request.getParameter("points");
				int pointsValue = Integer.parseInt(points);
				Result r = new Result();
				Exam e = facade.findByExamId(examId);
				Student s = facade.findByStudentId(studentId);
				r.setResultId(studentId, examId);
				r.setPoints(pointsValue);
				r.setExam(e);
				r.setStudent(s);
				facade.createResult(r);

				List<Student> studentListResult = facade.findAllStudents();
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				request.setAttribute("resultList", resultList);
				url = "/FindStudentForResult.jsp";
			} else if (action.equals("Delete Result")) {
				String studentId = request.getParameter("studentId");
				String examId = request.getParameter("examId");

				try {
					if (examId != null && studentId != null) {
						Result r = facade.findResult(studentId, examId);
						if (r != null) {
							facade.deleteResult(studentId, examId);
							List<Student> studentListResult = facade.findAllStudents();
							List<Exam> examListResult = facade.findAllExams();
							List<Result> resultList = facade.findAllResult();
							request.setAttribute("studentList", studentListResult);
							request.setAttribute("examList", examListResult);
							request.setAttribute("resultList", resultList);
							url = "/FindDeleteUpdateResult.jsp";
						} else {
							throw new Exception("Result not found for provided Student ID and Exam ID");
						}
					}
				} catch (Exception e) {
					// handle the exception by setting an error message in request scope
					request.setAttribute("errorMessage", e.getMessage());
					url = "/ErrorPage.jsp"; // you can redirect to an error page if you have one
				}

			} else if (action.equals("Update Result")) {
				String studentId = request.getParameter("studentId");
				String examId = request.getParameter("examId");
				String points = request.getParameter("points");

				if (studentId != null && examId != null && points != null) {

					int pointValue = Integer.parseInt(points);

					Result r = facade.findResult(studentId, examId);
					if (r != null) {
						r.setPoints(pointValue);
						facade.updateResult(r);
					}

					List<Student> studentListResult = facade.findAllStudents();
					List<Exam> examListResult = facade.findAllExams();
					List<Result> resultList = facade.findAllResult();
					request.setAttribute("studentList", studentListResult);
					request.setAttribute("examList", examListResult);
					request.setAttribute("resultList", resultList);
					url = "/FindDeleteUpdateResult.jsp";

				}

			} else if (action.equals("backToFindUpdateDeleteResult")) {
				List<Student> studentListResult = facade.findAllStudents();
				List<Exam> examListResult = facade.findAllExams();
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);
				url = "/FindDeleteUpdateResult.jsp";
			} else if (action.equals("backFromAddResult")) {
				List<Student> studentListResult = facade.findAllStudents();
				List<Exam> examListResult = facade.findAllExams();
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);
				url = "ResultAddView.jsp";
			} else if (action.equals("findResult")) {
				String examId = request.getParameter("examId");
				String studentId = request.getParameter("studentId");
				Result r = facade.findResult(studentId, examId);
				if (r != null) {
					request.setAttribute("result", r);
					url = "/ShowResult.jsp";
				} else {
					request.setAttribute("error",
							"An error occurred while processing your request, Result could not be found! ");
					url = "/ErrorPage.jsp";
				}
			} else if (action.equals("Add Student to Course")) {
				String studentId = request.getParameter("studentId");
				String courseId = request.getParameter("courseId");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");

				Date start = Date.valueOf(startDate);
				Date end = Date.valueOf(endDate);

				Course c = facade.findByCourseId(courseId);
				Student s = facade.findByStudentId(studentId);
				StudentStudy st = new StudentStudy();

				st.setCourse(c);
				st.setStudent(s);
				st.setEndDate(end);
				st.setStartDate(start);
				st.setId(studentId, courseId);

				facade.createStudentStudy(st);

				List<Student> studentListStudentSudy = facade.findAllStudents();
				List<Course> courseListStudentStudy = facade.findAllCourses();
				List<StudentStudy> studentStudyList = facade.findAllStudentStudy();

				request.setAttribute("studentList", studentListStudentSudy);
				request.setAttribute("courseList", courseListStudentStudy);
				request.setAttribute("studentStudyList", studentStudyList);

				url = "/StudentStudy.jsp";

			} else if (action.equals("Remove Student from Course")) {
				String studentId = request.getParameter("studentId");
				String courseId = request.getParameter("courseId");

				facade.deleteStudentStudy(studentId, courseId);

				List<Student> studentListStudentSudy = facade.findAllStudents();
				List<Course> courseListStudentStudy = facade.findAllCourses();
				List<StudentStudy> studentStudyList = facade.findAllStudentStudy();

				request.setAttribute("studentList", studentListStudentSudy);
				request.setAttribute("courseList", courseListStudentStudy);
				request.setAttribute("studentStudyList", studentStudyList);

				url = "/StudentStudy.jsp";
			}

			if (action.equals("addExam")) {
				Course course = new Course();
				String examId = facade.generateExamId();
				course = facade.findByCourseId(request.getParameter("courseId"));
				String room = request.getParameter("txtRoom");
				Date date = Date.valueOf(request.getParameter("txtExamDate"));
				int credit = Integer.parseInt(request.getParameter("txtCredits"));

				Exam exam = new Exam(examId, course, room, date, credit);

				facade.createExam(exam);
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				List<Course> courseList = facade.findAllCourses();
				request.setAttribute("courseList", courseList);

				url = "/Exam.jsp";
			} else if (action.equals("findExam")) {
				String id = request.getParameter("txtId");
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				Exam ex = facade.findByExamId(id);
				request.setAttribute("exam", ex);
				List<Course> courseList = facade.findAllCourses();
				request.setAttribute("courseList", courseList);
				if (ex != null) {
					url = "/ShowExam.jsp";
				} else {
					request.setAttribute("error",
							"An error occurred while processing your request, Exam could not be found! ");
					url = "/ErrorPage.jsp";
				}
			} else if (action.equals("Delete Exam")) {
				String id = request.getParameter("txtId");
				facade.deleteExam(id);
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				url = "/FindExam.jsp";
			} else if (action.equals("Update Exam")) {
				String id = request.getParameter("txtId");
				System.out.println(id);
				Exam ex = facade.findByExamId(id);
				String room = request.getParameter("txtRoom");
				List<Course> courseList = facade.findAllCourses();
				request.setAttribute("courseList", courseList);
				Course course = facade.findByCourseId(request.getParameter("courseId"));
				Date examDate = Date.valueOf(request.getParameter("txtExamDate"));
				int credit = Integer.parseInt(request.getParameter("txtCredits"));
				ex.setCourse(course);
				ex.setCredit(credit);
				ex.setExamDate(examDate);
				ex.setRoom(room);
				facade.updateExam(ex);
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				url = "/FindExam.jsp";
			} else if (action.equals("backFromFindExam")) {
				List<Exam> examList = facade.findAllExams();
				request.setAttribute("examList", examList);
				url = "/FindExam.jsp";
			} else if (action.equals("sendTicket")) {
				String email = request.getParameter("txtEmail");
				String issueRegarding = request.getParameter("issueRegarding");
				String subject = request.getParameter("txtSubject");
				System.out.println("Ticket: " + email + " -Type: " + issueRegarding + " -Subject: " + subject);
				url = "/TicketAccepted.jsp";
			} else if (action.equals("backToSupport")) {
				url = "/About.jsp";
			} else if (action.equals("findStudentForResult")) {
				String studentId = request.getParameter("studentId");
				List<Result> resultList = facade.findAllResultsByStudentId(studentId);
				request.setAttribute("resultList", resultList);
				List<Exam> examList = facade.findExamsByStudentId(studentId);
				request.setAttribute("examList", examList);
				Student s = facade.findByStudentId(studentId);
				request.setAttribute("student", s);
				url = "/ResultAddView.jsp";
			} else if (action.equals("backFromAddResult")) {
				// String studentId = request.getParameter("txtId");
				List<Student> studentListResult = facade.findAllStudents();
				// List<Exam> examListResult = facade.findExamsByStudentId(studentId);
				List<Result> resultList = facade.findAllResult();
				request.setAttribute("studentList", studentListResult);
				// request.setAttribute("examList", examListResult);
				request.setAttribute("resultList", resultList);
				url = "/FindStudentForResult.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			String errorText = null;
			if (e.getMessage().contains("ARJUNA016053")) {
				if (action.equals("addStudent")) {
					errorText = "A student with this ID already exists, please try again.";
				} else if (action.equals("addExam")) {
					errorText = "The autogenerated ID already exists (An exam with this ID already exists), please try again.";
				} else if (action.equals("addResult")) {
					errorText = "A result for this student on this exam already exists, please try again.";
				} else if (action.equals("Add Student to Course")) {
					errorText = "The student is already studying on the course, please try again.";
				}
				request.setAttribute("error",
						"An error occurred while processing your request, Error message: " + errorText);
			} else {
				request.setAttribute("error",
						"An error occurred while processing your request. Please report this error message to SkånesKebabTekniker-  Error message: "
								+ e.getMessage());
			}
			url = "/ErrorPage.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
