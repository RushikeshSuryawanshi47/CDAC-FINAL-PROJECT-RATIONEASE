package com.app.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.app.entities.RationBooking;
import com.app.entities.UserEntity;

public interface RationBookingRepository extends JpaRepository<RationBooking, Long> {
	//Optional<RationBooking> findByRationNoAndSlotDate( LocalDate slotDate,UserEntity userEntity);

	Optional<RationBooking> findBySlotDateAndRationNo( LocalDate slotDate,UserEntity userEntity);

	Optional<RationBooking> findByRationNo(Long rationId);

	List<RationBooking> findBySlotDateBetween(LocalDate startSlotDate, LocalDate endSlotDate);	

	//Optional<RationBooking> findBySlotDateAndRationNoId(LocalDate slotDate, Long rationId);

	//Optional<RationBooking> findBySlotDateAndRationNo(LocalDate slotDate, Long rationId);

	

	

	//Optional<RationBooking> findByRationNo( Long rationId);


		
}
