<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
	<head>
		<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
		<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
		<link href="/css/style.css" rel="stylesheet" />
		<link href="/css/plugins/fontawesome/css/fontawesome.css" rel="stylesheet" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid" style="width:100% !important;">
				<div class="navbar-header">
					<a class="navbar-brand" href="/">User Enrollment</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
				</ul>
			</div>
		</nav>
		<div class="wrapper wrapper-content">
			<div class="row">
				<div class="col-lg-12 ibox-content" id="ibox-content">
					<div class="col-lg-12 pull-left"><h3 class="title">Rest Call Test Page</h3></div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 ibox-content" id="ibox-content">
					<form name="restTestform" id="restTestform">
						<div class="form-group">
						<div class="col-lg-8">
						 	<label for="restCall">Rest Call:</label>
						  	<select class="form-control col-lg-8" id="restCall" name="restCall">
						    	<option value="user/getAllUser" select >Get All User</option>
						    	<option value="user/addUser" >Add User</option>
						    	<option value="user/updateUser" >Update User</option>
						    	<option value="user/deleteUser" >Delete User</option>
						  	</select>
						</div>
						<div class="col-lg-2">
							<label for="restInputField">User Id</label>
						  	<input type="text" class="form-control col-lg-2" id="restInputField" name="restInputField" disabled>
						</div>
						<div class="col-lg-2">
							<label for="tryButton">&nbsp;</label>
						  	<button type="button" class="form-control btn btn-success" id="tryButton" name="tryButton">Execute</button>
						</div>
						<div class="col-lg-12">
							<div class="form-group">
							  <label for="comment">Request & Response:</label>
							  <textarea class="form-control" rows="13" id="req_res" name="req_res"></textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>		
		<nav class="navbar navbar-inverse">
			<div class="container" style="width:100%!important;">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">@2018 School Dashboard</a>
				</div>
			</div>
		</nav>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#restInputField').css("border", "2px solid black");
				
				$("#restCall").on("change", function(){
					var selectedVal = $("#restCall option:selected").val();
					if(selectedVal === 'user/addUser'){
						testRestCall('user/getUserSkeleton', '');
						$("#restInputField").prop('disabled', true);
						$('#restInputField').css("border", "2px solid black");
					} else if(selectedVal === 'user/updateUser'){
						$("#restInputField").prop('disabled', false);
						$('#restInputField').css("border", "2px solid red");
					} else if(selectedVal === 'user/deleteUser'){
						$("#restInputField").prop('disabled', false);
						$('#restInputField').css("border", "2px solid red");
					} else {
						$("#restInputField").prop('disabled', true);
						$('#restInputField').css("border", "2px solid black");
					}	
    			});
				
				$( "#tryButton" ).click(function() {
					var selectedVal = $("#restCall option:selected").val();
					var restInputField = $("#restInputField").val();
					var reqResField = $("#req_res").val();
					if((selectedVal === 'user/updateUser' || selectedVal === 'user/deleteUser') && restInputField == ''){
						 alert('Please provide User Id');
						 $("#restInputField").focus();
						 return false;
					}
					if(restInputField != '') {
						restInputField = '?userId=' + restInputField;
					}
					testRestCallForJSONRequest(selectedVal, restInputField, reqResField);
				});
				
				$( "#restInputField" ).blur(function() {
					var selectedVal = $("#restCall option:selected").val();
					var restInputField = $("#restInputField").val();
					if((selectedVal === 'user/updateUser' || selectedVal === 'user/deleteUser') && restInputField == ''){
						 alert('Please provide User Id');
						 $("#restInputField").focus();
						 return false;
					} else {
						restInputField =  '?userId=' + restInputField;
					}
				  	testRestCall('user/getUser', restInputField);
				});
			});
		
			function testRestCallForJSONRequest(selectedVal, parameter, reqResField) {
				$.ajax({
				    type: "POST",
				    dataType: "json",
				    url: selectedVal + parameter,
				    data: reqResField,
				    contentType:'application/json; charset=utf-8',
				    complete: function(data) {
				        $('#req_res').text(data.responseText);
				    }
				});
			}
			
			function testRestCall(selectedVal, parameter) {
				$.ajax({
					type: "POST",
				    dataType: "json",
				    url: selectedVal + parameter,
				    complete: function(data) {
				        $('#req_res').text(data.responseText);
				    }
				});
			}
		</script>
	</body>
</html>
	