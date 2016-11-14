package com.psp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * qa 项目启动入口
 */
@SpringBootApplication
@EntityScan(basePackageClasses = {PspProjectApplication.class, Jsr310JpaConverters.class})
public class PspProjectApplication {

    /**
     * spirng boot 应用启动入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(PspProjectApplication.class, args);
    }
}
