<%@ page import="org.ics.ejb.Student"%>
<%@ page import="org.ics.ejb.Result"%>
<%@ page import="java.util.List"%>
<%@ page import="org.ics.ejb.StudentStudy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Show Student</title>
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
			<%
			Student s = (Student) request.getAttribute("student");
			%><h1>Student:</h1>

			<form action="/KebabWebProject/MainServlet" method="post">
				<fieldset class="inputField">
					<legend>Student information</legend>
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<tr>
							<td><input type="hidden" name="txtId"
								value="<%=s.getStudentId()%>"><label for="name">Name</label><input
								type="text" name="txtName" size="25" maxlength="25"
								value="<%=s.getStudentName()%>" required
								pattern="^[A-Za-zÅÄÖåäö\s]+$"
								oninvalid="this.setCustomValidity('Please enter only alphabetic characters')"
								oninput="this.setCustomValidity('')" autocomplete="off"> <label
								for="address">Address</label><input type="text"
								name="txtAddress" size="25" maxlength="25"
								value="<%=s.getAddress()%>" autocomplete="off"> <input type="submit"
								name="action" id="btnUpdateStudent" value="Update student" /> <input
								type="submit" name="action" id="btnDeleteStudent"
								value="Delete student" /></td>
						</tr>

					</table>
				</fieldset>
			</form>
		</div>
		<div class="contentTable">
			<%
			List<Result> resultList = (List<Result>) request.getAttribute("resultList");
			int totalResultList = resultList.size();
			if (resultList != null && !resultList.isEmpty()) {
			%>
			<table class="styled-table">
				<caption>Exam results: <%=totalResultList %></caption>
				<thead>
					<tr>
						<th>Exam ID</th>
						<th>Result</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Result result : resultList) {
					%>
					<tr>
						<td><%=result.getResultId().getExamId()%></td>
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
			<%
			List<StudentStudy> studyList = (List<StudentStudy>) request.getAttribute("studyList");
			int totalStudyList = studyList.size();
			if (studyList != null && !studyList.isEmpty()) {
			%>
			<table class="styled-table">
			<caption>Studying courses: <%=totalStudyList %></caption>
				<thead>
					<tr>
						<th>Course ID</th>
						<th>Start Date</th>
						<th>End Date</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (StudentStudy study : studyList) {
					%>
					<tr>
						<td><%=study.getStudentStudyId().getCourseId()%></td>
						<td><%=study.getStartDate()%></td>
						<td><%=study.getEndDate()%></td>
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
		<form action="/KebabWebProject/MainServlet" method="post">
			<input type="submit" name="submit" value="Back"> <input
				name="action" value="backFromFindStudent" type="hidden">
		</form>
	</div>
	<a href="#top" id="goToTop"> <img src="css/arrow.png"
		alt="travel up link" style="width: 50px;">
	</a>
	<footer>
			<div class="footerContainer">
				<div class="row">
					<div class="col-md-6">
						<h3>About Us</h3>
						<p>We are a company that provides high-quality information
							systems.</p>
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