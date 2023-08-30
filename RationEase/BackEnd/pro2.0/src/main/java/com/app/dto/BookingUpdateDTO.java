package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class BookingUpdateDTO {
	
	
	private String status;

	public BookingUpdateDTO(String status) {
		super();
		this.status = status;
	}
	
	
}
