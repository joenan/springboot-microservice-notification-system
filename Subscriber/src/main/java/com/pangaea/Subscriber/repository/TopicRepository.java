package com.pangaea.Subscriber.repository;

import com.pangaea.Subscriber.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    Optional<Topic> findByUrl(String url);
}
