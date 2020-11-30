<%@include file="/common/taglib.jsp"%>
<c:url var="customerListURL" value="/admin/customer-list" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="customerEdit" value="/admin/customer-edit" />
<c:url var="customerDelete" value = "/api/customer-del" />
<c:url var="loadStaff" value="/api/assign-customer"/>
<c:url var="assignCustomer" value="/api/assignment-customer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a></li>
						<li class="active">Khách hàng</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Khách hàng <small> <i
								class="ace-icon fa fa-angle-double-right"></i> danh sách khách hàng
						</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="">
							<div class="widget-box">
								<div class="widget-header">
									<h4 class="widget-title">Tìm kiếm</h4>

									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<form:form commandName="modelSearch" action="${customerListURL}"
									id="listForm" method="GET">
									<div class="widget-body">
										<div class="widget-main row">
											<div class="col-sm-6 col-xs-12">
												<label for="name">Tên khách hàng</label>
												<form:input path="fullName" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="phone">Số điện thoại</label>
												<form:input path="phone" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="email">Email</label>
												<form:input path="email" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="staffId">Chọn nhân viên phụ trách</label>
												<form:select path="staffId" id="staffId"
													style="display: block; width: 80%;">
													<form:option value="-1" label="---chọn nhân viên---" />
													<form:options items="${staffMap}" />
												</form:select>
											</div>
											<br/>
											<br/>
											<div class="col-sm-12 margin-top">
												<button type="button" class="btn btn-success" id="btnSearch">Tìm
													Kiếm</button>
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
						<div class="pull-right">
							<a href="${customerEdit}">
								<button class="btn-success" title="thêm khách hàng"
									id="btnAddCustomer">
									<i class="ace-icon fa fa-cloud-upload "></i>
								</button>
							</a>
							<button class="btn-danger" title="xóa khách hàng"
								id="btnDeleteCustomer">
								<i class="ace-icon fa fa-trash-o "></i>
							</button>
						</div>
						<br> <br>
						<div class=" margin-top ">
							<table class="table table-striped table-bordered table-hover"
								id="customerList">
								<thead>
									<tr>
										<th>checkbox</th>
										<th>Tên khách hàng</th>
										<th>Số điện thoại</th>
										<th class="hidden-480">Email</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${customers}">
										<tr>
											<td><input type="checkbox" value="${item.id}"
												id="checkbox_${item.id}"></td>
											<td>${item.fullName}</td>
											<td>${item.phone}</td>
											<td>${item.email}</td>
											<td>
												<button class="btn-danger" title="giao khách hàng"
													id="btnAssignmentCustomer" customerId = "${item.id}">
													<i class="ace-icon fa fa-pencil-square-o "></i>
												</button> 
												<c:url var="updateCustomerURL" value="/admin/customer-edit">
													<c:param name="id" value="${item.id}" />
												</c:url> <a class="btn btn-sm btn-primary btn-edit"
												data-toggle="tooltip" title="Cập nhật khách hàng"
												href='${updateCustomerURL}'><i
													class="fa fa-pencil-square-o" aria-hidden="true"></i> </a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- Modal -->
					<div class="modal fade" id="assignmentCustomer" role="dialog">
						<div class="modal-dialog modal-lg">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Giao khach hangf cho nhân viên</h4>
								</div>
								<div class="modal-body">
									<table class="table table-striped table-bordered table-hover"
										id="staffList">
										<thead>
											<tr>
												<th>Chọn nhân viên</th>
												<th>Tên nhân viên</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
									<div id="fieldHidden"></div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										id="btnAssignCustomer">Giao Tòa Nhà</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Đóng</button>
								</div>
							</div>
						</div>
					</div>
					<a href="#" id="btn-scroll-up"
						class="btn-scroll-up btn btn-sm btn-inverse"> <i
						class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnSearch').click(function(e) {
			e.preventDefault();
			$('#listForm').submit();
		});

		$(function() {
			$(document).on("click", "#customerList button#btnAssignmentCustomer", function (e) {
				openModelAssignmentCustomer();
				loadUserAssignForBuilding($(this).attr("customerId"));
			});
		});

		function loadUserAssignForBuilding(customerId) {
			var customerIdHidden = '<input type ="hidden" name ="customerId" value ='
					+ customerId + ' id = "customerId"/>';
			$('#fieldHidden').html(customerIdHidden);
			$.ajax({
						url : '${loadStaff}?role=STAFF&customerId='
								+ customerId,
						type : 'GET',
						dataType : 'json',
						success : function(result) {
							var row = '';
							$
									.each(
											result,
											function(index, staff) {
												row += '<tr>';
												row += '<td class = "text-center"> <input type="checkbox" name = "checkList" value = '+ staff.id+' id= "checkbox_'+staff.id+'" class = "check-box-element" '+staff.checked+ '/> </td>';
												row += '<td class = "text-center">'
														+ staff.fullName
														+ '</td>';
												row += '</tr>';
											});
							$('#staffList tBody').html(row);
						},
						error : function(res) {
							console.log(res);
						}
					});
		}

		function openModelAssignmentCustomer() {
			$('#assignmentCustomer').modal();
		}

		$('#btnAssignCustomer').click(
				function(e) {
					e.preventDefault();
					var data = {};
					data['customerId'] = $('#customerId').val();
					var staffs = $('#staffList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['staffIds'] = staffs;
					assignStaff(data);
				});

		function assignStaff(data) {
			$.ajax({
				type : "POST",
				url : "${assignCustomer}",
				data : JSON.stringify(data),
				contentType : "application/json",
				success : function(response) {
					window.location.href = "<c:url value='/admin/customer-list'/>";
					alert('add assign success');
				},
				error : function(response) {
					console.log('fail');
					console.log(response);
				}
			});
		};

		$('#btnDeleteCustomer').click(
				function(e) {
					e.preventDefault();
					var customerIds = $('#customerList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					deleteCustomer(customerIds);
				});

		function deleteCustomer(data) {
			$.ajax({
				type : 'delete',
				url : '${customerDelete}',
				data : JSON.stringify(data),
				contentType : "application/json",
				success : function(response) {
					window.location.href = "<c:url value='/admin/customer-list'/>";
					alert('delete success');
				},
				error : function(response) {
					console.log('fail');
					console.log(response);
				}
			});
		};
	</script>
</body>
</html>