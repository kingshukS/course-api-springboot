package com.kingshuk.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.springboot.model.Course;
import com.kingshuk.springboot.model.Lesson;
import com.kingshuk.springboot.model.Topic;
import com.kingshuk.springboot.repo.CourseRepository;
import com.kingshuk.springboot.repo.LessonRepository;
import com.kingshuk.springboot.repo.TopicRepository;
import com.kingshuk.springboot.service.CourseService;
import com.kingshuk.springboot.service.LessonService;
import com.kingshuk.springboot.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@Service("lessonService")
@Slf4j
public class LessonServiceImpl implements LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	@Override
	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lessonList = new ArrayList<>();
		this.lessonRepository.findByCourseId(courseId).forEach(lessonList::add);
		return lessonList;
	}

	@Override
	public Lesson getLesson(String id) {
		return lessonRepository.findById(id).get();
	}

	@Override
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);

	}

	@Override
	public Lesson updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		return lesson;
	}

	@Override
	public Lesson deleteLesson(String id) {
		Lesson l = lessonRepository.findById(id).get();
		lessonRepository.deleteById(id);
		return l;
	}
}
