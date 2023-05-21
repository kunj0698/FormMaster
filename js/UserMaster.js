
let editid = undefined;
$(document).ready(function() {
	//  $("#fileUploadForm").on("change", image);
	loadTable();
	clear();

});

$('#validfrom').closest('div').datepicker({
	autoclose: true,
	todayHighlight: true,
	format: "dd/mm/yyyy",
	clearBtn: true
});

$('#validto').closest('div').datepicker({
	autoclose: true,
	todayHighlight: true,
	format: "dd/mm/yyyy",
	clearBtn: true
});


function hasBlankSpaces(FirstName) {
	return FirstName === "" || FirstName.match(/^\s+$/) !== null;
}
function hasBlankSpace(LastName) {
	return LastName === "" || LastName.match(/^\s+$/) !== null;
}

function validateEmail(Email) {
 
  return Email.match(/^[^\s@]+@[^\s@]+\.[^\s@]+$/);
}

	function validatePhoneNumber(ContactNo) {
  const regex = /^[6-9]\d{9}$/;
  return regex.test(ContactNo);
}

var userMasterId= userMasterId
;
$('#saveUser').click(function() {
	debugger
	var FirstName = $("#firstname").val();
	if (hasBlankSpace(FirstName)) {
		alert("PLEASE ENTER FIRST NAME");
		return false;
	}
	
	
	var LastName = $("#lastname").val();
	if (hasBlankSpace(LastName)) {
		alert("PLEASE ENTER LAST NAME");
		return false;
	}
	
		

// example usage
var Email = $("#email").val();
if (validateEmail(Email)) {
alert("PLEASE ENTER VALID EMAIL");
		return false;
}

	
	
	
	var ContactNo = $("#contact").val();
	





if (validatePhoneNumber(ContactNo)) {
 console.log("Valid phone number");
 
} else {
alert("Invalid phone number");
return false;
}

	
	var Gender = $("#gender").val();
	if (Gender == "") {
		alert("PLEASE SELECT GENDER");
		return false;
	}
	
	
	/*var ValidFrom = $("#validfrom").val();
	var ValidTo = $("#validto").val();*/
	
	
	var ValidFrom = $("#validfrom").val();
	if (ValidFrom == "") {
		alert("PLEASE ENTER  DATE")
		return false;
	}
	var ValidTo = $("#validto").val();
	if (ValidTo == "") {
		alert("PLEASE ENTER  DATE")
		return false;
	}
	let DateF = ValidFrom.split("/");
	console.log(DateF[0])
	let DayF = DateF[0];
	let MonthF = DateF[1];
	let YearF = DateF[2];

	let DateT = ValidTo.split("/");
	let DayT = DateT[0];
	let MonthT = DateT[1];
	let YearT = DateT[2];
	if (YearT <= YearF && MonthT < MonthF   ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
 else if( YearT <= YearF && MonthT == MonthF && DayT <= DayF ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	 else if( YearT < YearF && MonthT == MonthF && DayT >= DayF ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	else if( YearT < YearF  && MonthT > MonthF ) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	else if( YearT == YearF  &&  MonthT == MonthF && DayT <= DayF) {
		alert("PLEASE ENTER VALID DATE");
		return false;
	}
	
	

	var Role = $("#role").val();
	if (Role == "") {
		alert("PLEASE SELECT ROLE");
		return false;
	}
	
	
	var Active = $("#active").val();
	//var Image = $("#upload").val();        




	var formData = {};
	formData.FirstName = FirstName;
	formData.LastName = LastName;
	formData.Email = Email;
	formData.ContactNo = ContactNo;
	formData.Gender = Gender;
	formData.ValidFrom = ValidFrom;
	formData.ValidTo = ValidTo;
	formData.Role = Role;
	formData.Active = Active;
	//formData.Image=Image;
	console.log(formData)
	
			if (editid) {
		console.log(editid)
		formData.userMasterId =editid;
	} else {
		Active = true
	}
	if (Active == true) {
		formData.Active = 1;
	} else {
		formData.Active = 0;
	}


	var Data = new FormData();
	Data.append("imageUpload", $('input[type=file]')[0].files[0]);
	Data.append("UserMstDto", new Blob([JSON.stringify(formData)], { type: "application/JSON;charset=UTF-8" }));

	if (Active == true) {
		formData.Active = 1;
	} else {
		formData.Active = 0;
	}
		
	
	$.ajax({
		method: "POST",
		url: "/AddUser",
		enctype: "multipart/form-data",
		dataType: 'JSON',
		contentType: false,
		processData: false,
		data: Data,

		success: function(Data) {
			if (Data == "DATA EXIST") {
				alert(Data)
			}
			else {
				alert("DATA SAVED")
				$("#close").click();
			}
			loadTable();

		},


	});

});


//role
$.ajax({

	method: "GET",
	url: "/role",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#role").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#role").selectpicker('refresh');
	}
});


//GENDER
$.ajax({

	method: "GET",
	url: "/gender",
	//dataType:'JSON',

	success: function(formData) {

		for (var index = 0; index < formData.length; index++) {

			$("#gender").append('<option value="' + formData[index][0] + '">' + formData[index][1] + ' </option>');
		}

		$("#gender").selectpicker('refresh');
	}
});


//GRID
function loadTable() {
	$.ajax({
		url: "/load",
		type: 'GET',
		success: function(data) {
			console.log(data);
			$('#users_datatable').DataTable({
				destroy: true,
				scrollX: true,
				"bAutoWidth": true,
				paging: true,
				"bLengthChange": false,
				"data": data,
				"columns": [
					//{data:'0'},
					{
						data: '6',
						render: function(image, name, data) {
							return `<h2 class="table-avatar">
                    <a href="javascript:void(0)" data-toggle="popover" data-trigger="hover" data-html="true" data-placement="right"
                    data-template="<div class=&quot;popover fade bs-popover-right&quot; role=&quot;tooltip&quot; x-placement=&quot;right&quot;>
                    <div class=&quot;arrow&quot;></div><h3 class=&quot;popover-header p-0 border_radius6&quot;></h3></div>"
                    data-title="<img src= pictures/`+ image +` width='150' height='150' class='border_radius6'>" data-original-title="" title="">
                    <img src= pictures/`+ image +` alt="" class="img-radius avatar">
                    </a>
                    <span>${data[4] + " " + data[7]}</span>
                    </h2>`;
						}
					},
					{ data: '3' },
					{ data: '2' },
					{ data: '9' },
					{ data: '10' },
					{
						data: '5',
						render: function(data) {
							if (data == 1) {
								return "Male";
							} else if (data == 2) {
								return "Female";
							}
						}
					},
					{
						data: '8',
						render: function(data) {
							if (data == 1) {
								return "Admin";
							} else if (data == 2) {
								return "User";
							}
						}
					},
					{
						data: '1',
						render: function(data) {
							if (data == 1) {
								return "Yes";
							} else { return "No"; }
						}
					},
					{
						data: '10',
						render: function(data, type, meta) {
							return `<a href="javascript:void(0)" data-toggle="tooltip" data-placement="bottom" id="editBtn" onclick=editData(${meta[0]}) data-original-title="Edit" class="text-success fa-size client_add_btn"><i class="fa fa-pencil"></i></a>
                                                    <span class="delete-user-alert"><a href="javascript:void(0)" class="text-danger fa-size" data-toggle="tooltip" data-placement="bottom" id="deleteBtn" onclick="DelUser(${meta[0]})" data-original-title="Delete"><i class="fa fa-trash"></i></a></span>
              `;
						}

					},
				],
				"columnDefs": [{
					"targets": [0],
					"orderable": false
				}],
				"pageLength": 10,
				fixedColumns: {
					rightColumns: 1,
					leftColumns: 0
				},
				language: {
					paginate: {
						next: '<i class="fa fa-angle-double-right">',
						previous: '<i class="fa fa-angle-double-left">'
					}
				},
				"dom": '<"top"pif>rt<"clear">'
			});
		}
	})
}


//EDIT

function editData(userMasterId) {
	debugger

	console.log(userMasterId)
	editid = userMasterId
	console.log(editid)

	$.ajax({
		type: "GET",
		url: "edituser/" + userMasterId,

		success: function(formData) {
			console.log(formData)
/*
			$(".activediv").show();

			$('#catName2').val(formData.categoryName),
				editisubcat = formData.subCategoryName;
			console.log(editisubcat)
			*/

			    $("#firstname").val(formData.firstName),
				$("#lastname").val(formData.lastName),
				$("#email").val(formData.email),
				$("#contact").val(formData.contactNo),
				$("#gender").val(formData.gender),
				//$("#image").val(formData.image),
				$('input[type=file]'),
				$("#validfrom").val(formData.validFrom),
				$("#validto").val(formData.validTo),
				$("#role").val(formData.role),

				$('#role').trigger("change").selectpicker('refresh');
				$('#gender').selectpicker('refresh');

			

		},

		error: function(err) {
			alert("error is" + err)
		}
	});

}

//Clear
function clear() {
	//$(".activediv").hide();
	document.getElementById("firstname").value = "";
	document.getElementById("contact").value = "";
	document.getElementById("lastname").value = "";
	document.getElementById("email").value = "";
	document.getElementById("gender").value = "";
	$('#gender').selectpicker('refresh');
	document.getElementById("validfrom").value = "";
	document.getElementById("validto").value = "";
	document.getElementById("role").value = "";
	$('#role').selectpicker('refresh');

}

$(document).on('click', '#add', function() {
	editid = undefined;
	clear();
});
$(document).on('click', '#back', function() {
	editid = undefined;
	clear();
});
$(document).on('click', '#cancle', function() {
	editid = undefined;
	clear();
});

//DELETE
function DelUser(userMasterId) {
	console.log(userMasterId)

	if (confirm("ARE YOU SURE YOU WANT TO DELETE?")) {
		$.ajax({

			method: 'DELETE',
			url: "DelUser/" + userMasterId,

			success: function(response) {

				loadTable();

			},
			error: function(err) {
				alert(err)
			}
		});
	}
}