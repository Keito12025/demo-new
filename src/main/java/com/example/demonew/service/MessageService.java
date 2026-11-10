package com.example.demonew.service;
import com.example.demonew.model.Message;
import com.example.demonew.model.MessageRequest;
import com.example.demonew.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;


    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(MessageRequest request) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setContent(request.getContent());
        return messageRepository.save(message);
    }

    public List<Message> list() {
        return messageRepository.findAll();
    }

    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }
}

