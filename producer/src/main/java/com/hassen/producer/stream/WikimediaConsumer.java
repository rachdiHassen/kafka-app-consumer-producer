package com.hassen.producer.stream;

import com.hassen.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaConsumer {

    private WikimediaProducer producer;
    private WebClient webClient;

    public WikimediaConsumer(WikimediaProducer wikimediaProducer, WebClient.Builder webClientBuilder) {
        this.producer = wikimediaProducer;
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }
}
