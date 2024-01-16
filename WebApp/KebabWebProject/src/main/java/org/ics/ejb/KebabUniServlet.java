package org.ics.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class KebabUniServlet
 */
@WebServlet("/KebabUniServlet")
public class KebabUniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeLocal facade;

	public KebabUniServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * PrintWriter out = response.getWriter(); Student s = new Student();
		 * s.setStudentId("102"); s.setStudentName("Gamer boy");
		 * s.setAddress("GamerAddress19");
		 * 
		 * // facade.createStudent(s);
		 * 
		 * out.println("<!DOCTYPE html><html><head>");
		 * out.println("<title>HEJHEJHEJHEJ</title>");
		 * out.println("<meta charset=\"ISO-8859-1\">"); out.println("</head><body>");
		 * 
		 * out.println("<br>" + "***Show student***");
		 * 
		 * Student se = facade.findByStudentId("S001");
		 * se.setStudentName("Meow version 3"); facade.updateStudent(se); if (se !=
		 * null) { out.println("<br>"); out.println("Student ID: " + se.getStudentId());
		 * out.println("Name: " + se.getStudentName()); out.println("Address: " +
		 * se.getAddress()); out.println("<br>"); }
		 */
		
		
		}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}


}

