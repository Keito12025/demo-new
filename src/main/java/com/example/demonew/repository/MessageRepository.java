package com.example.demonew.repository;
import com.example.demonew.model.Message;
import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Message save(Message message);
    List<Message> findAll();
    Optional<Message> findById(Long id);
}
