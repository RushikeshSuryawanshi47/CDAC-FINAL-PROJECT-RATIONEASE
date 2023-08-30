package com.app.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.app.entities.UserEntity;
import com.app.entities.Member;
import com.app.entities.UserEntity;


public interface MemberRepository extends JpaRepository<Member,Long> {

	

	//List<Member> findAll(UserEntity rationId);

	

	List<Member> findByUserId(UserEntity rationId);

	
	//List<Member> getAllByAssrationNo(Long rationId);	

	//List<Member> findAllByAssrationNo(Long rationId);
	
	

	
}
