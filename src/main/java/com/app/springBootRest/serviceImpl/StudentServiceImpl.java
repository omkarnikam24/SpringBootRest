package com.app.springBootRest.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.springBootRest.pojo.CoursePOJO;
import com.app.springBootRest.pojo.StudentPOJO;
import com.app.springBootRest.service.CourseService;
import com.app.springBootRest.service.StudentService;

@Service
public class StudentServiceImpl{
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentPOJO student;
	
	@Transactional
	StudentPOJO addNewStudent( StudentPOJO studentDetails ) {
		
		System.out.println("In Add ServiceImpl");
		List<CoursePOJO> list = new ArrayList<>();
		for (CoursePOJO course : studentDetails.getCourses()) {
			System.out.println("Course Before : " + course.toString());
			course = courseService.findOne(course.getCourseId());
			System.out.println("Course After : " + course.toString());
			list.add(course);
		}
		
		System.out.println("List : " + list.toString());
		studentDetails.setCourses(list);
		System.out.println( "Student Details : " + studentDetails.toString() );
		student = studentService.save(studentDetails);
		
		return student;
	}
}
