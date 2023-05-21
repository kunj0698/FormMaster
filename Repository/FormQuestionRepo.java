package com.Project.FormMaster.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Project.FormMaster.Entity.FormQuestion;

public interface FormQuestionRepo extends JpaRepository<FormQuestion, Integer> {

	

	
	
	  @Query (value="Select answertypeid,answertypename from formmaster.answer_type",
	  nativeQuery=true) List<Object[]> DropQues();
	  
	  @Query (value="Select validateid,validatename from formmaster.validate", nativeQuery=true)
	List<Object[]> ValidateType();
	 

	 @Query 
	  (value="SELECT * FROM formmaster.form_question where formid=:formid ", nativeQuery=true)
	List<FormQuestion> getquestions(int formid);

	 
	 @Query 
	  (value="SELECT * FROM formmaster.form_question where formid=:formid ", nativeQuery=true)
	List<FormQuestion> questionList(String formid);
	 
	 
	 
	 
}

