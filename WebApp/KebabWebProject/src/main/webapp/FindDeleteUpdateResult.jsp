<%@ page import="org.ics.ejb.Result"%>
<%@ page import="org.ics.ejb.Exam"%>
<%@ page import="org.ics.ejb.Student"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Find result</title>
</head>
<header>
	<div class="topNav">
		<nav>
			<img src="css/logo.PNG" alt="Website logo" id="webLogo">
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
</header>
<body>
	<a id="top"></a>
	<div class="contentBody">
		<div class="contentInput">
			<h1>Find and update or delete result:</h1>
			<form action="/KebabWebProject/MainServlet" method="post">
		<fieldset class="inputField">
			<legend>Result information</legend>
			<table cellspacing="0" cellpadding="0" border="0" align="left">
				<tr>
					<td><label for="studentId">StudentID:</label> <select
						name="studentId">
							<%
							List<Exam> examList = (List<Exam>) request.getAttribute("examList");
							List<Student> studentList = (List<Student>) request.getAttribute("studentList");
							if (studentList != null && !studentList.isEmpty() && examList != null && !examList.isEmpty()) {
							%>
							<%
							for (Student student : studentList) {
							%>
							<option value="<%=student.getStudentId()%>"><%=student.getStudentId()%>
								-
								<%=student.getStudentName()%></option>
							<%
							}
							%>
							<%
							}
							%>
					</select></td>
					<td><label for="examId" style="margin-left:10px;">ExamID:</label> <select name="examId" style="margin-left:10px;">
							<%
							if (studentList != null && !studentList.isEmpty() && examList != null && !examList.isEmpty()) {
							%>
							<%
							for (Exam exam : examList) {
							%>
							<option value="<%=exam.getExamId()%>"><%=exam.getExamId()%>
								-
								<%=exam.getCourse().getDescription()%></option>
							<%
							}
							%>
							<%
							}
							%>

					</select></td>
					<td><input type="submit" name="submit" value="Find Result" style="margin-top:22px; margin-left: 20px;" />
					</td>
				</tr>
			</table>
		</fieldset>
		<input name="action" value="findResult" type="hidden">
	</form>
		</div>
		<div class="contentTable">
			<%
			List<Result> resultList = (List<Result>) request.getAttribute("resultList");
			int totalResult = resultList.size();
			if (resultList != null && !resultList.isEmpty()) {
			%>
			<table class="styled-table">
			<caption> Total Results: <%= totalResult %></caption>
				<thead>
					<tr>
						<th>StudentID</th>
						<th>ExamID</th>
						<th>Points</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Result result : resultList) {
						Student s = result.getStudent();
						Exam e = result.getExam();
					%>
					<tr>
						<td><%=result.getStudentId(s)%></td>
						<td><%=result.getExamId(e)%></td>
						<td><%=result.getPoints()%></td>
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
	<a href="#top" id="goToTop"> <img src="css/arrow.png"
		alt="travel up link" style="width: 50px;">
	</a>
	<footer>
  <div class="footerContainer">
    <div class="row">
      <div class="col-md-6">
        <h3>About Us</h3>
        <p>We are a company that provides high-quality information systems.</p>
      </div>
      <div class="col-md-6">
        <h3>Contact Us</h3>
        <ul>
          <li>Email: skaneskebabtekniker@gmail.com</li>
          <li>Phone: 555-555-5555</li>
          <li>Address: 123 Main St, Anytown USA</li>
        </ul>
      </div>
    </div>
  </div>
</footer>
</body>
</html>
