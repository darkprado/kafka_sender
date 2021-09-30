package com.example.kafka_sender.service;

import com.example.kafka_sender.dto.KafkaSenderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaSenderServiceImpl implements KafkaSenderService {

    @Value("${spring.kafka.kafka-request-topic}")
    private String kafkaSenderTopic;

    private final KafkaTemplate<String, KafkaSenderDto> kafkaTemplate;

    @Override
    public void writeKafkaSenderDtoInTopic(KafkaSenderDto kafkaSenderDto) {
        Message<KafkaSenderDto> message = MessageBuilder
                .withPayload(kafkaSenderDto)
                .setHeader(KafkaHeaders.TOPIC, kafkaSenderTopic)
                .setHeader("messageUid", UUID.randomUUID().toString())
                .setHeader("trace-id", UUID.randomUUID().toString())
                .setHeader("messageDateTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
        kafkaTemplate.send(message);
        log.debug("Message {} was published to {}", message, kafkaSenderTopic);
    }

    @Override
    public void writeErrorListener(String messageUid) {
        log.error("Error sending message with Uid: {}", messageUid);
    }
}
