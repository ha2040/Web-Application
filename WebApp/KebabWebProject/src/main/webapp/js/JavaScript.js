$(document).ready(function() {
/*	window.onscroll = function() { scrollFunction() };


	function scrollFunction() {
		var goToTop = document.getElementById("goToTop");
		if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
			goToTop.style.display = "block";
			goToTop.style.position = "fixed";
		} else {
			goToTop.style.display = "none";
		}
	}*/
	$("#myForm").submit(function(event) {
		event.preventDefault();
		var mailTo = $("#email").val();
		var txtSubject = $("#subject").val();
		var issueRegarding = $("#issueRegarding").val();
		console.log(issueRegarding, txtSubject, mailTo);
		Swal.fire({
			title: "Success",
			text: "Your ticket has been sent, thank you!",
			icon: "success",
			confirmButtonText: "OK",
		});
		clearFieldsForm();
		var formData = {
			mailTo: mailTo,
			txtSubject: txtSubject,
			issueRegarding: issueRegarding
		};
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:8081/SpringTest",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(result) {
				if (result.status === "success") {
					alert(result.message);
				} else {
					alert("Error sending email. Please try again later.");
					console.log(result.status);
				}
			},

		});
	});
});

function clearFieldsForm() {
	$("#email").val("");
	$("#subject").val("");
	$("#issueRegardning").val("Report an issue");
}

function validateDates() {
	var startDate = document.getElementById("startDate").value;
	var endDate = document.getElementById("endDate").value;

	if (startDate == "" || endDate == "") {
		Swal.fire({
			title: "Error!",
			text: "Please fill in both start and end date!",
			icon: "error",
			confirmButtonText: "OK",
		});
		return false;
	}

	if (startDate > endDate) {
		Swal.fire({
			title: "Error!",
			text: "Start date cannot be after end date!",
			icon: "error",
			confirmButtonText: "OK",
		});
		return false;
	}
	return true;
}


function validateFormStudent() {
	var ssn = document.getElementById("txtId").value;
	var firstName = document.getElementById("txtFirstName").value;
	var lastName = document.getElementById("txtLastName").value;
	var address = document.getElementById("txtAddress").value;

	if (ssn == "" || firstName == "" || lastName == "" || address == "") {
		Swal.fire({
			title: "Error!",
			text: "All fields are required!",
			icon: "error",
			confirmButtonText: "OK",
		});
		return false;
	}

	if (!/^\d+$/.test(ssn)) {
		Swal.fire({
			title: "Error!",
			text: "Please enter only numbers for the SSN field!",
			icon: "error",
			confirmButtonText: "OK",
		});
		return false;
	}

	if (!/^[\p{L}]+$/u.test(firstName) || !/^[\p{L}]+$/u.test(lastName)) {
		Swal.fire({
			title: "Error!",
			text: "Please enter only alphabetic characters for the name fields!",
			icon: "error",
			confirmButtonText: "OK",
		});
		return false;
	}

	return true;
}
