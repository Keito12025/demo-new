package com.example.demonew.model;

public class Message {
    private Long id;
    private String content;

    public Message() {}

    // 你的 Service 用到了这些方法，必须保留
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
