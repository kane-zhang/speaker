package com.sample.speaker.api.dao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.geo.Point;

@Entity
@Table(name = "message")
public class Message {

  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  private String message;
  
  public long getId() {
	return id;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Point getLocation() {
	return location;
}

public void setLocation(Point location) {
	this.location = location;
}

@NotNull
  private Point location;

  // Public methods
  
  public Message() { }

  public Message(long id) { 
    this.id = id;
  }
  
  public Message(String message, Point location) {
    this.message = message;
    this.location = location;
  }



}