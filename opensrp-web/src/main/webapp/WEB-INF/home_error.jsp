<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Error Handling</title>

<%--     <script type="text/javascript" src="<c:url value="/resources/src/js/jquery.min.js"/>"></script> 
--%>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	

<link href="<c:url value='/resources/css/jquery.dataTables.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet">
	<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script  src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script> -->






	<script type="text/javascript" language="javascript" class="init">


var statusOptions;
var table;
function viewError(id) {
	$.get( "/errorhandler/viewerror?id="+id, function( data , status) {
		
		$("#errorType").val(data.errorTrace.errorType);  
		$("#documentType").val(data.errorTrace.documentType);  
		$("#dateOccurred").val(data.errorTrace.dateOccurred); 
		$("#stackTrace").val(data.errorTrace.stackTrace);
		$("#retryURL").val(data.errorTrace.retryURL);  
		//$( ".result" ).html( data );
	$('#myModal').modal('show')
	console.log(data);
		//alert( data.errorTrace.errorType );
		});
	
	
	//alert("this "+id);
//	  dialog.dialog( "open" );
	//return false;
	//window.open("/errorhandler/viewerror?id=" + id, 'window','width=400,height=100');

};


	$(document).ready(function() {
		//$.fn.dataTable.moment( 'HH:mm MMM D, YY' );
		
		
			$.get( "/errorhandler/getstatusoptions", function( data , status) {
				setInterval(5000);	
				statusOptions=data;
					
				//	console.log(statusOptions);
					});
			
		table =$('#example').DataTable({
			"ajax" : {
				"url" : "/errorhandler/errortrace",
				"dataSrc" : ""
			},
			"columns" : [ {
				"data" : "errorType"
			}, {
				"data" : "documentType"
			}, {
				"data" : "recordId"
			}, {
				"data" : "dateOccurred",
				 "type": "date"
				
			}, {
				"data" : "status"
			},
			{
				"data": "_id"
				
			}
			
			],
			"aoColumnDefs": [{
			      "mRender":function ( data, type, full ) {
			    	  var d = new Date(data);
			    	    var curr_date = d.getDate();
			    	    var curr_month = d.getMonth() + 1; //Months are zero based
			    	    var curr_year = d.getFullYear();
			    	    //console.log(curr_date + "-" + curr_month + "-" + curr_year);
			    	  
			    	  return curr_date + "-" + curr_month + "-" + curr_year;
			      },
        			"aTargets": [ 3]
			      
			},{
				"mRender": function ( data, type, full ) {
		    //   return '<a data-toggle="modal" class="btn btn-info" href="/errorhandler/viewerror?id='+data+'" data-target="#myModal">Click me !</a>';
					return "<button onclick='viewError(&quot;"+data+"&quot;) ;' >View StackTrace</button> <a  >Update</a> ";
		      },
    				"aTargets": [ 5]
		},
		{
			
			"mRender": function ( data, type, full ) {
	   				
				var options="<select id='status'>";
				for(i=0;i<statusOptions.length;i++){
					if(data==statusOptions[i]){
						options+="<option value='"+statusOptions[i]+"' selected>"+statusOptions[i]+"</options>";
					}else{
					options+="<option value='"+statusOptions[i]+"'>"+statusOptions[i]+"</options>";
					}
				}
				
				options+="</select>";
				//   return '<a data-toggle="modal" class="btn btn-info" href="/errorhandler/viewerror?id='+data+'" data-target="#myModal">Click me !</a>';
				//console.log(options);
				return options;
	      },
				"aTargets": [4]
	}
	
		]

			
		});
		
		
		 $('#example tbody').on( 'click', 'a', function () {
		        var data = table.row( $(this).parents('tr') ).data();
		        console.log(data);
		      //  var st=table.row( $(this).parents('tr').find('#status') ).val(); //.data();
		        var selectedStatus=$(this).parents('tr').find('#status :selected');//.data(); 
		        console.log(selectedStatus.text());
		        $.get( "/errorhandler/update_status?id="+data['_id']+"&status="+selectedStatus.text(), function( data , status) {
					
		        	
		        		
					console.log(selectedStatus);
					setInterval(5000);
					//location.reload();
					//statusOptions=data;
						
					//	console.log(statusOptions);
						});
		        
		        //console.log("s : "+ s.text());
		       // console.log("st : "+st);
		        //console.log(data);
		        
		        
		        //alert( data[1]);
		    } );
		
		
	});
	
	 
	
</script>

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<img alt="OPENSRP" src="/resources/opensrp-logo.png">
			</div>
			<div class="col-md-8">
				<h3 class="text-center text-success">Error Handling -- OpenSRP
				</h3>
			</div>
			<div class="col-md-2"></div>
		</div>
		<div class="row">
		
		
	
			<div class="col-md-3">
				<ul class="nav nav-stacked nav-tabs">
					<li class="active"><a href="/errorhandler/errortrace">All
							Errors</a></li>
					<li><a href="/errorhandler/solvederrors">Solved Errors</a></li>
					<li><a href="/errorhandler/unsolvederrors">Unsolved Errors</a></li>
					<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">Options<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#">Logout</a></li>

						</ul></li>
				</ul>
			</div>
			<div class="col-md-9">

				<table id="example" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Error Type</th>
							<th>Document Type</th>
							<th>Record Id</th>
							<th>Date Occurred</th>

							<th>Status</th>
							<th>Actions</th>
							
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Error Type</th>
							<th>Document Type</th>
							<th>Record Id</th>
							<th>Date Occurred</th>
							<th>Status</th>
							<th>Actions</th>
							
						</tr>
					</tfoot>
				</table>
				<!--End of the Table  -->
				
				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Error Log</h4>
							</div>
							<div class="modal-body">
							<table style="width:80%"  class="table" >
									<tr>

										<th>Error Type:</th>
										<td><input type="text" id="errorType" readonly />

										</td>
									</tr>
									<tr>
										<th>Document Type:</th>
										<td><input type="text" id="documentType" readonly />

										</td>
									</tr>

									<tr>
										<th>Date Occurred:</th>
										<td><input type="Date" id="dateOccurred" readonly />

										</td>
									</tr>
									<tr>
										<th>StackTrace:</th>
										<td><textarea  id="stackTrace" rows="20" cols="40" readonly ></textarea>

										</td>
									</tr>
									<tr>
										<th>URL:</th>
										<td><input type="text" id="retryURL" readonly />

										</td>
									</tr>
									

								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>	<!-- End of Modal content-->

						<!-- 
			Creating Table for all errors 
				<c:if test="${type=='all'}">


					<c:choose>
						<c:when test="${empty errors}">
							<div class="alert alert-warning">
								<strong>Warning!</strong> No Record Found in Database !
							</div>
						</c:when>
						<c:otherwise>
							<table class="table" id="table">
								<thead>
									<tr>

										<th>Error Type</th>
										<th>Document Type</th>
										<th>Record Id</th>
										<th>Date Occurred</th>

										<th>Status</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="i" items="${errors}">
										<tr>


											<td>${i.errorType}</td>
											<td>${i.documentType}</td>
											<td>${i.recordId}</td>
											<td><fmt:formatDate pattern="dd-MM-yyyy"
													value="${i.dateOccurred}" /></td>
											<td>${i.status}</td>
											<td><a class="btn btn-primary btn-md" role="button"
												href="/errorhandler/viewerror?id=${i.getId()}">View</a>
											<button class="btn btn-primary btn-md" role="button" onclick="viewError('${i.getId()}');">View Data</button>
												</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</c:if>
				 Creating Table for solved errors
				<c:if test="${type == 'solved' }">
					<c:choose>
						<c:when test="${empty errors}">
							<div class="alert alert-warning">
								<strong>Warning!</strong> No Record Found under All !
							</div>
						</c:when>
						<c:otherwise>

							<table class="table">
								<thead>
									<tr>

										<th>Error Type</th>
										<th>Document Type</th>
										<th>Record ID</th>
										<th>Date</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="i" items="${errors}">
										<tr>


											<td>${i.errorType}</td>
											<td>${i.documentType}</td>
											<td>${i.recordId}</td>
											<td><fmt:formatDate pattern="dd-MM-yyyy"
													value="${i.dateOccurred}" /></td>
											<td>${i.status}</td>
											<td><a class="btn btn-primary btn-md" role="button"
												href="/errorhandler/viewerror?id=${i.getId()}">View</a></td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</c:if>

				Creating Table for unsolved errors  
				<c:if test="${type == 'unsolved' }">
					<c:if test="${empty  errors }">
						<div class="alert alert-warning">
							<strong>Warning!</strong> No Record Found under DB !
						</div>
					</c:if>


					<table class="table">
						<thead>
							<tr>

								<th>Error Type</th>
								<th>Document Type</th>
								<th>Record ID</th>
								<th>Date</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${errors}">
								<tr>


									<td>${i.errorType}</td>
									<td>${i.documentType}</td>

									<td>${i.recordId}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${i.dateOccurred}" /></td>
									<td>${i.status}</td>
									<td><a class="btn btn-primary btn-md" role="button"
										href="/errorhandler/viewerror?id=${i.getId()}">View</a></td>

								</tr>
							</c:forEach>

						</tbody>
					</table>


				</c:if>-->

					</div>
				</div>
				<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-8"></div>
		</div>
	</div>

<%-- 	<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/js/scripts.js'/>"></script> --%>
</body>
</html>
