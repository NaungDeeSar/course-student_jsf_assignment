package comm.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import comm.Entity.Course;

@Stateless
public class CourseService {
	  @PersistenceContext
	   private EntityManager em;
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		  if(course.getId()==0)
			  em.persist(course);
		  else
			  em.merge(course);
	}
	public Course findById(String id) {
		return em.find(Course.class,Integer.parseInt(id));
	}
	public List<Course> findAll() {
		return em.createNamedQuery("Course.getAll",Course.class).getResultList();
		   
	}
	public void delete(int id) {
	   Course c=em.find(Course.class, id);
	   em.remove(c);
		
	}

}
