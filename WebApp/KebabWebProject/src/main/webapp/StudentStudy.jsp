<%@ page import="org.ics.ejb.Student"%>
<%@ page import="org.ics.ejb.StudentStudy"%>
<%@ page import="org.ics.ejb.Course"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css"
	type="text/css">
<script src="js/JavaScript.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<meta charset="ISO-8859-1">
<title>Find student</title>

<script>
	$(function() {
		// Initialize datepicker             
		$("#examDate").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>
</head>
<body>
	<div class="topNav">
		<nav>
			<ul>
				<li><a href="/KebabWebProject/MainServlet?action=Home">Home</a></li>
				<li><a href="#">Student</a>
					<ul>
						<li><a href="/KebabWebProject/MainServlet?action=addStudent">Add
								and view</a></li>
						<li><a
							href="/KebabWebProject/MainServlet?action=manageCourse">Add
								student to a course</a></li>
						<li><a href="/KebabWebProject/MainServlet?action=findStudent">Search,
								update, and delete</a></li>
					</ul></li>
				<li><a href="#">Exam</a>
					<ul>
						<li><a href="/KebabWebProject/MainServlet?action=addExam">Add
								and view</a></li>
						<li><a href="/KebabWebProject/MainServlet?action=findExam">Search,
								update, and delete</a></li>
					</ul></li>
				<li><a href="#">Result</a>
					<ul>
						<li><a href="/KebabWebProject/MainServlet?action=addResult">Add
								and view</a></li>
						<li><a href="/KebabWebProject/MainServlet?action=findResult">Search,
								update, and delete</a></li>
					</ul></li>
				<li><a href="/KebabWebProject/MainServlet?action=about">About/Support</a></li>
			</ul>
		</nav>
	</div>
	<div class="contentBody">
		<div class="contentInput">

			<h1>Add or remove student from course:</h1>
			<form action="/KebabWebProject/MainServlet" method="post"
				id=studentStudyForm>
				<fieldset class="inputField">
					<legend>Student and Course Selection</legend>
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<tr>
							<td><label for="studentId">Student ID:</label> <select
								id="studentId" name="studentId">
									<%
									List<Student> studentList = (List<Student>) request.getAttribute("studentList");
									if (studentList != null) {
										for (Student student : studentList) {
									%>
									<option value="<%=student.getStudentId()%>"><%=student.getStudentId()%>
										-
										<%=student.getStudentName()%></option>
									<%
									}
									}
									%>
							</select></td>
							<td><label for="courseId">Course ID:</label> <select
								id="courseId" name="courseId">
									<%
									List<Course> courseList = (List<Course>) request.getAttribute("courseList");
									if (courseList != null) {
										for (Course course : courseList) {
									%>
									<option value="<%=course.getCourseId()%>"><%=course.getCourseId()%>
										-
										<%=course.getDescription()%></option>
									<%
									}
									}
									%>
							</select></td>
						</tr>
						<tr>
							<td><label for="startDate">Start Date:</label> <input
								type="date" id="startDate" name="startDate"></td>
							<td><label for="endDate">End Date:</label> <input
								type="date" id="endDate" name="endDate"></td>
						</tr>
						<tr>
							<td><input type="submit" name="action"
								value="Add Student to Course" id="addStudentStudy"
								onclick="return validateDates()" /></td>
							<td><input type="submit" name="action"
								value="Remove Student from Course" id="deleteStudentStudy" /></td>
						</tr>
					</table>
				</fieldset>
				<input name="action" value="manageCourse" type="hidden">
			</form>

		</div>
		<div class="contentTable">
			<%
			List<StudentStudy> studentStudyList = (List<StudentStudy>) request.getAttribute("studentStudyList");
			int totalStudentStudy = studentStudyList.size();
			if (studentStudyList != null && !studentStudyList.isEmpty()) {
			%>
			<table class="styled-table">
				<caption>
					Total Students Registered To Course:
					<%=totalStudentStudy%></caption>
				<thead>
					<tr>
						<th>StudentId</th>
						<th>CourseId</th>
						<th>Start Date</th>
						<th>End Date</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (StudentStudy s : studentStudyList) {
						Student student = s.getStudent();
						Course course = s.getCourse();
					%>
					<tr>
						<td><%=s.getStudentId(student)%></td>
						<td><%=s.getCourseId(course)%></td>
						<td><%=s.getStartDate()%></td>
						<td><%=s.getEndDate()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
