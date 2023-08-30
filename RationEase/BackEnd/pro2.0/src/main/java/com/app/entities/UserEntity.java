package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
//@Getter
//@Setter
@ToString(exclude = "password") // toString excluding password
public class UserEntity extends BaseEntity {

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 300, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private UserRole role;

    @Transient // => skips from persistence => no col. generation
    private String confirmPassword;

    @Column(name="dob") // NOT NULL constraint
    private LocalDate dob;

    @Column(nullable = false) // NOT NULL constraint
   	private Long noOfFamilyMember;

  
    // Employee HAS-A family (strong asso => composition)
    
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Member> memberList = new ArrayList<>();
    
    
    // one to one ---->Booking
//  @OneToOne(mappedBy = "owner", fetch = FetchType.LAZY)
//  private RationBooking bokking;

  @OneToMany(mappedBy="rationNo",/* fetch = FetchType.LAZY, */
          cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<RationBooking> bookingList = new ArrayList<>();


    // additional overloaded ctor : to be used in JPQL ctor expression

   public UserEntity(Long Id) {
      this.setRationId(Id);
    }
    

    
    public void addMember(Member m) {
    	memberList.add(m);
    	m.setUserId(this);
    	
    }
    
    public void removeMember(Member m) {
    	memberList.remove(m);
    	m.setUserId(null);
    }
    
    public void addBooking(RationBooking p) {
    	bookingList.add(p);
    	p.setRationNo(this);
    	
    }
    
    public void removeBooking(RationBooking m) {
    	bookingList.remove(m);
    	m.setRationNo(null);
    }



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserRole getRole() {
		return role;
	}



	public void setRole(UserRole role) {
		this.role = role;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	



	public Long getNoOfFamilyMember() {
		return noOfFamilyMember;
	}



	public void setNoOfFamilyMember(Long noOfFamilyMember) {
		this.noOfFamilyMember = noOfFamilyMember;
	}



	public List<Member> getMemberList() {
		return memberList;
	}



	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}



	public List<RationBooking> getBookingList() {
		return bookingList;
	}



	public void setBookingList(List<RationBooking> bookingList) {
		this.bookingList = bookingList;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
    
    
    
    
    
    
    
    
}
