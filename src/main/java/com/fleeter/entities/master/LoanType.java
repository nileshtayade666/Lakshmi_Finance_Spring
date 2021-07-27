package com.fleeter.entities.master;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String loanTitle;
	private String loanDetail;
	
}
