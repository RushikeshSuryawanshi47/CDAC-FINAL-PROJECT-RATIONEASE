package com.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.RationBooking;
import com.app.entities.UserEntity;
import com.app.repository.MemberRepository;
import com.app.repository.RationBookingRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private UserEntityRepository userRepo;
	@Autowired
	private MemberRepository memberRepo;
	@Autowired
	private RationBookingRepository bookingRepo;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder enc;


	@Override
	public Optional<RationBooking> getBookingSlot(Long rationId) {
		// TODO Auto-generated method stub
		LocalDate slotDate=LocalDate.now();
		//return bookingRepo.findById(rationId);
		return bookingRepo.findBySlotDateAndRationNo(slotDate,new UserEntity(rationId));
	}


	@Override
	public List<RationBooking> getAllBookingBetDate(String startDate, String endDate) {
		System.out.println(startDate);
		// Convert the start and end slot dates to Date objects.
		  
//				startSlotDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
//			 endSlotDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		
		  
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startSlotDate=LocalDate.parse(startDate,formatter);
		System.out.println("*********"+startSlotDate);
		LocalDate endSlotDate=LocalDate.parse(startDate,formatter);
			  // Create a query to find all bookings where the slot date is between the start and end dates.
		List<RationBooking> bookings = bookingRepo.findBySlotDateBetween(startSlotDate, endSlotDate);
		System.out.println(bookings.get(0));
			  return bookings;
			}
	
	
	@Override
	public String deleteUser(Long userId) {
	    // Get the repository for the UserEntity class.
//	    UserRepository userRepository = entityManager.getRepository(UserEntity.class);

	    // Get the user by ID.
	    UserEntity user = userRepo.findById(userId).get();

	    // Delete the user.
	    userRepo.delete(user);
		return "Delete User Successfully";
	}
	

}
