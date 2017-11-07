package com.app.springBootRest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.springBootRest.pojo.CoursePOJO;
import com.app.springBootRest.pojo.StudentPOJO;
import com.app.springBootRest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentPOJO student;
	
	@Autowired
	CoursePOJO course;
	
	
	@GetMapping("/students/{studentId}/courses")
	public List<CoursePOJO> getCoursesForStudent( @PathVariable int studentId ){
		
		List<CoursePOJO> list = new ArrayList<>();
		student = studentService.findOne(studentId);
		
		for (CoursePOJO course : student.getCourses()) {
			list.add(course);
		}
		return list;
	}
	
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public CoursePOJO getDetailsForCourse( @PathVariable int studentId , @PathVariable int courseId ){
		
		List<StudentPOJO> list = new ArrayList<>();
		list = studentService.findDetailsForCourse(studentId, courseId);
		
		return list.get(0).getCourses().get(0);
	}
	
	
	@PostMapping("students/add")
	public ResponseEntity<Void> newStudent( @RequestBody StudentPOJO newStudent ){
		
		System.out.println("In Add Service");
		student = studentService.save(newStudent);
		System.out.println("Student Added : " + student.toString());
		
		return ResponseEntity.noContent().build();
		/*if( student == null )
			return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder
		return null;*/
	}
	
	
	/*@PostMapping("students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentforCourse( @PathVariable int studentId , 
			@RequestBody CoursePOJO newCourse ){
		
		//studentService.save(arg0)
		
		return null;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
}
