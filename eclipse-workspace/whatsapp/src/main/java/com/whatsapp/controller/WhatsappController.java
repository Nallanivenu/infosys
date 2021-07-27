package com.whatsapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAO;
import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.whatsappuser;

public class WhatsappController implements WhatsappControllerinterface {
	private BufferedReader br;
	private WhatsAppDAOInterface wdao;
	private whatsappuser wu;
	private whatsappuser ws;
	
	public WhatsappController() {
		br=new BufferedReader(new InputStreamReader(System.in));
		wdao=new WhatsAppDAO();
	}
	

	public void createProfileController()throws Exception {
		System.out.println("enter your name");
		String name=br.readLine();
		
		System.out.println("enter your password");
		String password=br.readLine();
		
		System.out.println("enter your email");
		String email=br.readLine();
		
		System.out.println("enter your address");
		String address=br.readLine();
		
		whatsappuser ws=new whatsappuser();
		ws.setName(name);
		ws.setAddress(address);
		ws.setEmail(email);
		ws.setPassword(password);
		
		
		int i=wdao.createProfileDAO(ws);//we shoud transfer data from layer to layer via DTO(data transfer object) design pattern
		
		if(i>0) {
			System.out.println("registration success");
		}
		else {
			System.out.println("registration fail");
		}
	}
		
		
		
		
		
		
	


	public void deleteProfileController() throws Exception{
		
		System.out.println("enter name");
		String name=br.readLine();
		
		whatsappuser iu=new whatsappuser();
		iu.setName(name);
		
		int i=wdao.deleteProfileDAO(iu);
		if(i>0) {
			System.out.println("profile deleted successfully");
		}
		else {
			System.out.println("could not delete profile");
		}
		
	}

	public void viewAllProfileController() throws Exception{
		// TODO Auto-generated method stub
    List<whatsappuser> ww1=wdao.viewAllProfile();
		
		for(whatsappuser ww:ww1) {
			System.out.println("******************************");
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
			System.out.println("******************************");
		}
		
		
	}

	public void searchProfileController() throws Exception{
		System.out.println("enter your name to search profile");
		String name=br.readLine();
		
		whatsappuser ws=new whatsappuser();
		ws.setName(name);
		
		whatsappuser ww=wdao.searchProfile(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available to search");
		}
		
	}

	public void editProfileController() throws Exception{
		System.out.println("enter name");
		String name=br.readLine();
		
		whatsappuser ws=new whatsappuser();
		ws.setName(name);
		
		whatsappuser wi=wdao.viewProfile(ws);
		if(wi!=null) {
			System.out.println("your name is "+wi.getName());
			System.out.println("your old password is "+wi.getPassword());
			System.out.println("your old email is "+wi.getEmail());
			System.out.println("your old address is "+wi.getAddress());
			
			System.out.println("enter new password");
			String npass=br.readLine();
			System.out.println("enter new email");
			String nemail=br.readLine();
			System.out.println("enter new address");
			String naddress=br.readLine();
			
			whatsappuser ws1=new whatsappuser();
			ws1.setName(name);
			ws1.setPassword(npass);
			ws1.setEmail(nemail);
			ws1.setAddress(naddress);
			
			int i=wdao.editProfileDAO(ws1);
			if(i>0) {
				System.out.println("profile edited successfully");
			}
			else {
				System.out.println("could not edit profile");
			}
			
		}
		else {
			System.out.println("profile not found");
		}
			
		
	}


	public void viewProfileController() throws Exception {
		System.out.println("enter your name to view profile");
		String name=br.readLine();
		
		whatsappuser ws=new whatsappuser();
		ws.setName(name);
		
		whatsappuser ww=wdao.viewProfile(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available for given name");
		}
		
	}
}

		
	
		
					
	
		
		
	
	


