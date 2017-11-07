package com.sample.speaker.api.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import com.speaker.api.dao.model.*;

@Transactional
public interface MessageDAO extends JpaRepository<Category, Long> {
	
	public Category findById(long id);

}
