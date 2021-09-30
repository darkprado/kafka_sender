package com.example.kafka_sender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Value("${executor.pool-size}")
    int poolSize;
    @Value("${executor.max-pool-size}")
    int maxPoolSize;
    @Value("${executor.thread-name-prefix}")
    String threadNamePrefix;

    @Bean
    public TaskExecutor getExecutor() {
        ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
        exec.setCorePoolSize(poolSize);
        exec.setMaxPoolSize(maxPoolSize);
        exec.setThreadNamePrefix(threadNamePrefix);
        exec.initialize();
        return exec;
    }

}
