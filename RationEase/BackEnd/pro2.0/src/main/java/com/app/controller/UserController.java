package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddMemberDTO;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.BookingSlotDTO;
import com.app.dto.BookingUpdateDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserUpdateDTO;
import com.app.entities.Member;
import com.app.entities.RationBooking;
import com.app.entities.UserEntity;
import com.app.jwt_utils.JwtUtils;
import com.app.service.UserService;
@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
//dep : service layer i/f
	@Autowired
	private UserService userService;

	// dep : auth mgr
	@Autowired
	private AuthenticationManager authMgr;

	// dep : jwt utils
	@Autowired
	private JwtUtils jwtUtils;

	// http://host:port/users/signup , method=POST
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody @Valid UserDTO dto) {
		System.out.println("in signup user " + dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUser(dto));
	}

	// http://host:port/users/signin , method=POST
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid AuthRequest dto) {
		System.out.println("in signin user " + dto);
		// create instance of a token to hold un verified user creadentials
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getEmail(),
				dto.getPassword());
		System.out.println("auth obj before " + token);
		// invoke authenticate method of auth mgr
		Authentication verifiedPrincipal = authMgr.authenticate(token);
		System.out.println("principal " + verifiedPrincipal);
		// => auth successful --> create JWT n sent it to the clnt in auth resp.
		return ResponseEntity
				.ok(new AuthResp("Succeful Authentication !", jwtUtils.generateJwtToken(verifiedPrincipal)));
	}
	
	//http://host:port/user/addmember   ,method=POST
	//@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	@PostMapping("/addmember/{rationid}")
	public ResponseEntity<?> addMember(@PathVariable Long rationid,  @RequestBody @Valid AddMemberDTO dto)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.addMember(rationid,dto));
		
	}
	
	
	//http://host:port/user/getUserById
	@GetMapping("/getuser")
	public ResponseEntity<?> getUserById(@RequestParam Long rationId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(rationId));
		
	}
	//http://host:port/user/bookslot
	@PostMapping("/booking/{rationId}")
	public ResponseEntity<?> bookslot(@PathVariable Long rationId,@RequestBody BookingSlotDTO dto){
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.BookingSlot(rationId,dto));
		
	}
	
	@GetMapping("/getmember/{rationId}")
	public List<Member> getAllMember(@PathVariable Long rationId){
		//Long rationId=Long.parseLong(rationID);
		
		return userService.getAllMemeber(rationId);
	}
	
	
	@GetMapping("/booking")
	public Optional<RationBooking> getBooking(@RequestParam Long id) {
		return userService.getBookingById(id);
		
	}
	// http://localhost:8080/employees , method = PUT
	@PutMapping("/updatuser/{rationId}")
	public String updateUserDetails( @PathVariable Long rationId ,@RequestBody UserUpdateDTO detachedUser) {

		System.out.println("in update emp " + detachedUser);// id : not null
		return userService.updateUserDetails(rationId,detachedUser);
	}
	
	@PutMapping("/updatebooking/{bookingId}")
	public String updateBookingId(@RequestBody BookingUpdateDTO dto,@PathVariable Long bookingId) {
		System.out.println("******************************************************");
		return userService.updateBookingSlot(dto,bookingId);
	}
	
	
	
	//http://local:host:8080/updatemember
//	@PutMapping("/updatemamber/{rationId")
//	public Member updateMember( @PathVariable Long rationId, @RequestBody Member detachedMember) {
//		return userService.updateMemberDetails(rationId,detachedMember);
//	}
//	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
		

		
		
	
		
	
//		public ResponseEntity<?> getSlot(@RequestParam  Long rationId) {
//			
//			System.out.println("********************************** "+rationId+" ****************************************");
//			//Long rationID=Long.parseLong(rationId);
//			return ResponseEntity.status(HttpStatus.OK).body( userService.getSlot(rationId));
//		}
		
		
//		public ResponseEntity<Optional<List<Member>>> getAllMember(@PathVariable Long rationId){
//			
//			
//			return ResponseEntity.status(HttpStatus.OK).body( userService.getAllMemeber(rationId));
//			//return userService.getAllMemeber1(2);
//		}
		
		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
}
