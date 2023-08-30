package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingSlotDTO;
import com.app.dto.BookingUpdateDTO;
import com.app.entities.RationBooking;
import com.app.entities.UserEntity;
import com.app.jwt_utils.JwtUtils;
import com.app.service.UserService;
import com.app.service.VendorService;
@CrossOrigin("*")
@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private UserService userService;
	@Autowired
	private VendorService vendorService;
	// dep : auth mgr
//	@Autowired
//	private AuthenticationManager authMgr;

	// dep : jwt utils
//	@Autowired
//	private JwtUtils jwtUtils;
	// any one should be able view the products
	@GetMapping("/allusers")
	@PreAuthorize("hasRole('ROLE_VENDOR')") 
	public List<UserEntity> getAllUsers(){
		
		
		return userService.getAllUsers();
		
	}
	
	
	@GetMapping("/booking")
	public ResponseEntity<?> bookslot(@RequestParam Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(vendorService.getBookingSlot(id));
		
	}
	
	
	//@PreAuthorize("hasRole('ROLE_VENDOR')") 
	@GetMapping("/getallbooking")
	public List<RationBooking> getAllBookingBetDate(@RequestParam String startDate,@RequestParam String lastDate){
		return vendorService.getAllBookingBetDate(startDate, lastDate);
	}
	
	@PreAuthorize("hasRole('ROLE_VENDOR')") 
	
	@GetMapping("/deleteUser/{rationId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long rationId){
		return ResponseEntity.status(HttpStatus.OK).body(vendorService.deleteUser(rationId));
	}
	
//	@PutMapping("/updatebooking/{bookingId}")
//	 public String updateBooking(@ResponseBody BookingUpdateDTO dto,@PathVariable Long bookingId) {
//		return null;
//	}
	
	
	
	// admin should be able to delete the products
	@PreAuthorize("hasRole('ADMIN')") //method level auth
	@GetMapping("/delete")
		public String deleteProducts() {
			return "admin should be able to delete  the products";
	}

}
