package com.Project.FormMaster.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.Project.FormMaster.Controller.ques;
import com.Project.FormMaster.Dto.FormMasterDto;
import com.Project.FormMaster.Entity.FormAnswer;
import com.Project.FormMaster.Entity.FormMaster;
import com.Project.FormMaster.Entity.FormQuestion;
import com.Project.FormMaster.Repository.FormAnswerRepository;
import com.Project.FormMaster.Repository.FormMasterRepo;
import com.Project.FormMaster.Repository.FormQuestionRepo;

@Service
public class FormMasterService implements FormMasterServiceIMP {

	@Autowired
	FormMasterRepo fmr;

	@Autowired
	FormQuestionRepo fqr;

	@Autowired
	FormAnswerRepository far;

	public List<Object[]> DropMaster() {
		return fmr.DropMaster();
	}

	public List<Object[]> DropCharac(int moduleid) {
		// TODO Auto-generated method stub
		return fmr.DropCharac(moduleid);
	}

	public List<Object[]> DropSubCharac(int characteristicid) {
		// TODO Auto-generated method stub
		return fmr.DropSubCharac(characteristicid);
	}

	// SAVE
	@Override
	public String save(FormMasterDto fmd) {
		FormMaster fm = new FormMaster();

		fm.setActive("1");
		fm.setAliasname(fmd.getAliasname());
		// System.err.println(fmd.getAliasname());
		// System.err.println(fmd.getCharacteristicid());
		fm.setCharacteristicid(Integer.parseInt(fmd.getCharacteristicid()));
		fm.setComplianceperiod(fmd.getComplianceperiod());
		// fm.setCreatedby(0);
		// fm.setCreatedon(null);
		fm.setEffectivedate(fmd.getEffectivedate());
		fm.setFormid(fmd.getFormid());
		System.out.println(fmd.getFormid());
		fm.setFormtext(fmd.getFormtext());
		fm.setFormtitle(fmd.getFormtitle());
		// fm.setModifiedby(0);
		// fm.setModifiedon(null);
		fm.setModuleid(Integer.parseInt(fmd.getModuleid()));
		fm.setMonthid(Integer.parseInt(fmd.getMonthid()));
		fm.setRecurranceid(Integer.parseInt(fmd.getRecurranceid()));
		fm.setSubcharacteristicid(Integer.parseInt(fmd.getSubcharacteristicid()));

		fmr.save(fm);

		// ********************LOWER
		// fORM*************************************************//

		for (int i = 0; i < fmd.getQues().size(); i++) {
			FormQuestion fq = new FormQuestion();
			fq.setActive("1");
			// fq.setQuestionId(fmd.getQues().get(i).getQuestionId());
			// System.out.println( "QUES ID" + fmd.getQues().get(i).getQuestionId());
			// fq.setQuestionId(fmd.getQues().get(i).getQuestionId());
			fq.setDescription(fmd.getQues().get(i).getDescription());
			fq.setQuestionLable(fmd.getQues().get(i).getQuestionLable());
			fq.setQuestionName(fmd.getQues().get(i).getQuestionName());
			fq.setQuestionTypeId(Integer.parseInt(fmd.getQues().get(i).getQuestionTypeId()));
			fq.setRequired(fmd.getQues().get(i).getRequired());
			fq.setValidate(fmd.getQues().get(i).getValidate());
			// fq.setValidateId(Integer.parseInt(fmd.getQues().get(i).getValidateId()));

			if (fmd.getQues().get(i).getAction().equals("add")) {
				fq.setActive("1");
				fq.setFormid(fm.getFormid());

			} else if (fmd.getQues().get(i).getAction().equals("edit")) {

				fq.setQuestionId(fmd.getQues().get(i).getQuestionId());
				fq.setFormid(fm.getFormid());
			}

			fqr.save(fq);
			/*
			 * fq.setCreatedby(fmd.getCreatedby()); fq.setCreatedon(fmd.getCreatedon());
			 * fq.setModifiedby(fmd.getModifiedby()));
			 * fq.setModifiedon(fmd.getModifiedon());
			 */

			// *****************************answer**********************************//

			FormAnswer fa = new FormAnswer();

			for (int j = 0; j < fmd.getQues().get(i).getAnswer().size(); j++) {

				fa = new FormAnswer();

				String ans = (fmd.getQues().get(i).getAnswer().get(j).getAns());
				fa.setAnswer(ans);

				fa.setActive("1");
				if (fmd.getQues().get(i).getAnswer().get(j).getFlag().equals("addAns")) {

					System.out.println("AnsId add " + fmd.getQues().get(i).getAnswer().get(j).getAnswerid());
					// fa.setAnswerid(fmd.getQues().get(i).getAnswer().get(j).getAnswerid());
					fa.setFormid(fm.getFormid());
					fa.setQuestionId(fq.getQuestionId());
					fa.setQuestionTypeId(fq.getQuestionTypeId());
				} else if (fmd.getQues().get(i).getAnswer().get(j).getFlag().equals("AnsEdit")) {

					System.out.println("AnsId edit " + fmd.getQues().get(i).getAnswer().get(j).getAnswerid());
					fa.setAnswerid(fmd.getQues().get(i).getAnswer().get(j).getAnswerid());

					fa.setFormid(fm.getFormid());
					fa.setQuestionId(fq.getQuestionId());
					fa.setQuestionTypeId(fq.getQuestionTypeId());

				}

				far.save(fa);

			}
		}

		// }

		return " DATA SAVED";
	}

	public List<Object[]> DropRecurrence() {
		// TODO Auto-generated method stub
		return fmr.DropRecurrence();
	}

	public List<Object[]> DropMonth() {
		// TODO Auto-generated method stub
		return fmr.DropMonth();
	}

	// OUTER GRID
	@Override
	public List<Object[]> OutterGrid() { // TODO Auto-generated

		List<Object[]> l = fmr.OutterGrid();
		{

			l.forEach(e -> {
			});

			return l;
		}

	}

//	public Map<String, Object> editId(int formid) {
//		// TODO Auto-generated method stub
//
//		return fmr.editId(formid);
//	}

	public FormMaster getFormData(int formid) {
		FormMaster fmast = new FormMaster();
		System.out.println("edit" + fmast.getAliasname());
		return fmr.getFormData(formid);
//return fmast;
	}

	public List<FormQuestion> getquestions(int formid) {
		// List<FormQuestion> fque=new ArrayList<>();

		return fqr.getquestions(formid);
		// return fque;

	}

	public List<FormAnswer> getanswers(int QuestionId) {
		// List<FormAnswer> fans=new ArrayList<>();
		return far.getanswers(QuestionId);
		// return fans;
	}

	public void delById(int formid) {
		// TODO Auto-generated method
		FormMaster fm = new FormMaster();
		FormQuestion fq = new FormQuestion();
		FormAnswer fa = new FormAnswer();

		Optional<FormMaster> fId = fmr.findById(formid);
		fm = fId.get();
		fm.setActive("9");

		Optional<FormQuestion> qid = fqr.findById(formid);
		fq = qid.get();
		fq.setActive("9");

		Optional<FormAnswer> Aid = far.findById(formid);
		fa = Aid.get();
		fa.setActive("9");

		fmr.save(fm);

	}

	// ***********************************************************************LOWERFORM**************************************//

	// Question Type

	public List<Object[]> DropQues() {
		// TODO Auto-generated method stub return
		return fqr.DropQues();
	}

	public List<Object[]> ValidateType() {
		// TODO Auto-generated method stub
		return fqr.ValidateType();
	}

	public List<Object[]> formName() {
		// TODO Auto-generated method stub
		return fmr.formName();
	}

}
