package com.fleeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.master.Branch;
import com.fleeter.entities.roles.AccountHead;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
