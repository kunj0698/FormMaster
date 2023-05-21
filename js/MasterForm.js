loadTable();
var data;
let editid = undefined;
let lowerEditId = "";
var AnsID = "";


$(document).ready(function() {
	//  $("#fileUploadForm").on("change", image);
	loadTable();
	// clear();

});

$('#effectivedate').closest('div').datepicker({
	autoclose: true,
	todayHighlight: true,
	format: "dd/mm/yyyy",
	clearBtn: true
});

//SAVE
var formid = formid;
$('#save').click(function() {
	debugger
	var moduleid = $("#module").val();
	//var formid = $("#form").val();
	var formtitle = $("#titletext").val();
	var aliasname = $("#aliasname").val();
	var characteristicid = $("#characteristic").val();
	var subcharacteristicid = $("#subcharacteristic").val();
	var recurranceid = $("#recurrence").val();
	var monthid = $("#startmonth").val();
	var complianceperiod = $("#complianceperiod").val();
	var effectivedate = $("#effectivedate").val();
	var active = $("#active").val();
	var formtext = $("#text").val();


	//  let NewformData = new FormData();

	let formData = {};

	formData.moduleid = moduleid;
	//formData.formid = formid;
	formData.formtitle = formtitle;
	formData.aliasname = aliasname;
	formData.characteristicid = characteristicid;
	formData.subcharacteristicid = subcharacteristicid;
	formData.recurranceid = recurranceid;
	formData.monthid = monthid;
	formData.complianceperiod = complianceperiod;
	formData.effectivedate = effectivedate;
	formData.active = active;
	formData.formtext = formtext;
	formData.ques = Ques;
	/* 
	 let Question={
		 ...formData,
		 ...Ques
	 }*/

	console.log(formData)

	if (editid) {
		console.log(editid)
		formData.formid = editid;
	}

	/*let Form= JSON.stringify(formData);
	let PostData= JSON.stringify(Ques);
 NewformData.append("Form",Form);
 NewformData.append("postData",PostData);
	*/
	// NewformData.append("fmd",([JSON.stringify(formData)], { type: "application/JSON;charset=UTF-8" }));
	$.ajax({
		method: "POST",
		url: "/AddForm",
		dataType: 'json',
		data: JSON.stringify(formData),
		contentType: "application/json",
		processData: false,
		// contentType: false,
		success: function(data) {
			console.log(data)
			if (data == "DATA EXIST") {
				console.log(data)
				alert(data)

			}
			else {
				alert("DATA SAVED")
				//$("#close").click();
			}
			console.log(data)
			loadTable();

		},


	});


})

//MODULE
$.ajax({

	method: "GET",
	url: "/DropModule",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#module").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#module").selectpicker('refresh');
	}
});

//CHARACTERISTIC
$(document).on("change", "#module", function() {

	let moduleid = $(this).val();


	$.ajax({
		method: "GET",
		url: "/characteristic",
		data: { moduleid: moduleid },

		success: function(formData) {

			$("#characteristic").empty().selectpicker("refresh");
			$("#subcharacteristic").empty().selectpicker("refresh");
			for (var index = 0; index < formData.length; index++) {

				$("#characteristic").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
			}
			if (editiCharac) {
				console.log(editiCharac)
				$("#characteristic").val(editiCharac);
				editiCharac = undefined;
			}

			$("#characteristic").selectpicker('refresh');
		}
	});
});
//SUBCHARACTERISTIC
$(document).on("change", "#characteristic", function() {

	let characteristicid = $(this).val();


	$.ajax({
		method: "GET",
		url: "/subcharacteristic",
		data: { characteristicid: characteristicid },

		success: function(formData) {

			$("#subcharacteristic").empty().selectpicker("refresh");
			for (var index = 0; index < formData.length; index++) {

				$("#subcharacteristic").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
			}
			if (editiSubCharac) {
				console.log(editiSubCharac)
				$("#subcharacteristic").val(editiSubCharac);
				editiSubCharac = undefined;
			}

			$("#subcharacteristic").selectpicker('refresh');
		}
	});
});
//RECURRENCE
$.ajax({

	method: "GET",
	url: "/recurrence",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#recurrence").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#recurrence").selectpicker('refresh');
	}
});
//MONTH
$.ajax({

	method: "GET",
	url: "/startmonth",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#startmonth").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#startmonth").selectpicker('refresh');
	}
});
//OUTER GRID
function loadTable() {
	$.ajax({
		url: "/outergrid",
		type: "GET",

		success: function(data) {
			$(window).on('load', function() {
				if (feather) {
					feather.replace({ width: 14, height: 14 });
				}
			})
			$("#form_datatable").dataTable(

				{
					destroy: true,
					scrollResize: true,
					scrollX: true,
					// scrollY: 100,
					scrollCollapse: true,
					paging: true,
					// lengthChange: false,
					// scrollX: true,
					"bAutoWidth": true,
					// paging: true,
					"bLengthChange": true,
					// fixedColumns: true,
					"data": data,

					"columns": [

						{ data: '0' },
						{ data: '2' },


						{
							data: '1',
							render: function(data) {
								if (data == "1") {
									return `<td class="">
              								<span class="badge badge-success">Yes</span>
           	 							    </td>`;
								}
								else {
									return `<td class="">
              								<span class="badge badge-danger">No</span>
           	 							    </td>`;
								}
							}
						},

						{
							data: null,
							render: function(data, type, meta) {

								return `<td class="text-center"><a href="javascript:void(0)"data-toggle="tooltip" data-placement="bottom"  id="editBtn" onclick=editProduct(${data['0']})
								title="" data-original-title="Edit" class="text-success fa-size client_add_btn"><i class="fa fa-pencil"></i></a> <span data-toggle="modal" data-target="#all_question_preview">
								<a href="javascript:PreviewQuestions(${data['0']})" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Preview" class="text-info fa-size">
								<i class="fa fa-eye"></i></a></span> <span class="delete-user-alert">
								<a href="javascript:void(0)" class="text-danger fa-size" data-toggle="tooltip" data-placement="bottom" onclick=delProduct(${data['0']}) data-original-title="Delete"><i class="fa fa-trash"></i></a></span>
								</td>`;


							}
						},

					],
					"columnDefs":
						[{
							"targets": [0],
							"orderable": false,
							// "width": "2%",
						}],
					"pageLength": 6,

					fixedColumns:
					{
						rightColumns: 0,
						leftColumns: 0
					},
					language:
					{
						paginate:
						{
							next: '<i class="fa fa-angle-double-right">',
							previous: '<i class="fa fa-angle-double-left">'
						}
					},
					dom: "<'row pl-0 pr-1'<'col-xl-9 col-lg-8 col-sm-8'pi><'col-xl-3 col-lg-4 col-sm-4'f>>"
						+ "<'row pl-1 pr-1'<'col-xl-12 col-lg-12 col-sm-12'tr>>"

				});
		}

	});
}

//EDIT
let editiCharac = undefined;
let editiSubCharac = undefined;

function editProduct(formid) {
	console.log(formid)
	editid = formid
	console.log(editid)
	$.ajax({
		type: "GET",
		url: "getId/" + formid,


		success: function(formData) {

			debugger
			$("#module").val(formData.moduleid),
				editiCharac = formData.characteristicid;
			editiSubCharac = formData.subcharacteristicid;
			$("#form").val(formData.formid),
				$("#titletext").val(formData.formtitle),
				$("#aliasname").val(formData.aliasname),

				//$("#characteristic").val(formData.characteristicid),


				$("#subcharacteristic").val(formData.subcharacteristicid),

				$("#recurrence").val(formData.recurranceid),
				$("#startmonth").val(formData.monthid),
				$("#complianceperiod").val(formData.complianceperiod),
				$("#effectivedate").val(formData.effectivedate),
				$("#active").val(formData.active),
				$("#text").val(formData.formtext)


			$('#module').trigger("change").selectpicker('refresh');
			$('#characteristic').selectpicker('refresh');

			$('#characteristic').trigger("change").selectpicker('refresh');
			$('#subcharacteristic').trigger("change").selectpicker('refresh');

			$('#recurrence').selectpicker('refresh');
			$('#startmonth').selectpicker('refresh');




			$.each(formData.ques, function(key, value) {
				var editAns = [];
				$.each(value.Answer, function(key, value) {
					editAns.push({ Answerid: value.Answerid, Ans: value.Ans, flag: "AnsEdit" });
				})



				var data = {
					"QuestionId": value.QuestionId,
					"QuestionLable": value.QuestionLable,
					"QuestionName": value.QuestionName,
					"QuestionTypeId": value.QuestionTypeId,
					"Description": value.Description,
					"Required": value.Required,
					"Validate": value.Validate,
					"ValidateId": value.ValidateId,
					"Answer": editAns,
					"action": "edit",

				};

				Ques.push(data);
				//QuestionId++;

			});

			QuestionTable(Ques);
			//return forData;

		},
	});
}

//DELETE
function delProduct(formid) {
	console.log(formid)

	if (confirm("ARE YOU SURE YOU WANT TO DELETE?")) {
		$.ajax({

			method: 'POST',
			url: "delete/" + formid,

			success: function(response) {

				loadTable();

			},
			error: function(err) {
				alert(err)
			}
		});
	}
}

$(document).on('click', '#back', function() {
	editid = undefined;

	clear();
});

$(document).on('click', '#cancelform', function() {
	editid = undefined;
	clear();
});

$(document).on('click', '#add', function() {
	editid = undefined;
	clear();
});

function clear() {

QuestionTable() === null;

	Ques = [];

	document.getElementById("module").value = "";
	$('#module').selectpicker('refresh');

	document.getElementById("titletext").value = "";

	document.getElementById("characteristic").value = "";
	$("#characteristic").empty().selectpicker("refresh");

	document.getElementById("form").value = "";
	document.getElementById("effectivedate").value = "";
	document.getElementById("aliasname").value = "";
	document.getElementById("text").value = "";

	document.getElementById("subcharacteristic").value = "";
	$("#subcharacteristic").empty().selectpicker("refresh");

	document.getElementById("recurrence").value = "";
	$("#recurrence").selectpicker("refresh");

	document.getElementById("startmonth").value = "";
	$("#startmonth").selectpicker("refresh");


	document.getElementById("complianceperiod").value = "";

	
}

//**************************************************************************LOWER FORM******************************************************** *//


var Ques = [];
/*
function bindEmp(dat) {
	var row = `<tr>
<th>Question #</th>
<th>Question Name</th>
<th>Answer Type</th>
<th>Required</th>
<th>Action</th>
</tr>`;

	dat.forEach(function(d, queid) {
		//var y = d.Required==1? "yes":"no";
		row += `<tr>
  <td>${queid + 1}</td>
  <td>${d["QuestionName"]}</td>
  <td>${d["QuestionTypeId"]}</td>
  <td>${d["Required"]}</td>

  <td class="text-center"><span data-toggle="modal"
																	data-target=".addformquestion"><a
																		href="javascript:void(0)" data-toggle="tooltip"
																		data-placement="bottom" onclick="editibtn(${queid})" data-original-title="Edit"
																		class="text-success fa-size"><i
																			class="fa fa-pencil"></i></a></span> <span
																	class="delete-user-alert"><a
																		href="javascript:void(0)" class="text-danger fa-size"
																		data-toggle="tooltip" data-placement="bottom"
																		data-original-title="Delete"><i
																			class="fa fa-trash"></i></a></span></td>
</tr>`

	})
	document.getElementById("formquestion_datatable").innerHTML = row;
}*/

var Answer1 = [];
var ans = "";
var Ans;
var option;
var QuestionId = 1;
var flag;

$('#save1').click(function() {
	debugger
let ansrow="";
	var QuestionLable = $("#questionlable").val();
	var QuestionName = $("#questionname").val();
	let QuestionTypeId = $("#quetype").val();
	var Description = $("#description1").val();
	var Required = $("#reqans").is(':checked') ? 1 : 0;
	var Validate = $("#validatans").val();
	var ValidateId = $("#AnswerType").val();

	var opt = document.getElementsByName("singlechoice");

	if (QuestionTypeId == "1") {
		ansrow = undefined;
	}
	else if (QuestionTypeId == "4") {
		ansrow = undefined;
	}
	else if (QuestionTypeId == "5") {
		ansrow = undefined;
	}
	else if (QuestionTypeId == "8") {
		ansrow = undefined;
	}
	if (QuestionTypeId == "2") {
		ansrow = ".singlechoicetable"
	}
	else if (QuestionTypeId == "3") {
		ansrow = ".multichoicetable"
	}
	else if (QuestionTypeId == "6") {
		ansrow = ".singleselecttable"
	}
	else if (QuestionTypeId == "7") {
		ansrow = ".multiselecttable"
	}


	let arrayOfanswer = [];
	let Answerid = 0;
	if (AnsID === "") {
		if (QuestionTypeId != undefined) {
		for (var i = 0; i < opt.length; i++) {
			if (opt[i].value != '') {
				Answerid++;
				option = opt[i].value;
				arrayOfanswer.push({ Answerid: Answerid, Ans: option, flag: "addAns" });
			}
			console.log(ans)
		}
}
		console.log("arrayOfanswer")
		console.log(arrayOfanswer)

		let data = {};
		data.QuestionId = QuestionId;
		data.QuestionLable = QuestionLable;
		data.QuestionName = QuestionName;
		data.QuestionTypeId = QuestionTypeId;
		data.Description = Description;
		data.Required = Required;
		data.Validate = Validate;
		data.ValidateId = ValidateId;
		data.Answer = arrayOfanswer;
		data.action = "add";

		Ques.push(data);
		console.log(data)
	}
	else {
		arrayOfanswer.length = 0;
		
			if (QuestionTypeId != undefined) {
				let Answerid = 0;
				$(ansrow + " tbody tr").each(function() {
					Answerid++;
					let trid = $(this).attr("id");
					var option = $(this).find(".form-control").val();
				

			if (option) {
				if (trid != undefined) {

					//Answerid = trid;
					arrayOfanswer.push({ Answerid: Answerid, Ans: option, flag: "AnsEdit" });
				}
				else {

					arrayOfanswer.push({ Answerid: Answerid + 1, Ans: option, flag: "addAns" });
				}
					}
				});
			}

		for (i = 0; i < Ques.length; i++) {
			if (Ques[i].QuestionId === AnsID) {
				console.log(AnsID)
				Ques[i].QuestionId = AnsID;
				Ques[i].QuestionLable = QuestionLable;
				Ques[i].QuestionName = QuestionName;
				Ques[i].QuestionTypeId = QuestionTypeId;
				Ques[i].Description = Description;
				Ques[i].Required = Required;
				Ques[i].Validate = Validate;
				Ques[i].ValidateId = ValidateId;
				Ques[i].Answer = arrayOfanswer;
			}
		}
	};

	QuestionTable(Ques);
	clearLower();
	QuestionId++;
	AnsID = "";
})

function QuestionTable() {
	if (!$.fn.DataTable.isDataTable('#formquestion_datatable')) {
		$('#formquestion_datatable').DataTable
			({
				paging: true,
				"bLengthChange": false,
				"columnDefs": [{
					"targets": 4,
					"orderable": false
				}],

				"pageLength": 10,
				language:
				{
					paginate:
					{
						next: '<i class="fa fa-angle-double-right">',
						previous: '<i class="fa fa-angle-double-left">'
					}
				},
				dom:
					"<'row'<'col-xl-6 col-lg-6 col-sm-5'pi><'col-xl-5 col-lg-4 col-sm-5'f><'col-xl-1 col-lg-2 col-sm-2 colmspadding text-left'<'toolbar1'>>>" +
					"<'row'<'col-md-12'tr>>",
				fnInitComplete: function() {
					$('div.toolbar1').html('<a href="javascript:void(0)" data-toggle="modal" data-target=".formsorting" class="btn btn-warning btn-padding mb-1 mr-1"><i class="fa fa-sort"></i></a><a href="javascript:void(0)" data-toggle="modal" data-target=".addformquestion" class="btn btn-warning btn-padding mb-1"><i class="fa fa-plus"></i> Add</a>');
				},
			}
			);
	}

	$('#formquestion_datatable').DataTable().clear();
	$.each(Ques, function(index, value) {
		let QuestionTypeId = $('#quetype').find('option[value=' + value.QuestionTypeId + ']').text();
		let Required = value.Required == 1 ? "Yes" : "No";


		var row = '' +
			' <tr>' +
			'<td>' + value.QuestionId + '</td>' +
			'<td>' + value.QuestionName + '</td>' +
			'<td>' + QuestionTypeId + '</td>' +
			'<td>' + Required + '</td>' +
			'<td class="text-left">' +
			'<span data-toggle="modal" data-target=".addformquestion">' +
			'<a href="javascript:editbtn(' + value.QuestionId + ')" data-toggle="tooltip" data-placement="bottom" data-original-title="Edit" class="text-success fa-size">' +
			'<i class="fa fa-pencil"></i>' +
			'</a>' +
			'</span>' +
			'<span class="delete-user-alert">' +
			'<a href="javascript: delete_Row(' + value.QuestionId + ')" class="text-danger fa-size" data-toggle="tooltip" data-placement="bottom" data-original-title="Delete">' +
			' <i class="fa fa-trash"></i>' +
			'</a>' +
			'</span>' +
			'</td>' +
			'</tr>' +
			'';

		$('#formquestion_datatable').DataTable().row.add($(row));

	});

	$('#formquestion_datatable').DataTable().draw();

}







//QUESTION TYPE
$.ajax({

	method: "GET",
	url: "/QuestionType",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#quetype").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#quetype").selectpicker('refresh');
	}
});

//VALIDATE 
$.ajax({

	method: "GET",
	url: "/validateType",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#AnswerType").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#AnswerType").selectpicker('refresh');
	}
});

function clearLower() {

	EID = undefined;
	document.getElementById("questionlable").value = "";
	document.getElementById("questionname").value = "";
	document.getElementById("quetype").value = "";
	$('#quetype').selectpicker('refresh');
	document.getElementById("description1").value = "";
	$("#reqans").prop("checked", false);
	//document.getElementById("validatans").value = "";
	$("#validatans").prop("checked", false);
	document.getElementById("AnswerType").value = "";
	document.getElementsByName("singlechoice").value = "";
	//document.getElementById("single").value = "";
	//document.getElementById("single1").value = "";
	//lowerEditId = undefined;
	$('#myForm')[0].reset();
	$(".singlechoicetable tbody").empty();


}

$(document).on('click', '#addlower', function() {
	lowerEditId = undefined;

	clearLower();

});


//
function editbtn(EID) {
	debugger
	//lowerEditId = ;
	var Model;
	let quetype = "";

	for (var i = 0; i < Ques.length; i++) {
		if (Ques[i].QuestionId === EID) {

			AnsID = Ques[i].QuestionId;
			Model = Ques[i];
			console.log(AnsID)
		}
	}
	$("#questionlable").val(Model.QuestionLable);
	$("#questionname").val(Model.QuestionName);
	$("#quetype").val(Model.QuestionTypeId).change();
	$("#description1").val(Model.Description);
	$("#reqans").val(Model.Required);
	$("#validatans").val(Model.Validate);
	$("#AnswerType").val(Model.ValidateId);
	//$(".singlechoice").val(Model.opt);

	if (Model.Required == 1) {
		$("#reqans").prop("checked", true);
	}
	else {
		$("#reqans").prop("checked", false);
	}

	if (Model.QuestionTypeId == 1) {

	}

	else if (Model.QuestionTypeId == "2") {
		quetype = ".singlechoicetable" + " tbody";
		$(quetype).empty();
		$.each(Model.Answer, function(key, value) {
			var addNewRow = "<tr id='" + value.AnsID + "'><td class='text-center border-0' width='5%'><i class='fa fa-arrow-right' aria-hidden='true'></i></td><td class='border-0 p-1'><div class='form-group mb-0'><input type='text' class='form-control' placeholder='Enter an answer choice in English' value='" + value.Ans + "'></div></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='singlechoiceadd'><i class='fa fa-plus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='singlechoiceremove'><i class='fa fa-minus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td></tr>";
			$('table.singlechoicetable').append(addNewRow);
		});
	}
	else if (Model.QuestionTypeId == "3") {
		quetype = ".multichoicedata" + " tbody";
		$(quetype).empty();
		$.each(Model.Answer, function(key, value) {
			var addNewRow = "<tr id='" + value.AnsID + "'><td class='text-center border-0' width='5%'><i class='fa fa-arrow-right' aria-hidden='true'></i></td><td class='border-0 p-1'><div class='form-group mb-0'><input type='text' class='form-control' placeholder='Enter an answer choice in English' value='" + value.Ans + "'></div></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='multichoiceadd'><i class='fa fa-plus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='multichoiceremove'><i class='fa fa-minus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td></tr>";

			$('table.multichoicetable').append(addNewRow);
		});
	}

	else if (Model.QuestionTypeId == "6") {
		quetype = ".singleselecttable" + " tbody";
		$(quetype).empty();
		$.each(Model.Answer, function(key, value) {
			var addNewRow = "<tr  id='" + value.AnsID + "'><td class='text-center border-0' width='5%'><i class='fa fa-arrow-right' aria-hidden='true'></i></td><td class='border-0 p-1'><div class='form-group mb-0'><input type='text' class='form-control' placeholder='Enter an answer choice in English' value='" + value.Ans + "'></div></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='singleselectadd'><i class='fa fa-plus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='singleselectremove'><i class='fa fa-minus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td></tr>";
			$('table.singleselecttable').append(addNewRow);
		});
	}

	else if (Model.QuestionTypeId == "7") {
		quetype = ".multiselecttable" + " tbody";
		$(quetype).empty();
		$.each(Model.Answer, function(key, value) {
			var addNewRow = "<tr id='" + value.AnsID + "'><td class='text-center border-0' width='5%'><i class='fa fa-arrow-right' aria-hidden='true'></i></td><td class='border-0 p-1'><div class='form-group mb-0'><input type='text' class='form-control' placeholder='Enter an answer choice in English' value='" + value.Ans + "'></div></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='multiselectadd'><i class='fa fa-plus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td><td class='text-center border-0 p-0' width='3%'><a href='javascript:void(0)' class='multiselectremove'><i class='fa fa-minus-square-o font_20 m-t-5 text-default' aria-hidden='true'></i></a></td></tr>";
			$('table.multiselecttable').append(addNewRow);
		});
	}
}


//DELETE LOWERGRID
function delete_Row(QuestionId){
	console.log(QuestionId);
	
	for(let i=0;i<Ques.length;i++){
		if(Ques[i].QuestionId===QuestionId){
			 Ques.splice(i,1);
		}
		
	}
        QuestionTable(Ques);
            
       }


//preview 
var questId = [];
var req = [];
var quesIdMap = {
	QuestionId: "",
	QuestionTypeId: "",

};
var refresh = 0;
function PreviewQuestions(formid) {
	questId = [];

	$.ajax({
		type: "GET",
		url: "preview/" + formid,
		data: { 'formid': formid },


		success: function(data) {
			debugger
			$('#preview').html("");
			$('#fillformpreview').html("");
			$('#previewtitle').html(data.formtitle);
			$('#previewdesc').html(data.formtext);
			var a = 0

			$.each(data.ques, function(key, value) {
				req.push({ queid: value.QuestionId, Required: value.Required });
				a++
				let PreOpt = "";

				quesIdMap = { "formid": formid, QuestionId: value.QuestionId, QuestionTypeId: value.QuestionTypeId };
				questId.push(quesIdMap);

				if (value.QuestionTypeId == 2) {
					PreOpt = ""
					$.each(value.Answer, function(k, option) {
						AnswerRow = '<div class="col-xl-3 col-lg-3 col-sm-3 col-xs-12 colmspadding">' +
							'<div class="custom-control custom-radio">' +
							'<input type="radio" id="Two' + option.Answerid + '" value="' + option.Answerid + '" name="' + value.QuestionId + '"' +
							'class="custom-control-input"">' +
							'<label class="custom-control-label font-weight-300 m-t-5"' +
							'for="Two' + option.Answerid + '">' + option.Ans + '</label>' +
							'</div>' +
							'</div>';
						PreOpt += AnswerRow;
					});
				}

				else if (value.QuestionTypeId == 3) {
					PreOpt = ""

					$.each(value.Answer, function(k, option) {
						AnswerRow = ' <div class="col-xl-3 col-lg-3 col-sm-3 col-xs-12 colmspadding">' +
							'<div class="custom-control custom-checkbox">' +
							'<input type="checkbox" id="Three' + option.Answerid + '" value="' + option.Answerid + '" name="' + value.QuestionId + '"' +
							'class="custom-control-input"">' +
							'<label class="custom-control-label font-weight-300 m-t-5"' +
							'for="Three' + option.Answerid + '">' + option.Ans + '</label>' +
							'</div>' +
							'</div>';
						PreOpt += AnswerRow;
					});
				}

				else if (value.QuestionTypeId == 4) {
					PreOpt = "";
					PreOpt = '' +
						'<div class="col-xl-7 col-lg-12 col-sm-12 col-xs-12 colmspadding">' +
						'<input type="text" id="' + value.QuestionId + '" class="form-control" placeholder="Enter Your Answer">' +
						'</div>' +
						'';
				}

				else if (value.QuestionTypeId == 5) {
					PreOpt = "";
					PreOpt = '' +
						'<div class="col-xl-7 col-lg-12 col-sm-12 col-xs-12 colmspadding">' +
						'<textarea id="' + value.QuestionId + '" class="form-control textareasize"' +
						'placeholder="Enter Your Answer"></textarea>' +
						'</div>' +
						'';
				}

				else if (value.QuestionTypeId == 6) {
					PreOpt = ""
					var SelectedOption = "";
					refresh = 1;

					$.each(value.Answer, function(k, option) {
						val = ' <option value="' + option.Answerid + '">' + option.Ans + '</option>';
						SelectedOption += val;

					});

					var AnswerRow = '' +
						'<div class="col-xl-7 col-lg-12 col-sm-12 col-xs-12 colmspadding">' +
						'<select id="' + value.QuestionId + '" class="selectpicker" ' +
						'data-style="btn-light bg-transfer" data-actions-box="true">' +
						SelectedOption +
						'</select>' +
						'</div>' +
						'';
					PreOpt += AnswerRow;
				}

				else if (value.QuestionTypeId == 7) {
					PreOpt = ""
					var SelectedOption = "";
					refresh = 1;

					$.each(value.Answer, function(k, option) {
						valu = ' <option value="' + option.Answerid + '">' + option.Ans + '</option>';
						SelectedOption += valu;
					});

					var AnswerRow = '' +
						'<div class="col-xl-7 col-lg-12 col-sm-12 col-xs-12 colmspadding">' +
						'<select id="' + value.QuestionId + '" class="selectpicker" multiple data-selected-text-format="count"' +
						'data-style="btn-light bg-transfer" data-actions-box="true">' +
						SelectedOption +
						'</select>' +
						'</div>' +
						'';
					PreOpt += AnswerRow;

				}

				else if (value.QuestionTypeId == 8) {
					PreOpt = "";
					PreOpt = '' +
						'<div class="col-xl-3 col-lg-12 col-sm-12 col-xs-12 colmspadding">' +
						'<div class="input-group date">' +
						'<input id="' + value.QuestionId + '" type="text" class="form-control" placeholder="dd/mm/yyyy"' +
						'>' +
						'<span class="input-group-addon inputgroups">' +
						'<i class="mdi mdi-calendar"></i>' +
						'</span>' +
						'</div>' +
						'</div>' + '';


					var forDate =
						'<script>' +
						'$(\'#' + value.QuestionId + '\').closest(\'div\').datepicker({' +
						'autoclose: true,' +
						'todayHighlight: true,' +
						'format: "dd/mm/yyyy",' +
						'clearBtn: true' +
						'});' +
						'</script>';
					PreOpt += forDate;

				}


				var SingleChoice = '<div class="form-group mb-0">' +
					'<div class="row pl-2 pr-2">' +
					PreOpt +
					'</div>' +
					'</div>';

				var variable = '' +
					'<div class="card mb-2 queshadow">' +
					'<div class="card-body">' +
					'<div class="row pl-2 pr-2">' +
					'<div class="col-xl-1 col-lg-1 col-sm-2 col-xs-12 colmspadding">' +
					'<span class="question">Q : ' + a + '</span>' +
					'</div>' +
					'' +
					'<div class="col-xl-11 col-lg-11 col-sm-10 col-xs-12 colmspadding">' +
					'<div class="form-group mb-0 text-justify">' +
					'<p class="font-weight-700 mb-1 text-justify"><span class="text-danger">*</span>' +
					'' + value.QuestionLable + '</p>' +
					'<p class="mb-1">' +
					'</p>' +
					'</div>' +
					'' +
					SingleChoice +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div>' +
					'';

				$('#preview').append(variable);
			    $('#fillformpreview').append(variable);				

				if (refresh == 1) {
					$('#' + value.QuestionId).selectpicker('refresh');
				}
				refresh = 0;
			});
		},
	});
}
//*************************************************Fill Form*******************************************************************
//*************************************************Fill Form*******************************************************************
//*************************************************Fill Form*******************************************************************
//*************************************************Fill Form*******************************************************************
//*************************************************Fill Form*******************************************************************



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

$('#submitFillAnswer').click(function() {
debugger
console.log(questId)
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
								let Answerid = $('input[name=' + questId[i].QuestionId + ']:checked').val();
								fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, Answerid: Answerid, QuestionTypeId: questId[i].QuestionTypeId });
							}

							else if (questId[i].QuestionTypeId == 3) {
								let val = $('input[name=' + questId[i].QuestionId + ']:checked');
								val.each(function() {
									multiselectckbxval.push($(this).val());
									fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, Answerid: $(this).val(), QuestionTypeId: questId[i].QuestionTypeId });
								});
							}

							else {
								if (questId[i].QuestionTypeId == 7) {
									$.each($('#' + questId[i].QuestionId + '').val(), function(index, value) {
										fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, Answerid: value, QuestionTypeId: questId[i].QuestionTypeId });
									});
								}
								else {
									fillformans.push({ formid: parseInt(questId[i].formid), QuestionId: questId[i].QuestionId, Answerid: $('#' + questId[i].QuestionId + '').val(), QuestionTypeId: questId[i].QuestionTypeId });
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
	debugger
	$.ajax
		({
			type: "POST",
			url: "/SavefillForm",
			data: {'AnsData':JSON.stringify(fillformans) },
		   // contentType: "application/json",
		    //processData: false,  
			success: function(data) {
				
				getAllForm();
				req = [];
			},
		});
}


	                                                         
	                                                         
                                                             
                                                             
                                                             
                                                             
                                                             