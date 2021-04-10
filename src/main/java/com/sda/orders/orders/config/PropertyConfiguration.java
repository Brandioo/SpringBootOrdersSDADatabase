package com.sda.orders.orders.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:global.properties")
//@ConfigurationProperties
@Data
public class PropertyConfiguration {

    private List<String>  names;
    private List<String>  surnames;
    private List<String>  birthDates;
    private List<String>  emails;
    private List<String> departmentName;
    private List<String> description;



}
