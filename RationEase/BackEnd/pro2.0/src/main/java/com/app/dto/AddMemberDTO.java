package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.app.entities.FamilyMemberRelation;
import com.app.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddMemberDTO {
	
	@NotBlank(message = "first name can't be blank!!!")
	private String firstName;
	@Size(min = 4, max = 20, message = "Invalid length of last name")
	private String lastName;
	@NotNull(message = "dob must be supplied!")
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	@Column(name="relation" ,length = 10)
	private FamilyMemberRelation relation;
	//private UserEntity assrationNo;;
	
//	public AddMemberDTO(@NotBlank(message = "first name can't be blank!!!") String firstName,
//			@Size(min = 4, max = 20, message = "Invalid length of last name") String lastName,
//			@NotNull(message = "dob must be supplied!") LocalDate dob,
//			@NotNull(message = "dob must be supplied!")  FamilyMemberRelation relation) {
//		super();
//		this.firstName=firstName;
//		this.lastName=lastName;
//		this.dob=dob;
//		this.relation=relation;
		//this.assrationNo=assrationNo;
		
//	}
	

}
