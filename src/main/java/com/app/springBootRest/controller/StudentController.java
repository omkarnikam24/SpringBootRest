package com.app.springBootRest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.springBootRest.pojo.CoursePOJO;
import com.app.springBootRest.pojo.StudentPOJO;
import com.app.springBootRest.service.CourseService;
import com.app.springBootRest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentPOJO student;
	
	@Autowired
	CoursePOJO course;
	
	
	// Method to get List of Courses for a particular Student
	@GetMapping("/students/{studentId}/courses")
	public List<CoursePOJO> getCoursesForStudent( @PathVariable int studentId ){
		
		List<CoursePOJO> list = new ArrayList<>();
		student = studentService.findOne(studentId);
		
		for (CoursePOJO course : student.getCourses()) {
			list.add(course);
		}
		return list;
	}
	
	// Method to a particular Course of a particular Student
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public CoursePOJO getDetailsForCourse( @PathVariable int studentId , @PathVariable int courseId ){
		
		List<StudentPOJO> list = new ArrayList<>();
		list = studentService.findDetailsForCourse(studentId, courseId);
		
		return list.get(0).getCourses().get(0);
	}
	
	// Method to add a new student
	@PostMapping("students/addStudent")
	public ResponseEntity<Void> newStudent( @RequestBody StudentPOJO newStudent ){
		
		System.out.println("In Add Service");
		List<CoursePOJO> list = new ArrayList<>();
		for (CoursePOJO course : newStudent.getCourses()) {
			course = courseService.findOne(course.getCourseId());
			list.add(course);
		}
		
		newStudent.setCourses(list);
		student = studentService.save(newStudent);
		System.out.println("Student Added : " + student.toString());
		
		if ( student == null )
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok().build();
	}
	
	
	// Method to add a new course
	@PostMapping("students/addCourse")
	public ResponseEntity<Void> newCourse( @RequestBody CoursePOJO newCourse ){
		
		System.out.println("In Add Service");
		course = courseService.save(newCourse);
		System.out.println("Course Added : " + course.toString());
		
		if ( course == null )
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok().build();
	}
	
	
	/*@PostMapping("students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentforCourse( @PathVariable int studentId , 
			@RequestBody CoursePOJO newCourse ){
		
		System.out.println("In Register Course Service");

		// Get the student object with the given Student Id to add it while 
		// persisting Course object
		try {
			student = studentService.findOne(studentId);
			
			if ( student != null ) {
				// save course
			}
			else {
				// throw an error
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResponseEntity.ok().build();
	}*/
	
}
