package org.ics.eao;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Student;

/**
 * Session Bean implementation class StudentEAOImpl
 */
@Stateless
public class StudentEAOImpl implements StudentEAOLocal {
	@PersistenceContext(unitName = "KebabEJBSql")
	private EntityManager em;

	public StudentEAOImpl() {

	}

	public Student findByStudentId(String id) {
		return em.find(Student.class, id);
	}

	public Student createStudent(Student student) {
		em.persist(student);
		return student;
	}

	public Student updateStudent(Student student) {
		em.merge(student);
		return student;
	}

	public void deleteStudent(String id) {
		Student s = this.findByStudentId(id);
		if (s != null) {
			em.remove(s);
		}
	}

	public List<Student> findAllStudents() {
		TypedQuery<Student> query = em.createNamedQuery("Student.findAllStudents", Student.class);
		return query.getResultList();
	}
	
	public String generateId() {
		Random rand = new Random();
        int randomNum = rand.nextInt(9000);
        String id = "S"+randomNum;
		return id;
	}

}
