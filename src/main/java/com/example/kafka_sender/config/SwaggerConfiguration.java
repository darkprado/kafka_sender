package com.example.kafka_sender.config;

import com.example.kafka_sender.controller.KafkaSenderController;
import com.example.kafka_sender.dto.KafkaSenderDto;
import com.fasterxml.classmate.TypeResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final TypeResolver typeResolver;

    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(
                        typeResolver.resolve(KafkaSenderDto.class)
                )
                .groupName("kafka-sender")
                .select()
                .apis(RequestHandlerSelectors.basePackage(KafkaSenderController.class.getPackageName()))
                .build();
    }

}
