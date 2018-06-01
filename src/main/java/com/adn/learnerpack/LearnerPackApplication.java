package com.adn.learnerpack;

import com.adn.learnerpack.services.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LearnerPackApplication implements CommandLineRunner {

    @Autowired
    private ZipService zipService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LearnerPackApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);


    }

    @Override
    public void run(String...args) {

        zipService.zipFiles(args[0], Arrays.copyOfRange(args, 1, args.length));
    }
}

