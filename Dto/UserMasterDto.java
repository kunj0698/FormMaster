package com.Project.FormMaster.Dto;

public class UserMasterDto {
	
	public int UserMasterId;
	public String FirstName;
	public String LastName;
	public String Email;
	public String ContactNo;
	public String Gender;
	public String ValidFrom;
	public String ValidTo;
	public String Role;
	public String Image;
	public String Active;
	private String Password;

	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
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
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
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
	
	
	
	
}
