package com.kingshuk.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springboot.model.Course;
import com.kingshuk.springboot.model.Topic;
import com.kingshuk.springboot.service.CourseService;
import com.kingshuk.springboot.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/course-api")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		log.info("Finding all courses for topicId : {}",topicId);
		return courseService.getAllCourses(topicId);
	}

	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("id") String id) {
		log.info("Getting course for id : {}", id);
		return courseService.getCourse(id);
	}

	@PostMapping("/topics/{topicId}/courses")
	public Course addCourse(@PathVariable("topicId") String topicId,@RequestBody Course course) {
		course.setTopicId(topicId);
		courseService.addCourse(course);
		return course;
	}

	@PutMapping("/topics/{topicId}/courses/{id}")
	public Course updateCourse(@PathVariable("topicId") String topicId,
			@PathVariable("id") String id, @RequestBody Course course) {
		course.setId(id);
		course.setTopicId(topicId);
		return courseService.updateCourse(course);
	}

	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public Course deleteCourse(@PathVariable("id") String id) {
		return courseService.deleteCourse(id);
	}
}
