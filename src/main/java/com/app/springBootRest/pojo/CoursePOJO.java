package com.app.springBootRest.pojo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany ( fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn( name = "studentId", nullable = false )
	private List<StudentPOJO> students;

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

	 @ManyToMany(mappedBy = "courses")
	public List<StudentPOJO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentPOJO> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "CoursePOJO [courseId=" + courseId + ", courseName=" + courseName + ", courseDesc=" + courseDesc
				+ ", students=" + students + "]";
	}
	
}
