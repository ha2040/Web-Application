<%@ page import="org.ics.ejb.Student"%>
<%@ page import="java.util.List"%>
<%@ page import="org.ics.ejb.Result"%>
<%@ page import="org.ics.ejb.Exam"%>
<%@ page import="org.ics.ejb.StudentStudy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css"
	type="text/css">
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Add result</title>
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
			%>
			<h1>Add and view result</h1>
			<form action="/KebabWebProject/MainServlet" method="post">
				<fieldset class="inputField">
					<legend>Result information</legend>
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<tr>
							<td><input type="hidden" name="txtId"
								value="<%=s.getStudentId()%>"></td>
							<td><label for="examId" style="margin-left: 10px">Exam:</label>
								<select name="examId" style="margin-left: 10px;">
									<%
									List<Exam> examList = (List<Exam>) request.getAttribute("examList");
									if (examList != null && !examList.isEmpty()) {
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
							<td><label for="points" style="margin-left: 30px; position: absolute; top: 255px">Points:</label>
								<input type="number" name="points" min="0" max="100" required autocomplete="off"
								style="margin: auto; margin-top: 7px; margin-left:30px"></td>
							<td><input type="submit" name="submit" value="Add Result"
								style="margin: auto; margin-top: 7px; margin-left: 20px;"></td>
						</tr>

					</table>
				</fieldset>
				<input name="action" value="addResult" type="hidden">
			</form>

		</div>
		<div class="contentTable">
			<%
			List<Result> resultList = (List<Result>) request.getAttribute("resultList");
			int totalResultList = resultList.size();
			if (resultList != null && !resultList.isEmpty()) {
			%>
			<table class="styled-table">
				<caption>
					Exam results:
					<%=totalResultList%></caption>
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
			<form action="/KebabWebProject/MainServlet" method="post">
			<input type="submit" name="submit" value="Back"> <input
				name="action" value="backFromAddResult" type="hidden">
		</form>
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
