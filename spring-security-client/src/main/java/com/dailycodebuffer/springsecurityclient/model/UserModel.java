package com.dailycodebuffer.springsecurityclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class UserModel
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
    
    
    
    
	public UserModel(String firstName, String lastName, String email, String password, String matchingPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
	}
	
	
	public UserModel() {
		
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
		
	}
	@Override
	public String toString() {
		return "UserModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", matchingPassword=" + matchingPassword + "]";
	}

}
