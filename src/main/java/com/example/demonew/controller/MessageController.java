package com.example.demonew.controller;
import com.example.demonew.model.Message;
import com.example.demonew.model.MessageRequest;
import com.example.demonew.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message create(@RequestBody MessageRequest request) {
        return messageService.create(request);
    }

    @GetMapping
    public List<Message> list() {
        return messageService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return messageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


