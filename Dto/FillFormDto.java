package com.Project.FormMaster.Dto;

import java.time.LocalDateTime;

public class FillFormDto {

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
	
	
}
