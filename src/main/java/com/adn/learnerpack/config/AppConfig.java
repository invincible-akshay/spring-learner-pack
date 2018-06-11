package com.adn.learnerpack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.adn.learnerpack")
@PropertySource("application.properties")
public class AppConfig {

}