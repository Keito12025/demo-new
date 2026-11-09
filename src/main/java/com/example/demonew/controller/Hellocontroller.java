package com.example.demonew.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demonew.model.PersonalProfile;
import com.example.demonew.model.MessageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.ArrayList;
@RestController
public class Hellocontroller {
    private final List<MessageRequest> messages = new ArrayList<>();
    @GetMapping("/hello")
    public String hello() {
        return "Hello, I Exist";
    }
    @GetMapping("/profile")
    public PersonalProfile profile() {
        PersonalProfile p = new PersonalProfile();
        p.blogName = "Keito Builds Things";
        p.owner = "Keito";
        p.introduction = "正在学习Web编程的学生";
        p.interests = "编程、篮球、音乐";
        p.vision = "记录我的成长";
        return p;
    }
    @GetMapping("/me")
    public PersonalProfile me() {
        return profile();
    }
}
@RestController
class MessageController {
    private final List<MessageRequest> messages = new ArrayList<>();

    @PostMapping("/messages")
    public MessageRequest create(@RequestBody MessageRequest request) {
        messages.add(request);
        request.status = "MyBlog heard you ";
        return request;
    }
    @GetMapping("/messages")
    public List<MessageRequest> list() {
        return messages;
    }
    @GetMapping("/messages/{index}")
    public MessageRequest getOne(@PathVariable int index) {
        return messages.get(index);
    }
}