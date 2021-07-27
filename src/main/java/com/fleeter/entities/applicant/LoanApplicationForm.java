package com.fleeter.entities.applicant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fleeter.entities.master.ElectronicItem;
import com.fleeter.entities.master.LoanType;
import com.fleeter.entities.roles.Applicant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 @OneToOne
	private Applicant applicant;
	 
	 @OneToOne
	private ElectronicItem electronicItem;
	
	 @OneToOne
	private LoanType  loanType;
	 
	 @OneToOne(cascade = CascadeType.ALL) 
	private BankDetails bankDetails;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	private IncomeStatement incomeStatement;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 private LoanDetails loandetails;
	 

	private String remark;
	private int creditScore;
	private boolean isDocumentVerified= false;

	private boolean isLoanDisbursed=false;
	private boolean isCreditOk ;
	private boolean isLoanRejected=false ;
	private boolean isLoanApproved=false;
	
	

}
