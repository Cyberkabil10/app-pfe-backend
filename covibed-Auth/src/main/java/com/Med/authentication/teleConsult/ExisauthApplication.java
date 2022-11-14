package com.Med.authentication.teleConsult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ExisauthApplication {

    @Value("${exisauth.thread.core-pool}")
    private int corePoolSize;

    @Value("${exisauth.thread.max-pool}")
    private int maxPoolSize;

    @Value("${exisauth.queue.capacity}")
    private int queueCapacity;

    @Value("${exisauth.thread.timeout}")
    private int threadTimeout;

    @Bean
    TaskExecutor taskExecutor () {
        ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
        t.setCorePoolSize(corePoolSize);
        t.setMaxPoolSize(maxPoolSize);
        t.setQueueCapacity(queueCapacity);
        t.setAllowCoreThreadTimeOut(true);
        t.setKeepAliveSeconds(threadTimeout);
        return t;
    }



    public static void main(String[] args) {
        SpringApplication.run(ExisauthApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }


}
