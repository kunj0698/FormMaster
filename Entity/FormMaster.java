package com.Project.FormMaster.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FormMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int formid;
	
	private String formtitle;
	private  String aliasname;
	private int moduleid;
	private int characteristicid;
	private int subcharacteristicid;
	private int recurranceid;
	private int monthid;
	private String complianceperiod;
	private String effectivedate;
	private String formtext;
	private String active;
	private int createdby;
	private LocalDateTime createdon;
	private int modifiedby;
	private LocalDateTime modifiedon;
	public FormMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormMaster(int formid, String formtitle, String aliasname, int moduleid, int characteristicid,
			int subcharacteristicid, int recurranceid, int monthid, String complianceperiod, String effectivedate,
			String formtext, String active, int createdby, LocalDateTime createdon, int modifiedby,
			LocalDateTime modifiedon) {
		super();
		this.formid = formid;
		this.formtitle = formtitle;
		this.aliasname = aliasname;
		this.moduleid = moduleid;
		this.characteristicid = characteristicid;
		this.subcharacteristicid = subcharacteristicid;
		this.recurranceid = recurranceid;
		this.monthid = monthid;
		this.complianceperiod = complianceperiod;
		this.effectivedate = effectivedate;
		this.formtext = formtext;
		this.active = active;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedby = modifiedby;
		this.modifiedon = modifiedon;
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
	public int getModuleid() {
		return moduleid;
	}
	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}
	public int getCharacteristicid() {
		return characteristicid;
	}
	public void setCharacteristicid(int characteristicid) {
		this.characteristicid = characteristicid;
	}
	public int getSubcharacteristicid() {
		return subcharacteristicid;
	}
	public void setSubcharacteristicid(int subcharacteristicid) {
		this.subcharacteristicid = subcharacteristicid;
	}
	public int getRecurranceid() {
		return recurranceid;
	}
	public void setRecurranceid(int recurranceid) {
		this.recurranceid = recurranceid;
	}
	public int getMonthid() {
		return monthid;
	}
	public void setMonthid(int monthid) {
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
	@Override
	public String toString() {
		return "FormMaster [formid=" + formid + ", formtitle=" + formtitle + ", aliasname=" + aliasname + ", moduleid="
				+ moduleid + ", characteristicid=" + characteristicid + ", subcharacteristicid=" + subcharacteristicid
				+ ", recurranceid=" + recurranceid + ", monthid=" + monthid + ", complianceperiod=" + complianceperiod
				+ ", effectivedate=" + effectivedate + ", formtext=" + formtext + ", active=" + active + ", createdby="
				+ createdby + ", createdon=" + createdon + ", modifiedby=" + modifiedby + ", modifiedon=" + modifiedon
				+ "]";
	}
	
	
	
	
}
