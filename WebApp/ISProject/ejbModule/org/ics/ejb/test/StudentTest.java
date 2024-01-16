package org.ics.ejb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.ics.ejb.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	
	private String expectedStudentId;
	private String expectedStudentName;
	private String expectedAddress;
	private Student s1;
	private Student s2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		expectedStudentId = "S003";
		expectedStudentName = "Test";
		expectedAddress = "Testgata";
		
		s1 = new Student(expectedStudentId, expectedStudentName,expectedAddress);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = null;
		s2 = null;
	}


	@Test
	final void testGetStudentId() {
		assertEquals(expectedStudentId, s1.getStudentId());
	}

	@Test
	final void testSetStudentId() {
		String expectedStudentId2 = "S001";
		s1.setStudentId(expectedStudentId2);
		assertEquals(expectedStudentId2, s1.getStudentId());
	}

	@Test
	final void testGetStudentName() {
		assertEquals(expectedStudentName, s1.getStudentName());
	}

	@Test
	final void testSetStudentName() {
		String expectedStudentName2 = "Test2";
		s1.setStudentName(expectedStudentName2);
		assertEquals(expectedStudentName2, s1.getStudentName());
	}

	@Test
	final void testGetAddress() {
		assertEquals(expectedAddress, s1.getAddress());
	}

	@Test
	final void testSetAddress() {
		String expectedAddress2 = "TestGata2";
		s1.setAddress(expectedAddress2);
		assertEquals(expectedAddress2, s1.getAddress());
	}

}
