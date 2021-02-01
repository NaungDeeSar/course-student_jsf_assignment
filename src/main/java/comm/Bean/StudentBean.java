package comm.Bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import comm.Entity.Student;
import comm.Service.StudentService;

@Named
@RequestScoped
public class StudentBean {

	private Student student;
	private List<Student> studentList;
	
	@EJB
	private StudentService service;
	
	
	@PostConstruct
	public void init()
	{
		ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
		Map<String,String> params=context.getRequestParameterMap();
		String id=params.get("studentId");
		if(id!=null)
			student=service.findById(Integer.parseInt(id));
		else
			student=new Student();
		studentList=service.findAll();
	}
	
	public String save()
	{
		service.saveStudent(student);
		return "student?faces-redirect=true";
	}
	
	public String delete(int id)
	{
		service.removeStudent(id);
		return "student?faces-redirect=true";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
	
}
