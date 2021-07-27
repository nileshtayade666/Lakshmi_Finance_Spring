package com.fleeter.entities.roles;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fleeter.entities.master.Person;
import com.fleeter.entities.master.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalCallerLead extends User {

	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	

	
	
}
