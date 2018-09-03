package com.springtest.sweater;

import com.springtest.sweater.domane.Message;
import com.springtest.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;



    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name",
                    required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", "hello");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        System.out.println(text+" "+tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        System.out.println(message.getId()+" "+message.getText());
        model.put("messages", messages);
        return "main";
    }
}
