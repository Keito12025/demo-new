package com.example.demonew.repository;
import com.example.demonew.model.Message;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class InMemoryMessageRepository implements MessageRepository{
    private final Map<Long, Message> store = new ConcurrentHashMap<>();

    @Override
    public Message save(Message message) {
        store.put(message.getId(), message);
        return message;
    }
    @Override
    public List<Message> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
