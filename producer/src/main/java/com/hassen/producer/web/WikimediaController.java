package com.hassen.producer.web;

import com.hassen.producer.producer.WikimediaProducer;
import com.hassen.producer.stream.WikimediaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {
    private final WikimediaConsumer wikimediaConsumer;
    @GetMapping
    public void streamPublishing(){
        wikimediaConsumer.consumeStreamAndPublish();
    }
}
