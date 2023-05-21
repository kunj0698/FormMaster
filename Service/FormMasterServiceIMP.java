package com.Project.FormMaster.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.Project.FormMaster.Dto.FormMasterDto;
import com.Project.FormMaster.Entity.FormAnswer;
import com.Project.FormMaster.Entity.FormMaster;
import com.Project.FormMaster.Entity.FormQuestion;

public interface FormMasterServiceIMP {
	 List<Object[]> DropMaster();
	 
	 List<Object[]> DropCharac(int moduleid);
	 
	 List<Object[]> DropSubCharac(int characteristicid) ;
	 
	  List<Object[]> DropRecurrence();
	  
	  List<Object[]> DropMonth();
	  String save(FormMasterDto fmd);

	List<Object[]> OutterGrid();
	
//	Map<String, Object>  editId(int formid);
	
	
	FormMaster getFormData(int formid);
	
	List<FormQuestion> getquestions(int formid);
	
	 List<FormAnswer> getanswers(int QuestionId);
	
	 void delById(int formid);
	 
	 
	 ///LOWEER FORM

	 List<Object[]> DropQues();
	 
	 List<Object[]> ValidateType();
	 
	 //formfill
	 public List<Object[]> formName();
}
