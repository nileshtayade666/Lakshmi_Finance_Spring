package com.fleeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.roles.OperationExecutive;

@Repository
public interface OperationalExecutiveRepository extends JpaRepository<OperationExecutive, Integer> {

}
