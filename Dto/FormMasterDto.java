package com.Project.FormMaster.Dto;

import java.util.ArrayList;
import java.util.List;

public class FormMasterDto {

	private int formid;
	private String formtitle;
	private String aliasname;
	private String moduleid;
	private String characteristicid;
	private String subcharacteristicid;
	private String recurranceid;
	private String monthid;
	private String complianceperiod;
	private String effectivedate;
	private String formtext;
	private String active;
	private String createdby;
	private String createdon;
	private String modifiedby;
	private String modifiedon;

  List<ques> ques = new ArrayList<>();

	 
	public static class ques {

		public int QuestionId;
		public int formid;
		public String QuestionLable;
		public String QuestionName;
		public String Description;
		public String QuestionTypeId;
		public String Required;
		public String Validate;
		public String ValidateId;
		public String action;
		
		
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public int getQuestionId() {
			return QuestionId;
		}
		public void setQuestionId(int questionId) {
			QuestionId = questionId;
		}
		public int getFormid() {
			return formid;
		}
		public void setFormid(int formid) {
			this.formid = formid;
		}
		public String getQuestionLable() {
			return QuestionLable;
		}
		public void setQuestionLable(String questionLable) {
			QuestionLable = questionLable;
		}
		public String getQuestionName() {
			return QuestionName;
		}
		public void setQuestionName(String questionName) {
			QuestionName = questionName;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getQuestionTypeId() {
			return QuestionTypeId;
		}
		public void setQuestionTypeId(String questionTypeId) {
			QuestionTypeId = questionTypeId;
		}
		public String getRequired() {
			return Required;
		}
		public void setRequired(String required) {
			Required = required;
		}
		public String getValidate() {
			return Validate;
		}
		public void setValidate(String validate) {
			Validate = validate;
		}
		public String getValidateId() {
			return ValidateId;
		}
		public void setValidateId(String validateId) {
			ValidateId = validateId;
		}
		
		 public List<Answer> Answer= new ArrayList<>();
			public List<Answer> getAnswer() {
				return Answer;
			}

			public void setAnswer(List<Answer> answer) {
				Answer = answer;
			}


		public static class Answer{
			
			public  String  Ans ,flag;
			public int Answerid;
			
			public int getAnswerid() {
				return Answerid;
			}

			public void setAnswerid(int answerid) {
				Answerid = answerid;
			}

			public String getFlag() {
				return flag;
			}

			public void setFlag(String flag) {
				this.flag = flag;
			}


			public String getAns() {
				return Ans;
			}

			public void setAns(String ans) {
				Ans = ans;
			}
			
			 
			
		}

	}

	
	public List<ques> getQues() {
		return ques;
	}

	public void setQues(List<ques> ques) {
		this.ques = ques;
	}
	
	
	//**********************************************ANSWER************************************************************//

//	


	public FormMasterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}

	public String getFormtitle() {
		return formtitle;
	}

	public void setFormtitle(String formtitle) {
		this.formtitle = formtitle;
	}

	public String getAliasname() {
		return aliasname;
	}

	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getCharacteristicid() {
		return characteristicid;
	}

	public void setCharacteristicid(String characteristicid) {
		this.characteristicid = characteristicid;
	}

	public String getSubcharacteristicid() {
		return subcharacteristicid;
	}

	public void setSubcharacteristicid(String subcharacteristicid) {
		this.subcharacteristicid = subcharacteristicid;
	}

	public String getRecurranceid() {
		return recurranceid;
	}

	public void setRecurranceid(String recurranceid) {
		this.recurranceid = recurranceid;
	}

	public String getMonthid() {
		return monthid;
	}

	public void setMonthid(String monthid) {
		this.monthid = monthid;
	}

	public String getComplianceperiod() {
		return complianceperiod;
	}

	public void setComplianceperiod(String complianceperiod) {
		this.complianceperiod = complianceperiod;
	}

	public String getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getFormtext() {
		return formtext;
	}

	public void setFormtext(String formtext) {
		this.formtext = formtext;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifiedon() {
		return modifiedon;
	}

	public void setModifiedon(String modifiedon) {
		this.modifiedon = modifiedon;
	}

}