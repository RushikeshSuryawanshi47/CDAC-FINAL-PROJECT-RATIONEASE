package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.app.dto.AddMemberDTO;
import com.app.dto.BookingSlotDTO;
import com.app.dto.BookingUpdateDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserUpdateDTO;
import com.app.entities.Member;
import com.app.entities.RationBooking;
import com.app.entities.UserEntity;

public interface UserService {

	UserDTO registerNewUser(UserDTO dto);
	
	AddMemberDTO addMember(Long rationId,@Valid AddMemberDTO dto);

	//String updateUserDetails(UserEntity detachedUser);

	Optional<UserEntity> getUser(Long rationId);

	BookingSlotDTO BookingSlot(Long rationId, BookingSlotDTO dto);

	List<UserEntity> getAllUsers();



	//Optional<List<Member>> getAllMemeber(Long rationID);

	//List<Member> getAllMemeber1(Long rationId);

	List<Member> getAllMemeber(Long rationId);

	Optional< RationBooking> getBookingById( Long rationId);

	//Member updateMemberDetails(Member detachedMember);

	//String updateMemberDetails(Long userId, UserEntity user);

	//String updateUserDetails(Long userId, UserUpdateDTO user);

	String updateUserDetails(Long rationId, UserUpdateDTO detachedUser);

	String updateBookingSlot(BookingUpdateDTO dto, Long rationId);

	//Member updateMemberDetails(Long rationId, Member member);

	

	//RationBooking getBookingById(Long id);

	
}
