package com.phonebook.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Contact_Details")
public class ContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	
	private String contactName;
	
	private String ContactEmail;
	
	private Long contactGsm;
	
	private String activeSw;
	
	@CreationTimestamp
	private Date createDate;
	
	@UpdateTimestamp
	private Date updateDate;
	
}
