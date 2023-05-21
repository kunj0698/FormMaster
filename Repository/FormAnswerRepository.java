package com.Project.FormMaster.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Project.FormMaster.Entity.FormAnswer;

public interface FormAnswerRepository  extends JpaRepository<FormAnswer, Integer>{
	


	 @Query 
	  (value="SELECT * FROM formmaster.form_answer where question_id=:QuestionId ", nativeQuery=true)
	 List<FormAnswer> getanswers(int QuestionId);
	
}
