package com.app.springBootRest.pojo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
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
	
	@ManyToMany( fetch = FetchType.EAGER , cascade = CascadeType.ALL )
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"), 
		inverseJoinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"))
	private List<CoursePOJO> courses;
	
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

	public void setCourses(List<CoursePOJO> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentPOJO [studentId=" + studentId + ", studentName=" + studentName + ", courses=" + courses + "]";
	}
	
}
