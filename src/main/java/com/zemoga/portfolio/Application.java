package com.zemoga.portfolio;

import com.zemoga.portfolio.entity.Portfolio;
import com.zemoga.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.sql.DataSource;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    DataSource dataSource;
    @Autowired
    PortfolioRepository portfolioRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //portfolioRepository.findAll().forEach((x) -> System.out.println(x.toString()));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
