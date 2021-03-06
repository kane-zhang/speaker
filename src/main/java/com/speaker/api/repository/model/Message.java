package com.speaker.api.repository.model;

import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "message")
public class Message {

  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  
  @NotNull
  private String title;
  
  private String description;
  
  @NotNull
  private long category;
  
  @NotNull
  @Column(name = "expiryDate")
  private Timestamp expiryDate;
 
@Column(name = "hasImage")
  private String hasImage;   
  
  @Column(name = "geoLocation" )
  private Point geoLocation;   
  
  
  @Column(name="distance", insertable=false, updatable=false)
  private Double distance;   
  
//  @Formula(value = "(ST_distance_Sphere(geoLocation, :targetPoint))" )
  public Double getDistance() {
	return distance;
}
  
  public void setDistance(Double distance) {
	this.distance = distance;
}


public String getHasImage() {
	return hasImage;
}



public void setHasImage(String hasImage) {
	this.hasImage = hasImage;
}
  
 
public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public long getCategory() {
	return category;
}



public void setCategory(long category) {
	this.category = category;
}



public Timestamp getExpiryDate() {
	return expiryDate;
}



public void setExpiryDate(Timestamp expiryDate) {
	this.expiryDate = expiryDate;
}



public void setId(long id) {
	this.id = id;
}



public long getId() {
	return id;
}

public Point getGeoLocation() {
	return geoLocation;
}



public void setGeoLocation(Point geoLocation) {
	this.geoLocation = geoLocation;
}

 public Message() {
 }


}