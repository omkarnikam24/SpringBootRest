package com.app.springBootRest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table( name = "Course" )
public class CoursePOJO {
	
	@Id
	@SequenceGenerator(name="Course_SEQ", sequenceName="Course_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Course_SEQ")
	@Column(unique = true, nullable = false)
	private Integer courseId;

	@Column(unique = false, nullable = false, length=20)
	private String courseName;
	
	@Column(unique = false, nullable = true, length=50)
	private String courseDesc;
	
	@ManyToOne
	@JoinColumn( name = "studentId", nullable = false )
	private StudentPOJO student;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public StudentPOJO getStudent() {
		return student;
	}

	public void setStudent(StudentPOJO student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "CoursePOJO [courseId=" + courseId + ", courseName=" + courseName + ", courseDesc=" + courseDesc
				+ ", student=" + student + "]";
	}
	
}
