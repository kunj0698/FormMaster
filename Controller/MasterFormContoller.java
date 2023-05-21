package com.Project.FormMaster.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.FormMaster.Dto.FormMasterDto;
import com.Project.FormMaster.Entity.FormAnswer;
import com.Project.FormMaster.Entity.FormMaster;
import com.Project.FormMaster.Entity.FormQuestion;
import com.Project.FormMaster.Service.FormMasterService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MasterFormContoller {

	@Autowired
	FormMasterService fms;

	@RequestMapping("/masterform")
	public String MasterForm() {
		return "master_form";
	}

	// save

	@PostMapping("/AddForm")
	public @ResponseBody String save(@RequestBody FormMasterDto fmd) {

		/*
		 * System.err.println(fmd.getQues().size()); System.err.println("ans = "+
		 * fmd.getQues().get(0).getAnswer());
		 * System.out.println(fmd.getQues().get(0).getAnswer().size()); for(int
		 * i=0;i<fmd.getQues().get(0).getAnswer().size();i++) {
		 * //System.out.println("answr");
		 * System.err.println("ans"+fmd.getQues().get(0).getAnswer().get(i).getAns());
		 * System.err.println("ans"+fmd.getQues().get(1).getAnswer().get(i).getAns());
		 * 
		 * }
		 */
		/*
		 * for(int i=0;i<fmd.getQues().size();i++) { for(int
		 * j=0;j<fmd.getQues().get(i).getAnswer().size();j++) {
		 * System.out.println("opt"+ fmd.getQues().get(i).getAnswer().get(j).getAns());
		 * 
		 * }
		 * 
		 * }
		 */
		// for(int i=0;i<fmd.getQues().size();i++) {
		// System.err.println(q.get(0).getQuestionLable());
		/*
		 * System.err.println(fmd.getQues().get(i).getQuestionName());
		 * System.err.println(fmd.getQues().get(i).getQuestionTypeId());
		 */

		String data = fms.save(fmd);
		return data;

	}
 
	@GetMapping("/DropModule")
	public @ResponseBody List<Object[]> DropMaster() {
		List<Object[]> a = fms.DropMaster();
		return a;
	}

	@GetMapping("/characteristic")
	public @ResponseBody List<Object[]> DropCharac(@RequestParam("moduleid") int moduleid) {
		List<Object[]> b = fms.DropCharac(moduleid);
		return b;
	}

	@GetMapping("/subcharacteristic")
	public @ResponseBody List<Object[]> DropSubCharac(@RequestParam("characteristicid") int characteristicid) {
		List<Object[]> c = fms.DropSubCharac(characteristicid);
		return c;
	}

	@GetMapping("/recurrence")
	public @ResponseBody List<Object[]> DropRecurrence() {
		List<Object[]> d = fms.DropRecurrence();
		return d;
	}

	@GetMapping("/startmonth")
	public @ResponseBody List<Object[]> DropMonth() {
		List<Object[]> d = fms.DropMonth();
		return d;
	}

	// OUTTER GRID
	@GetMapping("/outergrid")
	public @ResponseBody List<Object[]> OutterGrid() {
		List<Object[]> ss = fms.OutterGrid();
		System.out.println(ss);
		return ss;
	}

// EDIT
//	@GetMapping("/getId/{formid}")
//	@ResponseBody
//	public Map<String, Object>  editId(@PathVariable("formid") int formid) {
//		System.out.println(formid);
//		return (Map<String, Object>) fms.editId(formid);
//	}
                             //EDIT
	@GetMapping("/getId/{formid}")
	@ResponseBody
	public Map<String, Object> editId(@PathVariable("formid") int formid) 
	{

		//FormMaster fm=new FormMaster();
		
		FormMaster formmaster = fms.getFormData(formid);

		List<FormQuestion> formQ = fms.getquestions(formmaster.getFormid());

		List<Object> appendQue = new ArrayList<>();

		for(FormQuestion fq : formQ) {

			Map<String, Object> formQue = new HashMap<>();

			List<Object> AnswerList = new ArrayList<>();

			formQue.put("Active", fq.getActive());

			formQue.put("QuestionId", fq.getQuestionId());
			formQue.put("QuestionLable", fq.getQuestionLable());
			formQue.put("QuestionName", fq.getQuestionName());
			formQue.put("QuestionTypeId", fq.getQuestionTypeId());
			formQue.put("Description", fq.getDescription());
			formQue.put("Required", fq.getRequired());
			formQue.put("Validate", fq.getValidate());
			formQue.put("ValidateId", fq.getValidateId());


			List<FormAnswer> formA = fms.getanswers(fq.getQuestionId());

			for(FormAnswer fAns : formA) {

				Map<String, Object> formAns = new HashMap<>();

				formAns.put("Ans", fAns.getAnswer());
				formAns.put("Answerid", fAns.getAnswerid());
				AnswerList.add(formAns);

			}
			
			formQue.put("Answer", AnswerList);
			appendQue.add(formQue);
		}
			Map<String, Object> AllData = new HashMap<>();

			AllData.put("moduleid", formmaster.getModuleid());

			// formData.formid = formid;
			AllData.put("formid", formmaster.getFormid());
			AllData.put("formtitle", formmaster.getFormtitle());
			AllData.put("aliasname", formmaster.getAliasname());
			AllData.put("characteristicid", formmaster.getCharacteristicid());
			AllData.put("subcharacteristicid", formmaster.getSubcharacteristicid());
			AllData.put("recurranceid", formmaster.getRecurranceid());
			AllData.put("monthid", formmaster.getMonthid());
			AllData.put("complianceperiod", formmaster.getComplianceperiod());
			AllData.put("effectivedate", formmaster.getEffectivedate());
			AllData.put("active", formmaster.getActive());
			AllData.put("formtext", formmaster.getFormtext());
            AllData.put("ques",appendQue);
            
		

		return AllData;
	}
	
	

	// DELETE
	@ResponseBody
	@PostMapping("/delete/{formid}")
	public String delById(@PathVariable("formid") int formid) {
		fms.delById(formid);
		return "deleted";
	}

	// *******************LOWER
	// FORM*******************************************************************
	// Question type
	@GetMapping("/QuestionType")
	public @ResponseBody List<Object[]> DropQues() {
		List<Object[]> e = fms.DropQues();
		return e;
	}

	// VALIDATE TYPE

	@GetMapping("/validateType")
	public @ResponseBody List<Object[]> ValidateType() {
		List<Object[]> f = fms.ValidateType();
		return f;
	}
	
	//PREVIEW
	@GetMapping("/preview/{formid}")
	@ResponseBody
	public Map<String, Object> preview(@PathVariable("formid") int formid) 
	{

		//FormMaster fm=new FormMaster();
		
		FormMaster formmaster = fms.getFormData(formid);

		List<FormQuestion> formQ = fms.getquestions(formmaster.getFormid());

		List<Object> appendQue = new ArrayList<>();

		for(FormQuestion fq : formQ) {

			Map<String, Object> formQue = new HashMap<>();

			List<Object> AnswerList = new ArrayList<>();

			formQue.put("Active", fq.getActive());

			formQue.put("QuestionId", fq.getQuestionId());
			formQue.put("QuestionLable", fq.getQuestionLable());
			formQue.put("QuestionName", fq.getQuestionName());
			formQue.put("QuestionTypeId", fq.getQuestionTypeId());
			formQue.put("Description", fq.getDescription());
			formQue.put("Required", fq.getRequired());
			formQue.put("Validate", fq.getValidate());
			formQue.put("ValidateId", fq.getValidateId());

			List<FormAnswer> formA = fms.getanswers(fq.getQuestionId());

			for(FormAnswer fAns : formA) {

				Map<String, Object> formAns = new HashMap<>();

				formAns.put("Ans", fAns.getAnswer());
				formAns.put("Answerid", fAns.getAnswerid());
				AnswerList.add(formAns);

			}
			
			formQue.put("Answer", AnswerList);
			appendQue.add(formQue);
		}
			Map<String, Object> AllData = new HashMap<>();

			AllData.put("moduleid", formmaster.getModuleid());

			// formData.formid = formid;
			AllData.put("formid", formmaster.getFormid());
			AllData.put("formtitle", formmaster.getFormtitle());
			AllData.put("aliasname", formmaster.getAliasname());
			AllData.put("characteristicid", formmaster.getCharacteristicid());
			AllData.put("subcharacteristicid", formmaster.getSubcharacteristicid());
			AllData.put("recurranceid", formmaster.getRecurranceid());
			AllData.put("monthid", formmaster.getMonthid());
			AllData.put("complianceperiod", formmaster.getComplianceperiod());
			AllData.put("effectivedate", formmaster.getEffectivedate());
			AllData.put("active", formmaster.getActive());
			AllData.put("formtext", formmaster.getFormtext());
            AllData.put("ques",appendQue);
		

		return AllData;
	}
	

} 
