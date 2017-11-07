package com.app.springBootRest.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.app.springBootRest.pojo.StudentPOJO;

public interface StudentService extends CrudRepository<StudentPOJO, Integer>{
	
	@Query(value="from StudentPOJO s where s.studentId = ?1 and s.courseId = ?2")
	List<StudentPOJO> findDetailsForCourse(Integer studentId , Integer courseId );
}
