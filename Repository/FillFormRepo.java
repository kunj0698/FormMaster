package com.Project.FormMaster.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.FormMaster.Entity.FillForm;
import com.Project.FormMaster.Entity.FormMaster;
import com.Project.FormMaster.Entity.FormQuestion;

public interface FillFormRepo extends JpaRepository<FillForm, Integer> {

	@Query(value = "select DISTINCT form_master.formid, form_master.formtitle, user_master.first_name, user_master.last_name, fill_form.createdby,\r\n"
			+ " user_master.user_master_id FROM form_master JOIN fill_form ON fill_form.fill_form_id=form_master.formid\r\n"
			+ " JOIN user_master ON user_master.user_master_id=fill_form.createdby ", nativeQuery = true)
	List<Object[]> CompleteForm();
	
	
	
//
//	@Query(value = "SELECT filly.fill_form_id,filly.formid,filly.createdby as c,quesy.question_lable,quesy.question_name,\r\n"
//			+ "quesy.question_id, ansy.answer ,filly.createdby\r\n"
//			+ " FROM fill_form filly JOIN form_question quesy ON quesy.question_id = filly.question_id \r\n"
//			+ " JOIN form_answer ansy ON ansy.answerid = filly.fill_form_answer \r\n"
//			+"  JOIN form_master fm ON fm.formid=:formid", nativeQuery = true)
	
//	
//	 	@Query
//	 	(value = "SELECT filly.fill_form_id,filly.formid,filly.createdby as c,quesy.question_lable,quesy.question_name,\r\n"
//	 	+ "quesy.question_id, ansy.answer ,filly.createdby\r\n"
//	 	+ "FROM fill_form filly JOIN form_question quesy ON quesy.question_id=filly.question_id \r\n"
//	 	+ "JOIN form_answer ansy ON ansy.answerid=filly.fill_form_answer \r\n"
//	 	+ "JOIN user_master um ON filly.createdby=:user_master_id where filly.createdby=:user_master_id and filly.formid=:formid", nativeQuery = true)
//		public List<Object[]> CompletePreview(@Param("formid") int formid, @Param("user_master_id") int userMasterId);
	
	@Query(value = "SELECT distinct filly.fill_form_id, filly.formid, filly.createdby as c, quesy.question_lable, quesy.question_name, quesy.question_id, ansy.answer, filly.createdby "
	        + "FROM fill_form filly "
	        + "JOIN form_question quesy ON quesy.question_id = filly.question_id "
	        + "JOIN form_answer ansy ON ansy.answerid = filly.fill_form_answer "
	        + "JOIN user_master um ON filly.createdby = :user_master_id "
	        + "WHERE filly.createdby = :user_master_id AND filly.formid = :formid",
	        nativeQuery = true)
	public List<Object[]> CompletePreview( @Param("formid") int formid,@Param("user_master_id") int userMasterId);

	
}

