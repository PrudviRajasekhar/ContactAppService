package com.phonebook.constants;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class Constants {

	public static final String CONTACT_SAVE_SUCC = "contactSaveSucc";
	public static final String CONTACT_SAVE_FAIL = "contactsaveFail";
	public static final String CONTACT_DEL_SUCC = "contactDelSucc";
	public static final String CONTACT_DEL_FAIL = "contactDelFail";
}
