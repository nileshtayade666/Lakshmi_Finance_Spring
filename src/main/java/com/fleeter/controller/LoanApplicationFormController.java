package com.fleeter.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleeter.entities.applicant.LoanApplicationForm;
import com.fleeter.entities.applicant.LoanDetails;
import com.fleeter.entities.roles.Applicant;
import com.fleeter.entities.roles.OperationExecutive;
import com.fleeter.repository.ApplicantRepository;
import com.fleeter.repository.LoanApplicationFormRepository;
import com.fleeter.repository.OperationalExecutiveRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/form")
public class LoanApplicationFormController {
	
	@Autowired
	private LoanApplicationFormRepository applicationFormRepository;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private OperationalExecutiveRepository operationalExecutiveRepository;
	
	@PostMapping("/")
	public LoanApplicationForm saveLoanApplicationForm(@RequestBody LoanApplicationForm loanApplicationForm)
	{
		try {
			
			return applicationFormRepository.save(loanApplicationForm);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@GetMapping("/")
	public List<LoanApplicationForm> getLoanApplicationForm()
	{
		try {
			return applicationFormRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@GetMapping("/creditOk")
	public List<LoanApplicationForm> getCreditOkForm()
	{
		try {
			return applicationFormRepository.findByIsCreditOkAndIsDocumentVerified(true, false);

		} catch (Exception e) {
		}
		return null;
	}
	
	@GetMapping("/creditRejected")
	public List<LoanApplicationForm> getCrediRejectedForm()
	{
		try {
			return applicationFormRepository.findByIsCreditOkAndIsLoanRejected(false, true);
	
		} catch (Exception e) {
		}
		return null;
	}
	
	@GetMapping("/applicant/{id}")
	public List<LoanApplicationForm> getformsByApplicant(@PathVariable("id") int id)
	{
		try {
			Applicant applicant =applicantRepository.findById(id).get();
			return applicationFormRepository.findByApplicant(applicant);
		} catch (Exception e) {
		}
		return null;
		
	}
	
	@GetMapping("/applicantDisbursed/{id}")
	public List<LoanApplicationForm> getformsByApplicantDisbursed(@PathVariable("id") int id)
	{
		Applicant applicant =applicantRepository.findById(id).get();
		return applicationFormRepository.findByApplicantAndIsLoanDisbursed(applicant, true);
	}
	
	@GetMapping("/loanDisbursed")
	public List<LoanApplicationForm> getLoanDisbursedForm()
	{  
		try {
			return applicationFormRepository.findByIsLoanDisbursed(true);

		} catch (Exception e) {
		}
		return null;
	}
	
	@GetMapping("/loanApproved")
	public List<LoanApplicationForm> getLoanApprovedForm()
	{
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicationFormRepository.findByIsLoanApprovedAndIsLoanDisbursed(true,false);
	}
	
	@GetMapping("/rejected")
	public List<LoanApplicationForm> getRejectedForm()
	{
		try {
			return applicationFormRepository.findByIsLoanRejected(true);

		} catch (Exception e) {
		}
		return null;
	}
	
	
	
	
	@GetMapping("/documentVerified")
	public List<LoanApplicationForm> getDocumentVerifiedForm()
	{
		try {
			return applicationFormRepository.findByIsDocumentVerified(false);  

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public LoanApplicationForm getLoanApplicationFormById(@PathVariable("id") int id)
	{
		try {
			return applicationFormRepository.findById(id).get();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteLoanApplicationFormById(@PathVariable("id") int id)
	{
		try {
			 applicationFormRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@PutMapping("/{id}")
	public LoanApplicationForm updateLoanApplicationFormById(@RequestBody LoanApplicationForm loanApplicationForm,@PathVariable("id") int id)
	{
		try {
			loanApplicationForm.setId(id);
			return applicationFormRepository.save(loanApplicationForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/creditOk/{id}")
	public LoanApplicationForm updateLoanApplicationFormCreditOkById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			form.setCreditOk(true);
		
		return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/creditReject/{id}")
	public LoanApplicationForm updateLoanApplicationFormCreditRejectById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			form.setCreditOk(false);
			form.setLoanRejected(true);
			form.setLoanApproved(false);
			form.setRemark("Form is Rejected Due to low Credit score for this Amount of "+form.getElectronicItem().getPrice());
		
		return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@PutMapping("/docReject/{id}")
	public LoanApplicationForm updateLoanDocRejectById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			form.setDocumentVerified(false);
			form.setLoanApproved(false);
			form.setLoanRejected(true);
			form.setRemark("Form is Rejected Due to insuffucient document ");
		
		return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@PutMapping("/documentVerified/{id}")
	public LoanApplicationForm updateFileVerifiedById(@PathVariable("id") int id)
	{
		try {
			
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			form.setDocumentVerified(true);
		form.setLoanApproved(true)	;
		return applicationFormRepository.save(form);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}
	
	
	@PutMapping("/loanApproved/{id}")
	public LoanApplicationForm updateApproveLoanById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			form.setLoanApproved(true);
		
		return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/loanDisbursed/{id}")
	public LoanApplicationForm updateLoanDisbursedById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			Long price = form.getElectronicItem().getPrice(); 
			int loanAmount = price.intValue();
			int fileCharge = (loanAmount*4)/100;
			int insurance = 2500;
			int totalAmount = loanAmount+fileCharge+insurance;
			int noOfIntallment = 12;
			int installment = totalAmount/12;
				int dp = installment*4;	
				
			LoanDetails ld = new LoanDetails();
			ld.setLoanAmount(loanAmount);
			ld.setFileCharges(fileCharge);
			ld.setInsurane(insurance);
			ld.setTotalAmount(totalAmount);
			ld.setNoOfInstallment(noOfIntallment);
			ld.setInstallment(installment);
			ld.setDp(dp);
			ld.setRemainingInstallment(8);
			System.out.println(ld);
				form.setLoanDisbursed(true);
			form.setLoandetails(ld);
			System.out.println(form);
			return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/loanRejected/{id}")
	public LoanApplicationForm updateLoanRejectedById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			form.setLoanRejected(true);
		
		return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/markGood/{id}")
	public LoanApplicationForm markGood(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			Applicant applicant =	form.getApplicant();
			applicant.setRemark("Good");
			applicantRepository.save(applicant);
			return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/markBad/{id}")
	public LoanApplicationForm markBad(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			Applicant applicant =	form.getApplicant();
			applicant.setRemark("Bad");
			applicantRepository.save(applicant);
			return applicationFormRepository.save(form);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/payInstallemnt/{id}")
	public LoanApplicationForm payInstallent(@PathVariable("id") int id)
	{
		try {
			
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			LoanDetails	ld =form.getLoandetails();
			ld.setRemainingInstallment(ld.getRemainingInstallment()-1);
			return applicationFormRepository.save(form);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}
	
	@PutMapping("/creditScore/{id}")
	public LoanApplicationForm updatecalculateCibilCoreById(@PathVariable("id") int id)
	{
		try {
			LoanApplicationForm	form=	applicationFormRepository.findById(id).get();
			  int cc = ThreadLocalRandom.current().nextInt(400, 700);

			  form.setCreditScore(cc);
			
			return applicationFormRepository.save(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
