package com.hassen.consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaConsumer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(topics = "wikimedia-stream",groupId = "myGroup")
    public void consumeMsg(String msg){
        log.info(String.format(" message received from hassen topic ::%s", msg));
    }
}
