package com.fleeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.applicant.LoanEnquiryForm;


@Repository
public interface LoanEnquiryFormRepository extends JpaRepository<LoanEnquiryForm,Integer> {

}
