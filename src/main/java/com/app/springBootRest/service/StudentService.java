package com.app.springBootRest.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.springBootRest.pojo.CoursePOJO;
import com.app.springBootRest.pojo.StudentPOJO;

public interface StudentService extends CrudRepository<StudentPOJO, Integer>{

	@Query(value="from StudentPOJO s join fetch s.courses c where s.studentId = ?1 and c.courseId = ?2")
	List<StudentPOJO> findDetailsForCourse(Integer studentId , Integer courseId );
	
	/*@Query(value="from CoursePOJO c join fetch c.courses s where c.studentId = ?1 and s.courseId = ?2")
	List<CoursePOJO> getAllStudentsOfCourse( Integer courseId );*/
	
	StudentPOJO addNewStudent( StudentPOJO studentDetails );
}
