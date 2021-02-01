package comm.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import comm.Entity.Student;
@Stateless
public class StudentService {
	  @PersistenceContext
	   private EntityManager em;

	public void saveStudent(Student student) {
	if(student.getId()==0)
		em.persist(student);
	else
		em.merge(student);
		
	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Student.class, id);
	}

	public List<Student> findAll() {

		return em.createNamedQuery("student.getAll",Student.class).getResultList();
	
	}

	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		  Student s=em.find(Student.class, id);
		   em.remove(s);
	}



}
