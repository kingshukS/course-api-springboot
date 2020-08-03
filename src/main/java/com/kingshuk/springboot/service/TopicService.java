package com.kingshuk.springboot.service;

import java.util.List;

import com.kingshuk.springboot.model.Topic;

public interface TopicService {

	List<Topic> getAllTopics();

	Topic getTopic(String id);

	void addTopic(Topic topic);

	Topic updateTopic(Topic topic);

	Topic deleteTopic(String id);
}
