package com.citi.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
        SpringApplication.run(app, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(app);
    }

    private static Class<App> app = App.class;
}
