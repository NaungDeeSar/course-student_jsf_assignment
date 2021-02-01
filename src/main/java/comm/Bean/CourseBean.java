package comm.Bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import comm.Entity.Course;

import comm.Service.CourseService;
@Named
@RequestScoped
public class CourseBean {
	private Course course;
	private List<Course> courseList;
	
	@EJB
	private CourseService service;
	 @PostConstruct
     private void init() {
		ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
		Map<String,String> params=context.getRequestParameterMap();
		String id=params.get("courseid");
		if(id==null) 
			    course=new Course();		        
			    else
			    	course=service.findById(id);			
			   
		courseList=service.findAll();
		      	
	 } 
	public String save()
	{
		service.saveCourse(course);
		return "index?faces-redirect=true";
	}
	public String delete(int id) {
		service.delete(id);
		return "index?faces-redirect=true";
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public CourseService getService() {
		return service;
	}
	public void setService(CourseService service) {
		this.service = service;
	}
	

}
