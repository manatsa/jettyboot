package com.mana.jettyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@RestController
public class JettyExapleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JettyExapleApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        Integer index=Double.valueOf(Math.random()*10).intValue();
        String[] quotes=new String[]{"1-2 testing","2-3 resting","4-5 working","6-7 eating","8-9 laughing",
                        "Seeding","Playing","Dancing","Relaxing","Travelling"};

        System.err.println("INDEX::"+index+"\t DATA::"+Arrays.asList(quotes).get(index));
        return "INDEX::"+index+"\t DATA::"+Arrays.asList(quotes).get(index);
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory()
    {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(9191);
        factory.setContextPath("/example");
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }

}
