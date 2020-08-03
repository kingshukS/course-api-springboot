package com.kingshuk.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.springboot.model.Course;
import com.kingshuk.springboot.model.Topic;
import com.kingshuk.springboot.repo.CourseRepository;
import com.kingshuk.springboot.repo.TopicRepository;
import com.kingshuk.springboot.service.CourseService;
import com.kingshuk.springboot.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@Service("courseService")
@Slf4j
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> getAllCourses(String topicId) {
		List<Course> courseList = new ArrayList<>();
		this.courseRepository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
	}

	@Override
	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);

	}

	@Override
	public Course updateCourse(Course course) {
		Course c = courseRepository.findById(course.getId()).get();
		c.setName(course.getName());
		c.setDescription(course.getDescription());
		c.setTopicId(course.getTopicId());
		courseRepository.save(c);
		return c;
	}

	@Override
	public Course deleteCourse(String id) {
		Course c = courseRepository.findById(id).get();
		courseRepository.deleteById(id);
		return c;
	}
}
