package com.app.springBootRest.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table( name = "Student" )
public class StudentPOJO {

	@Id
	@SequenceGenerator(name="Student_SEQ", sequenceName="Student_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Student_SEQ")
	@Column(unique = true, nullable = false)
	private Integer studentId;
	
	@Column(unique = false, nullable = false, length=20)
	private String studentName;
	
	@OneToMany( mappedBy = "student" , cascade = CascadeType.ALL, orphanRemoval = true )
	private final List<CoursePOJO> courses = new ArrayList<CoursePOJO>();

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<CoursePOJO> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "StudentPOJO [studentId=" + studentId + ", studentName=" + studentName + ", courses=" + courses + "]";
	}
	
}
