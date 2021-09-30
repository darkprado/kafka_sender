package com.example.kafka_sender.service;

import com.example.kafka_sender.dto.KafkaSenderDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;

public interface KafkaSenderService {

    @Async("writerThreadPool")
    void writeKafkaSenderDtoInTopic(KafkaSenderDto kafkaSenderDto);

    @KafkaListener(topics = "${spring.kafka.kafka-error-request-topic}", groupId = "${spring.kafka.group-id}")
    void writeErrorListener(String messageUid);

}
