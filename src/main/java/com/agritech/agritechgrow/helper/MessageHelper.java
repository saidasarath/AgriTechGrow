package com.agritech.agritechgrow.helper;

public class MessageHelper {
    private String content;
    private String type;
    public String getContent() {
        return content;
    }
    public MessageHelper() {
    }
    public MessageHelper(String content, String type) {
        this.content = content;
        this.type = type;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
