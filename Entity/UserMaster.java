package com.Project.FormMaster.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserMasterId;
	
	private String FirstName;
	private String LastName;
	private String Email;
	private int ContactNo;
	private String Gender;
	private String ValidFrom;
	private String ValidTo;
	private String Role;
	private String Image;
	private String Active;
	private String Password;
	public int getUserMasterId() {
		return UserMasterId;
	}
	public void setUserMasterId(int userMasterId) {
		UserMasterId = userMasterId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getContactNo() {
		return ContactNo;
	}
	public void setContactNo(int contactNo) {
		ContactNo = contactNo;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getValidFrom() {
		return ValidFrom;
	}
	public void setValidFrom(String validFrom) {
		ValidFrom = validFrom;
	}
	public String getValidTo() {
		return ValidTo;
	}
	public void setValidTo(String validTo) {
		ValidTo = validTo;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "UserMaster [UserMasterId=" + UserMasterId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Email=" + Email + ", ContactNo=" + ContactNo + ", Gender=" + Gender + ", ValidFrom=" + ValidFrom
				+ ", ValidTo=" + ValidTo + ", Role=" + Role + ", Image=" + Image + ", Active=" + Active + ", Password="
				+ Password + "]";
	}
	public UserMaster(int userMasterId, String firstName, String lastName, String email, int contactNo, String gender,
			String validFrom, String validTo, String role, String image, String active, String password) {
		super();
		UserMasterId = userMasterId;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		ContactNo = contactNo;
		Gender = gender;
		ValidFrom = validFrom;
		ValidTo = validTo;
		Role = role;
		Image = image;
		Active = active;
		Password = password;
	}
	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}