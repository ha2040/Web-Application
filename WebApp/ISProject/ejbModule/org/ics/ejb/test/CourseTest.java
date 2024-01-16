package org.ics.ejb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.ics.ejb.Course;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {
	private String expectedCourseId;
	private String expectedFacultyId;
	private String expectedDescription;
	private String expectedEmpId;
	private int expectedCredits;
	private Course c1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		expectedCourseId = "C001";
		expectedFacultyId = "F001";
		expectedDescription = "Test";
		expectedEmpId = "testid";
		expectedCredits = 30;
		
		c1 = new Course(expectedCourseId, expectedFacultyId, expectedDescription, expectedEmpId, expectedCredits);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetCourseId() {
		assertEquals(expectedCourseId, c1.getCourseId());
	}

	@Test
	final void testSetCourseId() {
		String expectedC2 = "C002";
		c1.setCourseId(expectedC2);
		assertEquals(expectedC2, c1.getCourseId());
	}

	@Test
	final void testGetFacultyId() {
		assertEquals(expectedFacultyId, c1.getFacultyId());
	}

	@Test
	final void testSetFacultyId() {
		String expectedFacultyId2 = "Fake";
		c1.setFacultyId(expectedFacultyId2);
		assertEquals(expectedFacultyId2, c1.getFacultyId());
	}

	@Test
	final void testGetDescription() {
		assertEquals(expectedDescription, c1.getDescription());
	}

	@Test
	final void testSetDescription() {
		String expectedDescription2 = "Fake";
		c1.setDescription(expectedDescription2);
		assertEquals(expectedDescription2, c1.getDescription());
	}

	@Test
	final void testGetEmpId() {
		assertEquals(expectedEmpId, c1.getEmpId());
	}

	@Test
	final void testSetEmpId() {
		String expectedEmpId2 = "Fake";
		c1.setEmpId(expectedEmpId2);
		assertEquals(expectedEmpId2, c1.getEmpId());
	}

	@Test
	final void testGetCredits() {
		assertEquals(expectedCredits, c1.getCredits());
	}

	@Test
	final void testSetCredits() {
		int expectedCredits2 = 100;
		c1.setCredits(expectedCredits2);
		assertEquals(expectedCredits2, c1.getCredits());
	}

}
