package models;

import javax.persistence.Embedded;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import play.data.validation.Email;
import play.data.validation.Password;

@Document
public class User {

	@Id
	private ObjectId id;
	private String firstName;
	private String secondName;
	private String userName;
	@Password
	private String password;
	@Email
	private String emailId;
	
	@Embedded
	private Role role;
	
	private boolean isSuperAdmin = false;
	
	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}
	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public ObjectId getId() {
		return id;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	private enum Role{
		user, admin, channelPartner
	}
}
