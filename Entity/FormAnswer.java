package com.Project.FormMaster.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int Answerid;
	
	private int formid;
	private int QuestionId;
	private int QuestionTypeId;
	private String Answer;

	private int createdby;
	private LocalDateTime createdon;
	private int modifiedby;
	private LocalDateTime modifiedon;
	private String active;
	
	
	
	public FormAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public FormAnswer(int answerid, int formid, int questionId, int questionTypeId, String answer, int createdby,
			LocalDateTime createdon, int modifiedby, LocalDateTime modifiedon, String active) {
		super();
		Answerid = answerid;
		this.formid = formid;
		QuestionId = questionId;
		QuestionTypeId = questionTypeId;
		Answer = answer;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedby = modifiedby;
		this.modifiedon = modifiedon;
		this.active = active;
	}




	public int getAnswerid() {
		return Answerid;
	}
	public void setAnswerid(int answerid) {
		Answerid = answerid;
	}
	public int getFormid() {
		return formid;
	}
	public void setFormid(int formid) {
		this.formid = formid;
	}
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}
	public int getQuestionTypeId() {
		return QuestionTypeId;
	}
	public void setQuestionTypeId(int questionTypeId) {
		QuestionTypeId = questionTypeId;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
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




	@Override
	public String toString() {
		return "FormAnswer [Answerid=" + Answerid + ", formid=" + formid + ", QuestionId=" + QuestionId
				+ ", QuestionTypeId=" + QuestionTypeId + ", Answer=" + Answer + ", createdby=" + createdby
				+ ", createdon=" + createdon + ", modifiedby=" + modifiedby + ", modifiedon=" + modifiedon + ", active="
				+ active + "]";
	}
	
	
	
	
}
