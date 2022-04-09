package com.phonebook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.phonebook.model.ContactDetails;
import com.phonebook.repo.PhonebookRepository;
import com.phonebook.service.IPhonebookService;

@Service
public class PhonebookServiceImpl implements IPhonebookService{

	@Autowired
	private PhonebookRepository phonebookRepository;
	
	public Long createContact(ContactDetails contactdetails) {
		contactdetails.setActiveSw("Y");
		contactdetails = phonebookRepository.save(contactdetails);
		return contactdetails.getContactId();
	}
	
	public Boolean saveContact(ContactDetails contactdetails) {
		contactdetails.setActiveSw("Y");
		contactdetails = phonebookRepository.save(contactdetails);
		return true ;
	}
	
	@Override
	public List<ContactDetails> findAllContacts() {
		ContactDetails contactdtls = new ContactDetails();
		contactdtls.setActiveSw("Y");
		List<ContactDetails> list = phonebookRepository.findAll(Example.of(contactdtls));
		return list;
	}

	@Override
	public ContactDetails findOneContact(Long id) {
		Optional<ContactDetails> opt = phonebookRepository.findById(id);
		
		//if(opt.isPresent()) 
			return opt.get();
		
	}

	@Override
	public void deleteOneContact(Long id) {
		//phonebookRepository.deleteById(id);
		
		phonebookRepository.delete(findOneContact(id));
	}

	@Override
	public void updateContact(ContactDetails contactdetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean deleteContactById(Long contactId) {
		
		Optional<ContactDetails> opt = phonebookRepository.findById(contactId);
		
		if(opt.isPresent()) {
			ContactDetails contactdetails = opt.get();
			contactdetails.setActiveSw("N");
			phonebookRepository.save(contactdetails);
			return true;
		}
		else {
			return false;
		}
	}

	

	
}
