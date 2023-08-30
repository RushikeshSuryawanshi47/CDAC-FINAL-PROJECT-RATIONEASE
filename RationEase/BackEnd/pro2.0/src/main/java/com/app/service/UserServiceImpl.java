package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.persistence.NamedQuery;
//import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AddMemberDTO;
import com.app.dto.BookingSlotDTO;
import com.app.dto.BookingUpdateDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserUpdateDTO;
//import com.app.dto.UserIdDTO;
import com.app.entities.Member;
import com.app.entities.RationBooking;
import com.app.entities.UserEntity;
import com.app.repository.MemberRepository;
import com.app.repository.RationBookingRepository;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// dep : user dao
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
	public UserDTO registerNewUser(UserDTO dto) {
		// dto --> entity
		UserEntity userEntity = mapper.map(dto, UserEntity.class);
		// encode passdword
		userEntity.setPassword(enc.encode(userEntity.getPassword()));
		//save 
		UserEntity persistentEntity = userRepo.save(userEntity);
		return mapper.map(persistentEntity, UserDTO.class);
	}
	
	public AddMemberDTO addMember(Long rationId,AddMemberDTO dto) {
		Member member=mapper.map(dto, Member.class);
		UserEntity u=userRepo.getById(rationId);
		if(u !=null) {
			u.addMember(member);
		}
		UserEntity persistentEntity1 = userRepo.save(u);
		Member persistentEntity = memberRepo.save(member);
		
		return mapper.map(persistentEntity, AddMemberDTO.class);
		
		
	}
	
	@Override
	public Optional<UserEntity> getUser(Long rationId) {
		// TODO Auto-generated method stub
		
		return userRepo.findById(rationId);
	}


	public BookingSlotDTO BookingSlot(Long rationId, BookingSlotDTO dto) {
		RationBooking booking=mapper.map(dto, RationBooking.class);
		UserEntity u=userRepo.getById(rationId);
		if(u !=null) {
			u.addBooking(booking);
		}
		UserEntity persistentEntity1 = userRepo.save(u);
		RationBooking persistentEntity = bookingRepo.save(booking);
		
		return mapper.map(persistentEntity, BookingSlotDTO.class);
	}

	
	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	 public Optional<RationBooking> getBookingById(Long id) {
		 LocalDate slotDate=LocalDate.now();
		 System.out.println("*************************************************");
	        return  bookingRepo.findBySlotDateAndRationNo( slotDate, new UserEntity(id));
	    }

	
	

		@Override
		public List<Member> getAllMemeber(Long rationId) {
			// TODO Auto-generated method stub
			System.out.println("*********************************************************************");
			return memberRepo.findByUserId(new UserEntity(rationId));
		}
	
		
//		@Override
//		public UserEntity updateUserDetails(UserEntity detachedUser) {
//			// TODO Auto-generated method stub
//			return userRepo.save(detachedUser);
//		}
		
		@Override
		public String updateUserDetails(Long userId, UserUpdateDTO user) {
		    // Get the repository for the UserEntity class.
		   

		    // Get the user by ID.
		    UserEntity currentUser = userRepo.findById(userId).get();
		    UserEntity us =mapper.map(currentUser, UserEntity.class);
		    // Update the user details.
		    currentUser.setFirstName(us.getFirstName());
		    
		    currentUser.setLastName(us.getLastName());
		    currentUser.setEmail(us.getEmail());
		    currentUser.setPassword(us.getPassword());
		    currentUser.setRole(us.getRole());

		    // Save the updated user details.
		    userRepo.save(currentUser);
		    return "Update User Successfully";
		}

		
		
	
		
		
		
		
		@Override
		public String updateBookingSlot(BookingUpdateDTO dto, Long rationId) {
			System.out.println("*****************************************************************");
			// TODO Auto-generated method stub
			RationBooking ration=bookingRepo.getById(rationId);
			ration.setStatus(dto.getStatus());
			return "Status Updated";
		}
		
		
		
		
		
		
		
		
	///////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	

//	public Optional<RationBooking> getBookingById1(Long rationId) {
//		// TODO Auto-generated method stub
//		LocalDate slotDate=LocalDate.now();
//		
//		
//		return bookingRepo.findBySlotDateAndRationNo( slotDate, new UserEntity(rationId));
//	}
//   
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	



	














	

















	List<Member> m=new ArrayList<Member>();
//	@Override
//	public  List<Member> getAllMemeber(Long rationId) {
//		
//
//
//	UserEntity u=userRepo.getById(rationId);
//	u.getMemberList().size();
//	
//	return u.getMemberList();
//		//return memberRepo.findAllByAssrationNo(rationId);
//		
//		
//		
//	}

//	@Override
//	public Member updateMemberDetails(Member detachedMember) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
//	public Member updateMemberDetails(Long rationId,Member member) {
//	    // Get the current member details.
//	    Member currentMember = memberRepo.getById(rationId);
//
//	    // Update the member details.
//	    currentMember.setFirstName(member.getFirstName());
//	    currentMember.setLastName(member.getLastName());
//	    currentMember.setDob(member.getDob());
//	    currentMember.setRelation(member.getRelation());
//
//	    // Save the updated member details.
//	    return memberRepo.save(currentMember);
//	}

	
	

	//////////////////////////////////////
	
	
	

	
//	public Optional< List<Member>> getAllMemeber(Long rationId) {
//		// TODO Auto-generated method stub
//		//return  Optional.of(memberRepo.findAllByAssrationNo(rationId));
//		UserEntity u=userRepo.getById(rationId);
//		u.getMemberList().size();
//		for(int i=0;i<u.getMemberList().size();i++) {
//			if(i%2!=0) {
//				m.add(u.getMemberList().get(i));
//			}
//		}
//		System.out.println(m.size());
//		
//		
//		return Optional.of(m);
//	}
	 
	
	
	


}
