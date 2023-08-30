package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.RationBooking;

public interface VendorService {

	Optional<RationBooking> getBookingSlot(Long rationId);

	List<RationBooking> getAllBookingBetDate(String startDate, String lastDate);	
	String deleteUser(Long rationId);	
}
