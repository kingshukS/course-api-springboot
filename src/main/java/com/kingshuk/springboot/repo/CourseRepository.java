package com.kingshuk.springboot.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kingshuk.springboot.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	List<Course> findByTopicId(String topicId);
}
