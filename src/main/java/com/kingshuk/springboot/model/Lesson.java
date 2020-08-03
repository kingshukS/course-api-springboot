package com.kingshuk.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="lessons")
public class Lesson {
	
	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Course course;
	public Lesson(String id, String name, String description,String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = new Course(courseId, "", "", "");
	}
}
