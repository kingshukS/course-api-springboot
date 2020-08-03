package com.kingshuk.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.kingshuk.springboot.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
