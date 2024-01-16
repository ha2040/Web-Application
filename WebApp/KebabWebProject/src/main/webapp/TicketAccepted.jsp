<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Ticket sent</title>
</head>
<body>
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
							<li><a
								href="/KebabWebProject/MainServlet?action=findStudent">Search,
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
		<h1>Your ticket has been sent, thank you for using our system!</h1>
	</div>
	<form action="/KebabWebProject/MainServlet" method="post">
			<input type="submit" name="submit" value="Back"> <input
				name="action" value="backToSupport" type="hidden">
		</form>

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