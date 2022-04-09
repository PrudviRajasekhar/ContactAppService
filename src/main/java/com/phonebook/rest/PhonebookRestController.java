package com.phonebook.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.constants.Constants;
import com.phonebook.model.ContactDetails;
import com.phonebook.props.AppProperties;
import com.phonebook.service.IPhonebookService;

@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class PhonebookRestController {
	
	@Autowired
	private IPhonebookService service; //HAS-A
	
	@Autowired
	private AppProperties appProperties;
	
//	@Autowired
//	private Constants constants;
	
	@PostMapping("create/contact")
	public ResponseEntity<String> contact(
			@RequestBody ContactDetails contactDetails) 
	{
		Long id = service.createContact(contactDetails);
		String message = "Contact '"+id+"' created!";
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@PostMapping("/contact")
	public String createcontact(
			@RequestBody ContactDetails contactDetails) 
	{
		Boolean status = service.saveContact(contactDetails);
		
		if(status) {
		return appProperties.getMessages().get(Constants.CONTACT_SAVE_SUCC) ;
		}
		else {
			return appProperties.getMessages().get(Constants.CONTACT_SAVE_FAIL);
		}
	}
	
	@DeleteMapping("/contact/{contactId}")
	public String delete(
			@PathVariable Long contactId
			)
	{
		
		Boolean status = service.deleteContactById(contactId);
			
		if(status) {
			return appProperties.getMessages().get(Constants.CONTACT_DEL_SUCC) ;
			}
			else {
				return appProperties.getMessages().get(Constants.CONTACT_DEL_FAIL);
			}
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<ContactDetails>> findAllContacts() {
		List<ContactDetails> list = service.findAllContacts();
		return new ResponseEntity<List<ContactDetails>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/contact/{id}")
	public ResponseEntity<?> findOneContact(
			@PathVariable Long id
			) 
	{
		ResponseEntity<?> resp = null;
		try {
			ContactDetails contactDetails =  service.findOneContact(id);
			resp = new ResponseEntity<ContactDetails>(contactDetails,HttpStatus.OK); //200
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return resp;
	}
	
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteContact(
			@PathVariable Long id
			)
	{
		ResponseEntity<String> resp = null;
		try {
			service.deleteOneContact(id);
			resp = new ResponseEntity<String>("Contact Deleted",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return resp;
	}

}
