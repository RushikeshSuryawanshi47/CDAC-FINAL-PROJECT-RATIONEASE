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
@AllArgsConstructor
public class BookingSlotDTO {
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	@NotBlank(message = "slot  can't be blank!!!")
	private String slot;
	private LocalDate slotDate;
	
	
	

}
