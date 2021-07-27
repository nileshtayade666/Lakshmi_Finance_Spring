package com.fleeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.roles.AccountHead;
import com.fleeter.entities.roles.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
