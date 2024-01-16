<%@ page import="org.ics.ejb.Student"%>
<%@ page import="org.ics.ejb.Result"%>
<%@ page import="org.ics.ejb.Exam"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Show Result</title>
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
			Result r = (Result) request.getAttribute("result");
			%><h1>Result:</h1>

			<form action="/KebabWebProject/MainServlet" method="post">
				<fieldset class="inputField">
					<legend>Result Points</legend>
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<tr>
							<td>
								<% Exam e = r.getExam(); %>
								<% Student s = r.getStudent(); %>
								<input type="hidden" name="txtId" value="<%=r.getResultId()%>"> 
								<input type="hidden" name="examId" value="<%=r.getExamId(e)%>">
                    			<input type="hidden" name="studentId" value="<%=r.getStudentId(s)%>">
								<label for="points">Points:</label>
								<input type="number" name="points" min="0" max="100"
								value="<%=r.getPoints()%>" step="1"> <br> <input
								type="submit" name="action" value="Update Result"> <input
								type="submit" name="action" value="Delete Result"></td>

						</tr>
					</table>
				</fieldset>
			</form>
		</div>
		<div class="contentTable">
			<table class="styled-table">
				<caption>Result Information</caption>
				<thead>
					<tr>
						<th>Exam ID</th>
						<th>Student ID</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=r.getExamId(e)%></td>
						<td><%=r.getStudentId(s)%></td>
					</tr>
				</tbody>
			</table>
		</div>
		<form action="/KebabWebProject/MainServlet" method="post">
			<input type="submit" name="submit" value="Back"> <input
				name="action" value="backToFindUpdateDeleteResult" type="hidden">
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