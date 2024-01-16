package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Result;
import org.ics.ejb.StudentStudy;
import org.ics.ejb.StudentStudyId;

@Stateless
public class StudentStudyEAOImpl implements StudentStudyEAOLocal {

	@PersistenceContext(unitName = "KebabEJBSql")
	private EntityManager em;

	public StudentStudyEAOImpl() {
	}

	public StudentStudy findByStudentStudyId(String StudentId, String CourseId) {
		StudentStudyId id = new StudentStudyId(StudentId, CourseId);
		return em.find(StudentStudy.class, id);
	}

	public StudentStudy createStudentStudy(StudentStudy studentStudy) {
		em.persist(studentStudy);
		return studentStudy;
	}
	
	public List<StudentStudy> findAllStudentStudy(){
		TypedQuery<StudentStudy> query = em.createNamedQuery("StudentStudy.findAllStudentStudy", StudentStudy.class);
		return query.getResultList();
	}
	
	public List<StudentStudy> findAllStudentStudyByStudentId(String id) {
		TypedQuery<StudentStudy> query = em.createNamedQuery("StudentStudy.findAllStudentStudyByStudentId", StudentStudy.class);
		query.setParameter("studentId", id);
		return query.getResultList();
	}
	
	public void deleteStudentStudy(String StudentId, String CourseId) {
		StudentStudy studentStudy = this.findByStudentStudyId(StudentId, CourseId);
		if (studentStudy != null) {
			em.remove(studentStudy);
		}

	}
	
}
    		
    		
    		
    

