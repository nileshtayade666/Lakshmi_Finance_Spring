package com.fleeter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.master.Branch;
import com.fleeter.entities.roles.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

	public  List<Applicant> findByBranch(Branch branch);
}
