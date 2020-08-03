package com.kingshuk.springboot.service;

import java.util.List;

import com.kingshuk.springboot.model.Course;
import com.kingshuk.springboot.model.Lesson;

public interface LessonService {

	List<Lesson> getAllLessons(String courseId);


	void addLesson(Lesson lesson);

	Lesson updateLesson(Lesson lesson);

	Lesson deleteLesson(String id);

	Lesson getLesson(String id);
}
