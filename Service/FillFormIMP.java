package com.Project.FormMaster.Service;

import java.util.List;
import java.util.Map;

import com.Project.FormMaster.Dto.FillFormDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.servlet.http.HttpServletRequest;

public interface FillFormIMP {
	

	String saveAnswers(HttpServletRequest request) throws JsonMappingException, JsonProcessingException;
	
	List<Object[]> CompleteForm();
	
	public Map<String, Object> completeformpreview(HttpServletRequest request);
	
	public List<Object[]> CompletePreview(int formid,int userMasterId);
}
