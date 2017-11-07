package com.speaker.api.repository;

import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.speaker.api.repository.model.*;


@Transactional

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select id, userName, '' as password from User where userName = :userName and password = :password", nativeQuery = true)
	List<User> authorize(@Param("userName") String userName, @Param("password") String password);

	
}
