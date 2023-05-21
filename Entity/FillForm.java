package com.Project.FormMaster.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FillForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FillFormId;

	private int formid;
	private int QuestionId;
	private int FillFormAnswer;
	private int createdby;
	private LocalDateTime createdon;
	private String active;
	public int getFillFormId() {
		return FillFormId;
	}
	public void setFillFormId(int fillFormId) {
		FillFormId = fillFormId;
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
	public int getFillFormAnswer() {
		return FillFormAnswer;
	}
	public void setFillFormAnswer(int fillFormAnswer) {
		FillFormAnswer = fillFormAnswer;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "FillForm [FillFormId=" + FillFormId + ", formid=" + formid + ", QuestionId=" + QuestionId
				+ ", FillFormAnswer=" + FillFormAnswer + ", createdby=" + createdby + ", createdon=" + createdon
				+ ", active=" + active + "]";
	}
	public FillForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FillForm(int fillFormId, int formid, int questionId, int fillFormAnswer, int createdby,
			LocalDateTime createdon, String active) {
		super();
		FillFormId = fillFormId;
		this.formid = formid;
		QuestionId = questionId;
		FillFormAnswer = fillFormAnswer;
		this.createdby = createdby;
		this.createdon = createdon;
		this.active = active;
	}
	
	
	
	
	
}
