package com.app.springBootRest.service;

import org.springframework.data.repository.CrudRepository;
import com.app.springBootRest.pojo.CoursePOJO;

public interface CourseService extends CrudRepository<CoursePOJO, Integer> {
	
}
