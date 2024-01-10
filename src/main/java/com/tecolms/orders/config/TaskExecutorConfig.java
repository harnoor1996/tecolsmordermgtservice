package com.tecolms.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAsync
@Slf4j
@PropertySource(value={"classpath:application.properties"})
public class TaskExecutorConfig {

    @Value("${async.core.pool.size}")
    public int coreThreadPoolSize;

    @Value("${async.max.pool.size}")
    public int maxThreadPoolSize;

    @Value("${async.thread.queue.capacity}")
    public int threadQueueCapacity;

    public static final String ASYNC_THREAD_PREFIX = "vendor-master-services-";

    @Bean(name = "fixedThreadPool")
    @Primary
    public TaskExecutor fixedThreadPool() {
        log.info("-> ******* asyncExecutor ********");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix(ASYNC_THREAD_PREFIX);
        threadPoolTaskExecutor.setCorePoolSize(coreThreadPoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxThreadPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(threadQueueCapacity);
        threadPoolTaskExecutor.afterPropertiesSet();
        return threadPoolTaskExecutor;
    }
}