package com.Project.FormMaster.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.FormMaster.Dto.FillFormDto;
import com.Project.FormMaster.Entity.FillForm;
import com.Project.FormMaster.Entity.FormAnswer;
import com.Project.FormMaster.Entity.FormMaster;
import com.Project.FormMaster.Entity.FormQuestion;
import com.Project.FormMaster.Repository.FillFormRepo;
import com.Project.FormMaster.Repository.FormAnswerRepository;
import com.Project.FormMaster.Repository.FormMasterRepo;
import com.Project.FormMaster.Repository.FormQuestionRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class FillFormService implements FillFormIMP {

	@Autowired
	FillFormRepo ffr;

	@Autowired
	FormAnswerRepository far;
	
	@Autowired
	FormMasterRepo fm;
	
	@Autowired
	FormQuestionRepo fqr;

	@Override
	public String saveAnswers(HttpServletRequest request) throws JsonMappingException, JsonProcessingException {

		String fillformdata = request.getParameter("AnsData");
		System.err.println(fillformdata);

		ObjectMapper objectMapper = new ObjectMapper();

		List<Map<String, Object>> ansList = objectMapper.readValue(fillformdata,
				new TypeReference<List<Map<String, Object>>>() {
				});

		FillForm fillform = null;
		FormAnswer formans = null;

		for (Map<String, Object> ans : ansList) {
			fillform = new FillForm();

			if ((int) ans.get("QuestionTypeId") == 4 || (int) ans.get("QuestionTypeId") == 5
					|| (int) ans.get("QuestionTypeId") == 8) {

				formans = new FormAnswer();
				formans.setFormid((int) ans.get("formid"));
				formans.setQuestionId((int) ans.get("QuestionId"));
				formans.setQuestionTypeId((int) ans.get("QuestionTypeId"));
				formans.setAnswer(((String) ans.get("Answerid")));
				formans.setActive("1");
				formans.setCreatedby(1);
				formans.setCreatedon(LocalDateTime.now());
				;
				formans.setModifiedby(1);
				formans.setModifiedon(LocalDateTime.now());
				// formans.setAnswerid((int)ans.get("Answerid"));
				// far.saveAnswer(formans);
				far.save(formans);
				fillform.setFillFormId(formans.getAnswerid());
				fillform.setFillFormAnswer(formans.getAnswerid());

			} else {
				String answertypename = (String) ans.get("Answerid");
				System.err.println(answertypename);
				fillform.setFillFormAnswer(Integer.parseInt(answertypename));
			}

			fillform.setFormid((int) ans.get("formid"));
			fillform.setQuestionId((int) ans.get("QuestionId"));
			fillform.setCreatedon(LocalDateTime.now());
			fillform.setCreatedby(1);
			fillform.setActive("1");
			// ffr.saveFillFormAns(fillform);
			ffr.save(fillform);
		}
		return fillformdata;
	}
//******************************************COMPLETE FORM GIRD**************************************//
	//******************************************COMPLETE FORM GIRD**************************************//
	
	// COMPLETE FORM GIRD........

	@Override
	public List<Object[]> CompleteForm() {

		return ffr.CompleteForm();

	}

	public Map<String, Object> completeformpreview(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String formid=request.getParameter("formid");
		String userMasterId=request.getParameter("userMasterId");
		
		List<Object[]> previewwholelist= CompletePreview(Integer.parseInt(formid),Integer.parseInt(userMasterId));
		System.err.println("formid  "+formid);
		System.err.println("userMasterId "+userMasterId);
		
		FormMaster fromMst= getFormid(formid);
		
		List<FormQuestion> questionList=questionList(formid);
					
		Map<String, Object> completedForm=new HashMap<>();
		
		completedForm.put("formid",fromMst.getFormid());
		completedForm.put("formtitle", fromMst.getFormtitle());
		completedForm.put("formtext", fromMst.getFormtext());
					
		List<Object> questions=new ArrayList<>();
		
		Map<String, Object> quemap = null;
		
		StringBuilder previewans = null;
		
		for(FormQuestion ques:questionList) 
		{
			quemap=new HashMap<>();
			
			quemap.put("QuestionId", ques.getQuestionId());
			quemap.put("QuestionLabel", ques.getQuestionLable());
			quemap.put("QuestioNname", ques.getQuestionName());
			
			previewans = new StringBuilder();
			  for(Object[] com:previewwholelist) 
			  {
				if(Integer.parseInt(com[5].toString()) == ques.getQuestionId()) 
				{
					 if(previewans.length() > 0) 
					  {
						 previewans.append(",");
			          }
					 previewans.append(com[6]);
				}
			}
			       quemap.put("Answer", previewans);
			       System.err.println(previewans);
			       questions.add(quemap);
		}
		    completedForm.put("ques",questions);

		 return completedForm;
	}
	

	public List<Object[]> CompletePreview(int formid,int userMasterId){
		System.err.print("method  "+formid);
		return  ffr.CompletePreview(formid,userMasterId);
		
	}
	

	  public FormMaster getFormid(String formid)
	  {
		  return fm.getFormid(formid); 
	  }
	  
	  List<FormQuestion> questionList(String formid)
	  {
		  return fqr.questionList(formid); 
	  }
	 

	}
