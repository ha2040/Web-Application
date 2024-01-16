<%@ page import="org.ics.ejb.Exam"%>
<%@ page import="org.ics.ejb.Result"%>
<%@ page import="org.ics.ejb.Course"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="js/JavaScript.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
	$(function() {
		// Initialize datepicker
		$("#examDate").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>
<meta charset="ISO-8859-1">
<title>Show Exam</title>
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
			Exam ex = (Exam) request.getAttribute("exam");
			%><h1>Exam:</h1>

			<form action="/KebabWebProject/MainServlet" method="post">
				<fieldset class="inputField">
					<legend>Exam information</legend>
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<tr>
							<td><input type="text" name="txtId"
								value="<%=ex.getExamId()%>" hidden> <select
								name="courseId" style="margin-left: 5px;">
									<%
									List<Course> courseList = (List<Course>) request.getAttribute("courseList");
									if (courseList != null && !courseList.isEmpty()) {
										for (Course course : courseList) {
									%>
									<option value="<%=ex.getCourse().getCourseId()%>"><%=course.getCourseId()%>
										-
										<%=course.getDescription()%></option>
									<%
									}
									}
									%>
							</select> <input type="number" name="txtCredits" min="1" max="30"
								value="<%=ex.getCredit()%>"> <input type="text"
								name="txtRoom" size="25" maxlength="25" placeholder="Room"
								value="<%=ex.getRoom()%>" required autocomplete="off"> <input type="text"
								name="txtExamDate" size="25" maxlength="25"
								placeholder="Exam Date (yyyy-mm-dd)" id="examDate"
								value="<%=ex.getExamDate()%>" readonly> <input
								type="submit" name="action" value="Update Exam" /> <input
								type="submit" name="action" value="Delete Exam" /></td>
						</tr>

					</table>
				</fieldset>
			</form>
		</div>

		<form action="/KebabWebProject/MainServlet" method="post">
			<input type="submit" name="submit" value="Back"> <input
				name="action" value="backFromFindExam" type="hidden">
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