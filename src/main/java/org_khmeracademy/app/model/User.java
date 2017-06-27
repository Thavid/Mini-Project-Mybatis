package org_khmeracademy.app.model;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
	public int id;
	private String name;
	private String email;
	private String gender;
	private String phonenumber;
	private String status;
	private String user_hash;
	private Timestamp created_date;
	public User(int id, String name, String email, String gender, String phonenumber, String status, String user_hash,
			Timestamp created_date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.status = status;
		this.user_hash = user_hash;
		this.created_date = created_date;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser_hash() {
		return user_hash;
	}

	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public User( String name, String email, String gender, String phonenumber, String status,
			String user_hash) {

		
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.status = status;
		this.user_hash = user_hash;

	}
	public User(){}
	
}
