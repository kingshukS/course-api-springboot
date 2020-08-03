package com.kingshuk.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="topics")
public class Topic {
	
	@Id
	private String id;
	private String name;
	private String description;
}
