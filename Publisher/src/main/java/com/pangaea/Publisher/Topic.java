package com.pangaea.Publisher;

import lombok.Data;

@Data
public class Topic {
    private String topic;
    private String url;

    public Topic() {
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
