package com.idofast.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableCaching
@EnableConfigurationProperties
public class AdminApplication implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(AdminApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception
    {

    }
}
