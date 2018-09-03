package com.springtest.sweater.repos;

import com.springtest.sweater.domane.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private MessageRepo userRepository;

    public UserService(MessageRepo userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Message> list() {
        return userRepository.findAll();
    }

    public Iterable<Message> save(List<Message> messagers) {
        return userRepository.saveAll(messagers);
    }

     public void  deleteByid(long id) {
        userRepository.deleteById(id);
    }

    public void  delete(List<Message> messagers) {
         userRepository.deleteAll(messagers);
    }





}
