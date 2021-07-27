package com.whatsapp.dao;


import java.util.List;

import com.whatsapp.entity.whatsappuser;

public interface WhatsAppDAOInterface {

	int createProfileDAO(whatsappuser ws);
	
	whatsappuser viewProfile(whatsappuser ws);
	
    List<whatsappuser> viewAllProfile();

	int editProfileDAO(whatsappuser ws1);

	int deleteProfileDAO(whatsappuser iu);

	whatsappuser searchProfile(whatsappuser ws);

	




}
