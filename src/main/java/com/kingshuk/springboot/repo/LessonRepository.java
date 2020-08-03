package com.kingshuk.springboot.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.kingshuk.springboot.model.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, String> {
	List<Lesson> findByCourseId(String courseId);
}
