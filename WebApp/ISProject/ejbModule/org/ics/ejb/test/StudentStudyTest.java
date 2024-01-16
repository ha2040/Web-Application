package org.ics.ejb.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.ics.eao.CourseEAOLocal;
import org.ics.eao.StudentEAOLocal;
import org.ics.ejb.Course;
import org.ics.ejb.Student;
import org.ics.ejb.StudentStudy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentStudyTest {
	
	private Date expectedStartDate;
	private Date expectedEndDate;
	private Student expectedStudent = new Student("id", "name", "addy");
	private Course expectedCourse = new Course("test", "test", "test", "test", 4);
	private StudentStudy ss1;
	private StudentEAOLocal sLocal;
	private CourseEAOLocal cLocal; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		expectedStartDate = new Date(1, 1, 2023);
		expectedEndDate = new Date(2, 2, 2023);
		ss1 = new StudentStudy(expectedStartDate, expectedEndDate, expectedStudent, expectedCourse);
	}

	@AfterEach
	void tearDown() throws Exception {
		ss1 = null;
	}

	@Test
	final void testGetStartDate() {
		assertEquals(expectedStartDate, ss1.getStartDate());
	}

	@Test
	final void testSetStartDate() {
		@SuppressWarnings("deprecation")
		Date expectedStartDate2 = new Date(5, 5, 2023);
		
		ss1.setStartDate(expectedStartDate2);
		
		assertEquals(expectedStartDate2, ss1.getStartDate());
	}

	@Test
	final void testGetEndDate() {
		assertEquals(expectedEndDate, ss1.getEndDate());
	}

	@Test
	final void testSetEndDate() {
		@SuppressWarnings("deprecation")
		Date expectedEndDate2 = new Date(2, 3, 2023);
		ss1.setEndDate(expectedEndDate2);
		assertEquals(expectedEndDate2, ss1.getEndDate());
	}

	@Test
	final void testGetCourse() {
		assertEquals(expectedCourse, ss1.getCourse());
	}

	@Test
	final void testSetCourse() {
		Course expectedC2 = new Course("test", "test", "test", "test", 4);
		ss1.setCourse(expectedC2);
		assertEquals(expectedC2, ss1.getCourse());
	}

	@Test
	final void testGetStudent() {
		assertEquals(expectedStudent, ss1.getStudent());
	}

	@Test
	final void testSetStudent() {
		Student expectedS2 = new Student("id2", "name", "addy");
		ss1.setStudent(expectedS2);
		assertEquals(expectedS2, ss1.getStudent());
	}


	}


