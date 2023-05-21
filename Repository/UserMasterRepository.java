package com.Project.FormMaster.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Project.FormMaster.Entity.UserMaster;

public interface UserMasterRepository  extends JpaRepository<UserMaster, Integer>{

	@Query 
	 (value="SELECT * FROM formmaster.gender;", nativeQuery=true)
	 List<Object[]> gender();

	@Query 
	 (value="SELECT * FROM formmaster.role;", nativeQuery=true)
	List<Object[]> role();

	
	@Query 
	  (value="select * from  formmaster.user_master where active!=9;", nativeQuery=true)
	List<Object[]> Grid();

	

	@Query 
	  (value="select * from  formmaster.user_master where email=:email", nativeQuery=true)
	UserMaster findByEmail(String email);

}
