package com.speaker.api.bean;

public class CategoryBean {

    private long id;
    private String category;

    public CategoryBean() {
    }
    
    public CategoryBean(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
    
    public void setId(long id) {
        this.id =id;
    }

    public void setCategory(String category) {
        this.category = category;
    }    
}