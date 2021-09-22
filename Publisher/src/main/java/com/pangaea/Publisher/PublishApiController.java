package com.pangaea.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PublishApiController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SubscriberClient subscriberClient;


    @PostMapping("/publish/topic1")
    public Topic publishTopic(@RequestBody Topic body) {
      return  subscriberClient.subscribe(body);
    }

    @GetMapping("/publisher/allTopics")
    public String getAllTopics(){
        return "Accessing from SUBSCRIBER-SERVICE ==> "+subscriberClient.getAllTopics();
    }
}