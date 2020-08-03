package com.kingshuk.springboot.service;

import java.util.List;

import com.kingshuk.springboot.model.Course;

public interface CourseService {

	List<Course> getAllCourses(String topicId);

	Course getCourse(String id);

	void addCourse(Course course);

	Course updateCourse(Course course);

	Course deleteCourse(String id);
}
