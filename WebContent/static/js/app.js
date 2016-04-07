
$("#createTodo").click(function(){
	var input_id = $("#todoId").val();
	var input_message = $("#todoMessage").val();
	var data = {
			id:input_id,
			message:input_message
			};
	$.ajax({
		url:"/LAB4/create",
		method:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType: "json",
		success: function(data,status,xhr){
			if(data.code == "Success"){
				alert("Success!");
			}else{
				alert("Error! Message is " + data.message);
			}
		},
		error: function(data,status,xhr){
			alert(JSON.stringify(data));
		},
		data: data
	});
});

$("#getJSON").click(
			function() {
				var input_id = $("#todoId_get").val();
				$.ajax({
					type : 'GET',
					url : "/LAB4/json/" + input_id,
					dataType: "json",
					success : function(response) {
						alert("Success!");
					},
					error : function(response) {
						alert("Error!");
					},
				
				});
			});	

$("#getXML").click(
		function() {
			var id = $("#todoId_get").val();
			$.ajax({
				type : 'GET',
				url : "/LAB4/xml/" + "?id=" + id,
				success : function(response) {
					$("#responseHeader").html(response);
				},
				error : function(response) {
					$("#responseHeader").html(response);
				}
			});
		});
		
$("#getAllJSON").click(
		function() {		
			$.ajax({
				type : 'GET',
				url : "/LAB4/all/json",
				success : function(response) {
					$("#responseHeader").html(response);
				},
				error : function(response) {
					$("#responseHeader").html(response);
				}
			});
		});		
$("#getAllXML").click(
		function() {		
			$.ajax({
				type : 'GET',
				url : "/LAB4/all/xml",
				success : function(response) {
					$("#responseHeader").html(response);
				},
				error : function(response) {
					$("#responseHeader").html(response);
				}
			});
		});		
$("#deleteTodo").click(
	function() {
		var id = $("#todoId_delete").val();
		$.ajax({
		url : "/Lab4/delete" + "?id=" + id3,
		method : "POST",
		contentType : 'application/octet-stream; charset=utf-8',
		success : function(response) {
			$("#responseHeader").html(response);
		},
		error : function(response) {
			$("#responseHeader").html(response);
		},
	});
});
/*
$("#createTodo").click(
		function() {
			var id = $("#todoId").val();
			var message = $("#todoMessage").val();
			$.ajax({
				url : "/LAB4/create" + "?id="+ id + "&message=" + message,
				method : "POST",
				contentType : "application/octet-stream; charset=utf-8",
				success : function(response) {
					$("#responseHeader").html(response);
				},
				error : function(response) {
					$("#responseHeader").html(response);
				},
			});	
*/