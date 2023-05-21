package com.Project.FormMaster.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.FormMaster.Entity.FormAnswer;
import com.Project.FormMaster.Entity.FormMaster;
import com.Project.FormMaster.Entity.FormQuestion;

@Repository
public interface FormMasterRepo  extends JpaRepository<FormMaster,Integer>{

	
	 @Query 
	 (value="Select moduleid,modulename from formmaster.mst_module", nativeQuery=true)
	 List<Object[]> DropMaster();
	 
	 
	 @Query 
	 (value="Select  formmaster.mst_characteristics.characteristicId,formmaster.mst_characteristics.characteristicname \r\n"
	 		+ "from formmaster.mst_characteristics join formmaster.mst_modulecharacteristicmapping on\r\n"
	 		+ " formmaster.mst_characteristics.characteristicId=formmaster.mst_modulecharacteristicmapping.characteristicId\r\n"
	 		+ "where  formmaster.mst_modulecharacteristicmapping.moduleid=moduleid ", nativeQuery=true)
	 List<Object[]> DropCharac(int moduleid);

	 @Query 
	 (value="Select subcharacteristicId,subcharacteristicname from formmaster.mst_subcharacteristics where formmaster.mst_subcharacteristics.characteristicId=characteristicid ", nativeQuery=true)
	 List<Object[]> DropSubCharac(int characteristicid);

		
	 @Query 
	 (value="Select recurranceid,recurrancenamel from formmaster.mst_recurrance", nativeQuery=true)
	  List<Object[]> DropRecurrence();
	  
		 @Query 
	  (value="Select monthid,monthname from formmaster.mst_month", nativeQuery=true)
	List<Object[]> DropMonth();

	 @Query 
	  (value="select formid,active,formtitle from  formmaster.form_master where active!=9 ;", nativeQuery=true)
		List<Object[]> OutterGrid();

//		 @Query 
//		  (value="Select form_master.formid, form_master.active,form_master.aliasname,form_master.characteristicid,form_master.complianceperiod,form_master.formtitle,form_master.effectivedate,\r\n"
//		  		+ "form_master.formtext,form_master.moduleid,form_master.monthid,form_master.recurranceid,form_master.subcharacteristicid,form_question.question_id,\r\n"
//		  		+ "form_question.description,form_question.question_lable,form_question.question_name ,form_answer.answer,form_answer.formid,\r\n"
//		  		+ "form_answer.question_id,form_answer.question_type_id\r\n"
//		  		+ "from(( form_master left join form_question on form_master.formid= form_question.formid)\r\n"
//		  		+ " left join form_answer on form_question.question_id=form_answer.question_id) where form_master.formid=:formid ", nativeQuery=true)
//		 Map<String,Object>  editId(int formid);
		
		
		
		 @Query 
		  (value="SELECT * FROM formmaster.form_master where formid=:formid ", nativeQuery=true)
		   FormMaster getFormData(int formid);
		
//		@Query 
//		  (value="SELECT fmast FROM FormMaster fmast where formid=:formid ", nativeQuery=true)
//		   FormMaster getFormData(int formid);
		
		
		//fillname

		 @Query 
		  (value="SELECT formid,formtitle from formmaster.form_master", nativeQuery=true)
		       List<Object[]> formName();


	 @Query 
		(value="SELECT * FROM formmaster.form_master fm where formid=:formid ", nativeQuery=true)
		FormMaster getFormid(String formid);
	 
}

