package com.fleeter.entities.applicant;

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
@AllArgsConstructor
@NoArgsConstructor
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int loanAmount;
	private int fileCharges;
	private int insurane;
	private int totalAmount;
	private int noOfInstallment;
	private int dp;
	private int installment;
	private int remainingInstallment;
	@Override
	public String toString() {
		return "LoanDetails [loanAmount=" + loanAmount + ", fileCharges=" + fileCharges + ", insurane=" + insurane
				+ ", totalAmount=" + totalAmount + ", noOfInstallment=" + noOfInstallment + ", dp=" + dp
				+ ", installment=" + installment + "]";
	}
	
	
}
