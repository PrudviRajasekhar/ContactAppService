package com.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.model.ContactDetails;

public interface PhonebookRepository extends JpaRepository<ContactDetails, Long> {

}
