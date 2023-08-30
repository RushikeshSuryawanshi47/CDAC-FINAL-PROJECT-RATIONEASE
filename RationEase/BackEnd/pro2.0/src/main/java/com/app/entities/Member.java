package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "family_member") // to specify table name
//lombok annotations
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member  extends BaseEntity  {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="sr_no")
//	private Long srNo;
	@Column(name = "first_name", length = 20) // varchar(20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(name="dob")
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	@Column(name="relation" ,length = 10)
	private FamilyMemberRelation relation;
	// member *----->1 userDetails
		@ManyToOne(fetch = FetchType.LAZY) // Change this iff you DON'T want to lift dept details along with emp
		@JoinColumn(name = "user_id",nullable = false)//not null constraint added on FK column
		@JsonIgnore
		private UserEntity userId;;
	
	

} 