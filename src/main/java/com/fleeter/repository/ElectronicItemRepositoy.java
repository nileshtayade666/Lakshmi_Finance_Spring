package com.fleeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.master.ElectronicItem;
import com.fleeter.entities.roles.AccountHead;

@Repository
public interface ElectronicItemRepositoy extends JpaRepository<ElectronicItem, Integer> {

}