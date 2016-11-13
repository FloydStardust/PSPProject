package com.psp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {PspProjectApplication.class, Jsr310JpaConverters.class})
public class PspProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PspProjectApplication.class, args);
    }
}
