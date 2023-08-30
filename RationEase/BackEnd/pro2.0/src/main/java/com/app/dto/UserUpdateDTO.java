package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor

public class UserUpdateDTO {
	private String firstName;
	@Size(min = 4, max = 20, message = "Invalid length of last name")
	private String lastName;

	
	
	@Column( nullable = false) // NOT NULL constraint
	private LocalDate dob;
	@Column( nullable = false) // NOT NULL constraint
	private int noOfFamilyMember;
	
	

}
