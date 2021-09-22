package com.pangaea.Subscriber.service;

import com.pangaea.Subscriber.dto.TopicDTO;
import com.pangaea.Subscriber.exception.RecordAlreadyPresentException;
import com.pangaea.Subscriber.model.Topic;
import com.pangaea.Subscriber.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public TopicDTO addSubscription(TopicDTO body, String topic) {
        Optional<Topic> findTopicByURL = topicRepository.findByUrl(body.getUrl());
        if (findTopicByURL.isPresent()) {
            throw new RecordAlreadyPresentException("The Url:" + body.getUrl() + " already Exist");
        }

        body.setTopic(topic);
        body.setUrl(body.getUrl());


        return body;
    }

    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public TopicRepository getTopicRepository() {
        return topicRepository;
    }


    public Optional<Topic> findById(Long i) {
        return topicRepository.findById(i);
    }

    public Topic updateTopic(Long id, Topic topic) {
        Optional<Topic> findTopic = getTopicRepository().findById(id);
        if (findTopic.isPresent()) {
            findTopic.get().setTopic(topic.getTopic());
        }
        Topic updatedTopic = topicRepository.save(findTopic.get());
        return updatedTopic;

    }
}
