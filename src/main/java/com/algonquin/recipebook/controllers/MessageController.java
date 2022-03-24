package com.algonquin.recipebook.controllers;
import com.algonquin.recipebook.model.Message;
import com.algonquin.recipebook.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    public MessageController(){

    }

    @GetMapping("/twitter-like-app/messages")
    public List<Message> getMessages(){
        return messageService.getMessages();
    }
    @PostMapping("/twitter-like-app/insert-message")
    public int insertMessage(@RequestBody Message message){
        return messageService.insertMessage(message);
    }

    @PostMapping
    public List<Message> getMessagesByProducer(@RequestBody UUID uuid){
        return messageService.getMessagesByProducer(uuid);
    }

    @PostMapping
    public List<Message> getMessagesBySubscriber(@RequestBody UUID uuid){
        return messageService.getMessagesBySubscriber(uuid);
    }

}
