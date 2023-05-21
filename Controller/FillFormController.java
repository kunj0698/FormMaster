package com.Project.FormMaster.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.FormMaster.Dto.FillFormDto;
import com.Project.FormMaster.Service.FillFormService;
import com.Project.FormMaster.Service.FormMasterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FillFormController {

	@Autowired
	FormMasterService fms;
	
	@Autowired
	FillFormService fillform;
	
	@RequestMapping("/fillform")
	public String FillForm() {
		return "fill_forms";
	}
	
	
	@GetMapping("/formName")
	public @ResponseBody List<Object[]> formName() {
		List<Object[]> a = fms.formName();
		return a;
	}
	
	
	@PostMapping("/SavefillForm")
	public @ResponseBody String saveAnswers(HttpServletRequest request) throws JsonMappingException, JsonProcessingException
	{
		
		
	String ans=fillform.saveAnswers(request);
		return ans;
	}	
	//*****************************************COMPLETE FORM **************************************// 

	//*****************************************COMPLETE FORM **************************************// 

	//*****************************************COMPLETE FORM **************************************// 
	
	
	//PAGE LOAD
	@RequestMapping("/completedForm")
	public String completePage() {
		return "completed_forms";
	}
	
	
	
	////COMPLETE FORM GRID 

	@PostMapping("/CompleteFormTable")
	@ResponseBody
	public List<Object[]> CompleteForm()
	{
		return fillform.CompleteForm();
	}
	
	
	//COMPLETE FORM PREVIEW

	@GetMapping("/CompletePreview")
	@ResponseBody
	public Map<String, Object> completeformpreview(HttpServletRequest request) 
	{		
		
         Map<String, Object> req=fillform.completeformpreview(request);
		 return req;
	}
		
}
