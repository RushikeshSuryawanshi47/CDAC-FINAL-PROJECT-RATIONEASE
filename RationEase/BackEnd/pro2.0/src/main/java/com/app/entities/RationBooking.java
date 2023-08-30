package com.app.entities;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="booking")
@AllArgsConstructor
@Getter
@Setter
@ToString()

public class RationBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id",length=20)
	private Long bookingId;
	@Column(name="booking_date")
	private LocalDate bookingDate;
	@Column(name="slot_date")
	private LocalDate slotDate;
	@Column(name="slot")
	private String slot;
	
	@Column(name="baying_status")
	@Value("#{'Not'}")
	private String status;
	
	

	
	
	//one to one uni dir association between Address 1----->1 Emp
//	@OneToOne(fetch = FetchType.LAZY)
//	//by def fetch=EAGER
//	@MapsId //for shared PK approach
//	@JoinColumn(name="card_id")
//	
//	private UserEntity owner;
	@ManyToOne(fetch = FetchType.LAZY) // Change this iff you DON'T want to lift dept details along with emp
	@JoinColumn(name = "user_id",nullable = false)//not null constraint added on FK column
	private UserEntity rationNo;;
	
	public RationBooking() {
		// TODO Auto-generated constructor stub
	}



	
	
	

	
	
	
}
