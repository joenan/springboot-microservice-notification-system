package com.pangaea.Subscriber.controller;

import com.pangaea.Subscriber.dto.TopicDTO;
import com.pangaea.Subscriber.model.Topic;
import com.pangaea.Subscriber.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {


    private final TopicService service;

    public TopicController(TopicService service) {
        this.service = service;
    }

    @PostMapping(value = "/subscribe/{t}")
    public TopicDTO addSubscription(@Valid @RequestBody TopicDTO body, @PathVariable("t") String topic) {
        return service.addSubscription(body, topic);
    }

    @GetMapping(value = "/allTopics")
    public List<Topic> getAllTopics(){
        return service.findAll();

    }

    @PostMapping(value = "/publish/{topic}")
    public ResponseEntity publishMessage(@PathVariable("topic") String topic, @RequestBody Topic data) {

        String url = data.getUrl();
        Optional<Topic> findUrlHavingSameTopic = service.getTopicRepository().findByUrl(url);
        List<Topic> topics = service.getTopicRepository().findAll();
        topics.forEach(x -> {
            x.getTopic().equalsIgnoreCase(topic);
        });


        return ResponseEntity.ok("Failed!");
    }
}
