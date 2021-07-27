package com.fleeter.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.applicant.LoanApplicationForm;
import com.fleeter.entities.roles.Applicant;

@Repository
public interface LoanApplicationFormRepository extends JpaRepository<LoanApplicationForm, Integer> {

	public List<LoanApplicationForm>  findByIsCreditOkAndIsDocumentVerified(boolean b,boolean c);
	public List<LoanApplicationForm>  findByIsLoanDisbursed(boolean b);
	public List<LoanApplicationForm>  findByIsLoanRejected(boolean b);
	public List<LoanApplicationForm>  findByIsDocumentVerified(boolean b);
	public List<LoanApplicationForm>  findByIsLoanApprovedAndIsLoanDisbursed(boolean b,boolean c);
	public List<LoanApplicationForm>  findByApplicant(Applicant applicant);
	public List<LoanApplicationForm>  findByApplicantAndIsLoanDisbursed(Applicant applicant,boolean b);
	public List<LoanApplicationForm>  findByIsCreditOkAndIsLoanRejected(boolean b,boolean c);


}
