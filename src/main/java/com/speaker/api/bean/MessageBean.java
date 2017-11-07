package com.speaker.api.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.vividsolutions.jts.geom.Point;

public class MessageBean {

    private long id;
    private long category;
    private String title;
	private String description;
    private Timestamp expiryDate;
    private String hasImage;
    private Point geoLocation;
    private double distance;
    

	public double getDistance() {
		return distance;
	}


	public void setDistance(Double distance) {
		this.distance = Math.rint(distance.doubleValue());
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getCategory() {
		return category;
	}


	public void setCategory(long category) {
		this.category = category;
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


	public String getExpiryDate() {
		return new SimpleDateFormat("MM/dd/yyyy HH:mm").format(expiryDate);
	}


	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getHasImage() {
		return this.hasImage;
	}


	public void setHasImage(String hasImage) {
		this.hasImage = hasImage;
	}	
	
    public Double getLatitude() {
		return geoLocation.getX();
	}

    public Double getLongitude() {
		return geoLocation.getY();
	}
    
	public void setGeoLocation(Point geoLocation) {
		this.geoLocation = geoLocation;
	}	

	public MessageBean() {
    }
    
        
}