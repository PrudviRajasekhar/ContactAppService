package com.phonebook.service;

import java.util.List;

import com.phonebook.model.ContactDetails;

public interface IPhonebookService {
	Long createContact(ContactDetails contactdetails);
	List<ContactDetails> findAllContacts();
	ContactDetails findOneContact(Long id);
	void deleteOneContact(Long id);
	void updateContact(ContactDetails contactdetails);
	
	Boolean saveContact(ContactDetails contactDetails);
	Boolean deleteContactById (Long contactId);

}
