package com.whatsapp.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.whatsappuser;

public class WhatsAppDAO implements WhatsAppDAOInterface {

	public int createProfileDAO(whatsappuser ws) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","venu18");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, ws.getName());
			ps.setString(2, ws.getPassword());
			ps.setString(3, ws.getEmail());
			ps.setString(4, ws.getAddress());
			//step 4 execute query
			
			i=ps.executeUpdate(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	 	
			

	public List<whatsappuser> viewAllProfile() {
		List<whatsappuser> ll=new ArrayList<whatsappuser>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","venu18");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser");
			
			
			//step 4 execute query
			
			ResultSet res=ps.executeQuery(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			while(res.next()) {
				whatsappuser ww=new whatsappuser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
				
				ll.add(ww);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	public whatsappuser viewProfile(whatsappuser ws) {
		whatsappuser ww=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","venu18");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where name=?");
			ps.setString(1, ws.getName());
			
			//step 4 execute query
			ResultSet res=ps.executeQuery(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			if(res.next()) {
				ww=new whatsappuser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}

	public int editProfileDAO(whatsappuser ws1) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","venu18");
			
			PreparedStatement ps=con.prepareStatement("update whatsappuser set password=?,email=?,address=? where name=?");
			
			ps.setString(1, ws1.getPassword());
			ps.setString(2, ws1.getEmail());
			ps.setString(3, ws1.getAddress());
			ps.setString(4, ws1.getName());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deleteProfileDAO(whatsappuser iu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","venu18");
			
			PreparedStatement ps=con.prepareStatement("delete from whatsappuser where name=?");
			
			
			ps.setString(1, iu.getName());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}




	public whatsappuser searchProfile(whatsappuser ws) {
		 whatsappuser ww=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","venu18");
			
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where name=?");
			ps.setString(1, ws.getName());
			
			
			ResultSet res=ps.executeQuery(); 
			if(res.next()) {
				ww=new whatsappuser();
				ww.setName(res.getString(1));
				ww.setPassword(res.getString(2));
				ww.setEmail(res.getString(3));
				ww.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ww;
	}

	

}
