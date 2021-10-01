package com.example.kafka_sender.dto;

import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

@Data
public class KafkaSenderDto {

    private String info;

    private String system;

    private int num;

}
