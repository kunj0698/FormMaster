
CompleteFormTable();





function CompleteFormTable() 
{
	$.ajax({
		type: "POST",
		url: "/CompleteFormTable",

		success: function(data) 
		
		{
			console.log(data)
			$('#form_datatable').DataTable().clear();

			$.each(data, function(key, value) 
			{
				 var date = new Date();   
                 const localDateTime = new Date(date);
                 const options = { year: 'numeric', month: 'long', day: 'numeric' };
                 const customDate = localDateTime.toLocaleDateString('en-US', options);


				var vari = ''
					      + '<tr>' +
					        '<td>' + customDate + '</td>' +
					        '<td>F0RM-' + value[0] + '</td>' +
					        '<td>' + value[1] + '</td>' +
					        '<td>' + value[2] + ' ' + value[3] + '</td>' +
					        '<td class="text-center">' +
					        '<span data-toggle="modal" data-target="#all_question_preview">' +
					        '<a href="javascript:CompleteFormPreview(' + value[0] + ',' + value[4] +' )" data-toggle="tooltip"  data-placement="bottom" title="" data-original-title="Preview" class="text-info fa-size"> ' +
					        '<i class="fa fa-eye"></i></a></span>' +
					        '</td>' +
					        '</tr>' +
					        '';

				$('#form_datatable').DataTable().row.add($(vari));
			});

			$('#form_datatable').DataTable().draw();
		},
	});
};


//PREVIEW
function CompleteFormPreview(formid,userMasterId) 

{
	debugger
	$.ajax({
		type: "GET",
		url: "/CompletePreview",
		data: { "formid": formid,"userMasterId":userMasterId},

		success: function(data) 
	
		{
				console.log(data)
			$('#completeformdate').html('')
			$('#completeformtitle').html(data.formtitle);
			$('#completedesc').html(data.formtext);
			$('#completeformview').html('')

			let questionid = 0;

			$.each(data.ques, function(key, value) 
			{
				questionid++;
			    var variable = '' +
					           '<div class="card mb-2 queshadow">' +
					           '<div class="card-body">' +
					           '<div class="row pl-2 pr-2">' +
					           '<div class="col-xl-1 col-lg-1 col-sm-2 colmspadding">' +
					           '<span class="question">Q : '+ questionid + '</span>' +
					           '</div>' +
					           '' +
					           '<div class="col-xl-11 col-lg-11 col-sm-10 colmspadding">' +
					           '<div class="form-group mb-0 text-justify">' +
					           '<p class="font-weight-700 mb-1 text-justify"><span class="text-danger">*</span>' + value.QuestionLabel +'</p>' +
					           '<p class="mb-1">' + value.QuestioNname + '</p>' +
					           '</div>' +
					           '' +
					           '<div class="form-group mb-0">' +
					           '<div class="row pl-2 pr-2">' +
					           '<div class="col-xl-12 col-lg-12 col-sm-12 colmspadding">' +
					           '<p class="font-weight-700 mb-1 text-justify">Answer</p>' +
					           '<p class="mb-1 text-justify">' + value.Answer + '</p>' +
					           '</div>' +
					           '</div>' +
					           '</div>' +
					           '</div>' +
					           '</div>' +
					           '</div>' +
					           '</div>' +
					           '';
				$('#completeformview').append(variable);
			});
		},
	});
}
