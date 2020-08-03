package com.kingshuk.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.springboot.model.Topic;
import com.kingshuk.springboot.repo.TopicRepository;
import com.kingshuk.springboot.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@Service("topicService")
@Slf4j
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topicList = new ArrayList<Topic>();
		this.topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}

	@Override
	public Topic getTopic(String id) {
		log.info("Fetching topic for id: {}", id);
		return topicRepository.findById(id).get();
	}

	@Override
	public void addTopic(Topic topic) {
		topicRepository.save(topic);

	}

	@Override
	public Topic updateTopic(Topic topic) {
		Topic t = topicRepository.findById(topic.getId()).get();
		t.setName(topic.getName());
		t.setDescription(topic.getDescription());
		topicRepository.save(t);
		return t;
	}

	@Override
	public Topic deleteTopic(String id) {
		Topic t = topicRepository.findById(id).get();
		topicRepository.deleteById(id);
		return t;
	}
}
