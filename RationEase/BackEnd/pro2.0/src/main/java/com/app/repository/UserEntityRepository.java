package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
//finder method
	Optional<UserEntity> findByEmail(String email);

	//UserEntity load(Class<UserEntity> class1, Long rationId);

//	UserEntity load(Class<UserEntity> class1, Long rationId);
	
}
