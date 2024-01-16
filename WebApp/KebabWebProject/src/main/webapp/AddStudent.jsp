<%@ page import="org.ics.ejb.Student"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Student</title>
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
			<h1>Add student:</h1>
			<form action="/KebabWebProject/MainServlet" method="post"
				onsubmit="return validateFormStudent();">
				<fieldset class="inputField">
					<legend>Student information</legend>
					<table cellspacing="0" cellpadding="0" border="0" align="left">
						<tr>
							<td><input type="text" name="txtId" id="txtId" size="25"
								maxlength="25" placeholder="SSN" required autocomplete="off">
							<div id="txtIdMsg"></div> <input type="text" name="txtFirstName"
								id="txtFirstName" size="25" maxlength="25"
								placeholder="First Name" required autocomplete="off"> <input type="text"
								name="txtLastName" id="txtLastName" size="25" maxlength="25"
								placeholder="Last Name" required autocomplete="off"> <input type="text"
								name="txtAddress" id="txtAddress" size="25" maxlength="25"
								placeholder="Address" required autocomplete="off"> <input type="submit"
								id="btnAddStudent" name="submit" value="Add Student"></td>
						</tr>

					</table>
				</fieldset>
				<input name="action" value="addStudent" type="hidden">
			</form>
		</div>
		<div class="contentTable">
			<%
			List<Student> studentList = (List<Student>) request.getAttribute("studentList");
			int totalStudentList = studentList.size();
			if (studentList != null && !studentList.isEmpty()) {
			%>
			<table id="studentTable" class="styled-table">
				<caption>Total Student: <%=totalStudentList %></caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Address</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Student student : studentList) {
					%>
					<tr>
						<td><%=student.getStudentId()%></td>
						<td><%=student.getStudentName()%></td>
						<td><%=student.getAddress()%></td>
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