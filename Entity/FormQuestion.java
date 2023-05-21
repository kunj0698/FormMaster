package com.Project.FormMaster.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FormQuestion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int QuestionId;
	
	private String QuestionLable;
	private  String QuestionName ;
	private String Description;
	private int QuestionTypeId;
	private String Required;
	private String Validate;
	private int ValidateId;
	
	//@OneToOne(mappedBy="formid")
	private int formid;
	
	private int createdby;
	private LocalDateTime createdon;
	private int modifiedby;
	private LocalDateTime modifiedon;
	private String active;
	public FormQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
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
	public int getQuestionTypeId() {
		return QuestionTypeId;
	}
	public void setQuestionTypeId(int questionTypeId) {
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
	public int getValidateId() {
		return ValidateId;
	}
	public void setValidateId(int validateId) {
		ValidateId = validateId;
	}
	public int getFormid() {
		return formid;
	}
	public void setFormid(int formid) {
		this.formid = formid;
	}
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	public int getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}
	public LocalDateTime getModifiedon() {
		return modifiedon;
	}
	public void setModifiedon(LocalDateTime modifiedon) {
		this.modifiedon = modifiedon;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public FormQuestion(int questionId, String questionLable, String questionName, String description,
			int questionTypeId, String required, String validate, int validateId, int formid, int createdby,
			LocalDateTime createdon, int modifiedby, LocalDateTime modifiedon, String active) {
		super();
		QuestionId = questionId;
		QuestionLable = questionLable;
		QuestionName = questionName;
		Description = description;
		QuestionTypeId = questionTypeId;
		Required = required;
		Validate = validate;
		ValidateId = validateId;
		this.formid = formid;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedby = modifiedby;
		this.modifiedon = modifiedon;
		this.active = active;
	}
	@Override
	public String toString() {
		return "FormQuestion [QuestionId=" + QuestionId + ", QuestionLable=" + QuestionLable + ", QuestionName="
				+ QuestionName + ", Description=" + Description + ", QuestionTypeId=" + QuestionTypeId + ", Required="
				+ Required + ", Validate=" + Validate + ", ValidateId=" + ValidateId + ", formid=" + formid
				+ ", createdby=" + createdby + ", createdon=" + createdon + ", modifiedby=" + modifiedby
				+ ", modifiedon=" + modifiedon + ", active=" + active + "]";
	}
	
	
}
		