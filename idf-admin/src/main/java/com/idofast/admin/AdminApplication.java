package com.idofast.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
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
