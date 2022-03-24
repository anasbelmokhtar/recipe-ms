package com.algonquin.recipebook.services;

import com.algonquin.recipebook.dao.MessageDao;
import com.algonquin.recipebook.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;

    public List<Message> getMessages(){
        return messageDao.getMessages();
    }

    public int insertMessage(Message message) {
        return messageDao.insertMessage(message);
    }

    public List<Message> getMessagesByProducer(UUID uuid) {
        return messageDao.getMessagesByProducer(uuid);
    }

    public List<Message> getMessagesBySubscriber(UUID uuid) {
        return messageDao.getMessagesBySubscriber(uuid);
    }
}
