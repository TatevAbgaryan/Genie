package com.genie.genie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource("classpath*:*spring_data_config.xml")
public class PersistenceJPAConfig {
}