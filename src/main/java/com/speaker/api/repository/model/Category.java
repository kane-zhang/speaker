package com.speaker.api.repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.geo.Point;

@Entity
@Table(name = "msg_category")
public class Category {

  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  
  @NotNull
  private String category;
  
  public long getId() {
	return id;
}

  public String getCategory() {
	return category;
  }

  public void setCategory(String category) {
	this.category = category;
  }

 
  public Category(long id) { 
    this.id = id;
  }
  
  public Category(long id, String category) {
    this.id = id;
    this.category = category;
  }

  public Category() {
  }


}