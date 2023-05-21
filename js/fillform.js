/*


var formName = document.getElementById("formName").value;

$.ajax({

	method: "GET",
	url: "/formName",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#formName").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#formName").selectpicker('refresh');
	}
});



//go show

$('#submit').click(function() {
debugger
	$.confirm
		({
			title: 'Record Will Be Permenantly Moved From This Page!',
			content: 'Are You Sure To Move This Form To Completed Forms?',
			buttons:
			{
				confirm:
				{
					text: 'Yes',
					btnClass: 'btn-success',

					action: function() {
						fillformans = [];
						multiselectckbxval = [];

						for (i = 0; i < questId.length; i++) {
							if (questId[i].QuestionTypeId == 2) {
								let answerid = $('input[name=' + questId[i].QuestionId + ']:checked').val();
								fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, answerid: answerid, QuestionTypeId: questId[i].QuestionTypeId });
							}

							else if (questId[i].QuestionTypeId == 3) {
								let val = $('input[name=' + questId[i].QuestionId + ']:checked');
								val.each(function() {
									multiselectckbxval.push($(this).val());
									fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, answerid: $(this).val(), QuestionTypeId: questId[i].QuestionTypeId });
								});
							}

							else {
								if (questId[i].QuestionTypeId == 7) {
									$.each($('#' + questId[i].QuestionId + '').val(), function(index, value) {
										fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, answerid: value, QuestionTypeId: questId[i].QuestionTypeId });
									});
								}
								else {
									fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, answerid: $('#' + questId[i].QuestionId + '').val(), QuestionTypeId: questId[i].QuestionTypeId });
								}
							}
						}
						$('#fillformpreview').html("");
						$('.showformfill').removeClass("d-block");
						$('.showformfill').addClass("d-none");
						SaveFillFormAnswers();
						 console.log(fillformans)
					}
				},
				cancel:
				{
					text: 'Not-Yet',
					btnClass: 'btn-danger'
				},
			}
		});
});

function SaveFillFormAnswers() {
	$.ajax
		({
			type: "POST",
			url: "/SavefillForm",
         
			data: { 'fillformdata': JSON.stringify(fillformans) },
		
			success: function(data) {
				
				getAllForm();
				req = [];
			},
		});
}

$("#submit").click(function() {
	SaveFillFormAnswers();
});
	
	
	



*/