package com.speaker.api.repository;

import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.speaker.api.repository.model.*;

@Transactional

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "from Category")
	List<Category> findAllCategories();

	
}
