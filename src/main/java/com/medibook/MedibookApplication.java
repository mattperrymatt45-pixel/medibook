package com.medibook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.medibook")
@EnableJpaRepositories(basePackages = "com.medibook.repository")
@EntityScan(basePackages = "com.medibook.model")
public class MedibookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedibookApplication.class, args);
    }
}
