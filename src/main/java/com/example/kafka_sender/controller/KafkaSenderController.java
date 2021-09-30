package com.example.kafka_sender.controller;

import com.example.kafka_sender.dto.KafkaSenderDto;
import com.example.kafka_sender.service.KafkaSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/write")
public class KafkaSenderController {

    private final KafkaSenderService kafkaSenderService;

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<String> writeKafkaSenderDto(@RequestBody KafkaSenderDto kafkaSenderDto) {
        kafkaSenderService.writeKafkaSenderDtoInTopic(kafkaSenderDto);
        return ResponseEntity.ok("Dto send success");
    }

}
