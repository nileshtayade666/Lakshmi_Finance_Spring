package com.fleeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleeter.entities.roles.RelationshipExecutive;


@Repository
public interface RelashionshipExecutiveRepository extends JpaRepository<RelationshipExecutive, Integer> {

}
