package com.springtest.sweater;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.springtest.sweater.domane.Message;
import com.springtest.sweater.repos.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<java.util.List<Message>> typeReference = new TypeReference<java.util.List<Message>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/test.json");
            try {
                java.util.List<Message> messages = mapper.readValue(inputStream,typeReference);
                userService.save((java.util.List<Message>) messages);
                System.out.println("Users Saved!");
               // userService.delete((java.util.List<Message>) messages);
                System.out.println("Used 15 del");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
            Message message = new Message();
            Iterable<Message> messages = userService.list();
            System.out.println(message.getId()+" "+message.getText());
        };

    }
}