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
import com.kingshuk.springboot.model.Lesson;
import com.kingshuk.springboot.model.Topic;
import com.kingshuk.springboot.service.LessonService;
import com.kingshuk.springboot.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/course-api")
public class LessonController {

	@Autowired
	private LessonService lessonService;

	@GetMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable("courseId") String courseId) {
		return lessonService.getAllLessons(courseId);
	}

	@GetMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable("id") String id) {
		log.info("Getting topic for id : {}", id);
		return lessonService.getLesson(id);
	}

	@PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public Lesson addLesson(@PathVariable("courseId")String courseId,
			@PathVariable("topicId") String topicId,@RequestBody Lesson lesson) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.addLesson(lesson);
		return lesson;
	}

	@PutMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson updateLesson(@PathVariable("courseId")String courseId,
	@PathVariable("topicId") String topicId,@RequestBody Lesson lesson) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		return lessonService.updateLesson(lesson);
	}

	@DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson deleteTopic(@PathVariable("id") String id) {
		return lessonService.deleteLesson(id);
	}
}
