package com.fleeter.entities.roles;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fleeter.entities.master.Branch;
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
public class Applicant extends User {
	
 @OneToOne(cascade = CascadeType.ALL)
	private Person person;
	private String aadhar;
	private String pan;
	private String remark;
	
	

}
