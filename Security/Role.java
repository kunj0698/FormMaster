package com.Project.FormMaster.Security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
	@Id
	private int idrole;
	
	private String role;
	
	public int getIdrole() {
		return idrole;
	}


	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", role=" + role + "]";
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(int idrole, String role) {
		super();
		this.idrole = idrole;
		this.role = role;
	}


	
	

}
