package com.speaker.api.repository;

import java.util.List;
import java.sql.Timestamp;

import javax.persistence.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.speaker.api.repository.model.*;
import com.vividsolutions.jts.geom.Point;

@Transactional

public interface MessageRepository extends JpaRepository<Message, Long> {
	

	@Query(value = "select id, title, description, category, expiryDate, hasImage, geoLocation, ST_distance_Sphere(geoLocation, :targetPoint) as distance from Message where ST_Distance_Sphere(geoLocation, :targetPoint) < :queryDistance", nativeQuery = true)
	List<Message> findMessages(@Param("targetPoint") Point targetPoint, @Param("queryDistance") int queryDistance);
	
//	@Query(value = "from Message")
//	List<Message> findMessages();	
	
}
