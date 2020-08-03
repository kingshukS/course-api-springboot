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

import com.kingshuk.springboot.model.Topic;
import com.kingshuk.springboot.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/course-api")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		log.info("Getting topic for id : {}", id);
		return topicService.getTopic(id);
	}

	@PostMapping("/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topic;
	}

	@PutMapping("/topics/{id}")
	public Topic updateTopic(@PathVariable("id") String id, @RequestBody Topic topic) {
		topic.setId(id);
		return topicService.updateTopic(topic);
	}

	@DeleteMapping("/topics/{id}")
	public Topic deleteTopic(@PathVariable("id") String id) {
		return topicService.deleteTopic(id);
	}
}
