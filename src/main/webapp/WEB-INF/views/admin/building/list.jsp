<%@include file="/common/taglib.jsp"%>
<c:url var="buildingListURL" value="/admin/building-list" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="newAPI" value="/api/new" />
<c:url var="newURL" value="/admin/new-list" />
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
						<li class="active">Tòa nhà</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Tòa nhà <small> <i
								class="ace-icon fa fa-angle-double-right"></i> danh sách tòa nhà
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
								<form:form commandName="modelSearch" action="${buildingListURL}"
									id="listForm" method="GET">
									<div class="widget-body">
										<div class="widget-main row">
											<div class="col-sm-6 col-xs-12">
												<label for="name">Tên tòa nhà</label>
												<form:input path="name" cssClass="form-control" />
											</div>
											<div class="col-sm-6 col-xs-12">
												<label for="floorArea">Diện tích sàn</label> <input
													type="number" class="form-control" id="buildingArea"
													name="floorArea" value="${modelSearch.floorArea}" />
											</div>
											<br>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="district">Quận hiện có</label>
												<form:select path="district" id="district"
													style="display: block; width: 80%;">
													<form:option value="" label="---chọn quận---" />
													<form:options items="${districts}" />
												</form:select>
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="ward">Phường</label>
												<form:input path="ward" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="street">Đường</label>
												<form:input path="street" cssClass="form-control" />
											</div>
											<br>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="numberOfBasement">Số tầng hầm</label> <input
													type="number" class="form-control" id=""
													value='${modelSearch.numberOfBasement}'
													name="numberOfBasement" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="direction">Hướng</label>
												<form:input path="direction" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="level">Hạng</label>
												<form:input path="level" cssClass="form-control" />
											</div>
											<br>
											<div class="col-sm-3 col-xs- margin-top">
												<label for="rentAreaFrom">Diện tích từ</label> <input
													type="number" class="form-control" id="rentAreaFrom"
													value="${modelSearch.rentAreaFrom}" name="rentAreaFrom" />
											</div>
											<div class="col-sm-3 col-xs-6 margin-top">
												<label for="rentAreaTo">Diện tích đến</label> <input
													type="number" class="form-control" id="rentAreaTo"
													value="${modelSearch.rentAreaTo}" name="rentAreaTo" />
											</div>
											<div class="col-sm-3 col-xs-6 margin-top">
												<label for="rentPriceFrom">Giá thuê từ</label> <input
													type="number" class="form-control" id="rentPriceFrom"
													value="${modelSearch.rentPriceFrom}" name="rentPriceFrom" />
											</div>
											<div class="col-sm-3 col-xs-6 margin-top">
												<label for="rentPriceTo">Giá thuê đến</label> <input
													type="number" class="form-control" id="rentPriceTo"
													value="${modelSearch.rentPriceTo}" name="rentPriceTo" />
											</div>
											<br />
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="managerName">Tên quản lý</label>
												<form:input path="managerName" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="managerPhone">Điện thoại quản lý</label>
												<form:input path="managerPhone" cssClass="form-control" />
											</div>
											<div class="col-sm-4 col-xs-6 margin-top">
												<label for="staffId">Chọn nhân viên phụ trách</label>
												<form:select path="staffId" id="staffId"
													style="display: block; width: 80%;">
													<form:option value="-1" label="---chọn nhân viên---" />
													<form:options items="${staffMap}" />
												</form:select>
											</div>
											<br />
											<div class="col-xs-6 margin-top">
												<form:checkboxes items="${buildingTypes}" path="types" />
											</div>
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
							<a href="http://localhost:8080/spring-boot/admin/building-edit">
								<button class="btn-success" title="thêm tòa nhà"
									id="btnAddBuilding">
									<i class="ace-icon fa fa-cloud-upload "></i>
								</button>
							</a>
							<button class="btn-danger" title="xóa tòa nhà"
								id="btnDeleteBuilding">
								<i class="ace-icon fa fa-trash-o "></i>
							</button>
						</div>
						<br> <br>
						<div class=" margin-top ">
							<table class="table table-striped table-bordered table-hover"
								id="buildingList">
								<thead>
									<tr>
										<th>checkbox</th>
										<th>Tên sản phẩm</th>
										<th>Địa chỉ</th>
										<th class="hidden-480">Tên quản lý</th>
										<th>Số điện thoại</th>
										<th class="hidden-480">Diện tích sàn</th>
										<th>Giá thuê</th>
										<th>Phí dich vụ</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${buildings}">
										<tr>
											<td><input type="checkbox" value="${item.id}"
												id="checkbox_${item.id}"></td>
											<td>${item.name}</td>
											<td>${item.address}</td>
											<td>${item.managerName}</td>
											<td>${item.managerPhone}</td>
											<td>${item.floorArea}</td>
											<td>${item.rentPrice}</td>
											<td>${item.serviceFee}</td>
											<td>
												<button class="btn-danger" title="giao tòa nhà"
													onclick="assignmentBuildingModal()">
													<i class="ace-icon fa fa-pencil-square-o "></i>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- Modal -->
					<div class="modal fade" id="assignmentbuilding" role="dialog">
						<div class="modal-dialog modal-lg">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Giao tòa nhà cho nhân viên</h4>
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
											<tr>
												<td><label class="checkbox-inline "> <input
														type="checkbox" value="2" class="no-margin-top"
														id="checkbox_2">
												</label></td>
												<td class="margin-top">Nguyễn văn A</td>
											</tr>
											<tr>
												<td><label class="checkbox-inline "> <input
														type="checkbox" value="3" class="no-margin-top"
														id="checkbox_3">
												</label></td>
												<td class="margin-top">Nguyễn văn B</td>
											</tr>
										</tbody>
									</table>
									<input type="hidden" value="" id="buildingId" name="buildingId">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										id="btnAssignBuilding">Giao Tòa Nhà</button>
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
	<!-- /.main-content -->
	<!--script>
					var totalPages = $
					{
						model.totalPage
					};
					var currentPage = $
					{
						model.page
					};
					$(function() {
						window.pagObj = $('#pagination').twbsPagination({
							totalPages : totalPages,
							visiblePages : 10,
							startPage : currentPage,
							onPageClick : function(event, page) {
								if (currentPage != page) {
									$('#limit').val(2);
									$('#page').val(page);
									$('#formSubmit').submit();
								}
							}
						});
					});

					function warningBeforeDelete() {
						swal({
							title : "Xác nhận xóa",
							text : "Bạn có chắc chắn muốn xóa hay không",
							type : "warning",
							showCancelButton : true,
							confirmButtonClass : "btn-success",
							cancelButtonClass : "btn-danger",
							confirmButtonText : "Xác nhận",
							cancelButtonText : "Hủy bỏ",
						})
								.then(
										function(isConfirm) {
											if (isConfirm) {
												var ids = $(
														'tbody input[type=checkbox]:checked')
														.map(
																function() {
																	return $(
																			this)
																			.val();
																}).get();
												deleteNew(ids);
											}
										});
					}
					function deleteNew(data) {
						$
								.ajax({
									url : '${newAPI}',
									type : 'DELETE',
									contentType : 'application/json',
									data : JSON.stringify(data),
									success : function(result) {
										window.location.href = "${newURL}?page=1&limit=2&message=delete_success";
									},
									error : function(error) {
										window.location.href = "${newURL}?page=1&limit=2&message=error_system";
									}
								});
					}
				</script -->
	<script>
		$('#btnSearch').click(function(e) {
			e.preventDefault();
			$('#listForm').submit();
		});
		function assignmentBuildingModal(buildingId) {
			openModelAssignmentBuilding();
			$('#buildingId').val(buildingId);
		}

		function openModelAssignmentBuilding() {
			$('#assignmentbuilding').modal();
		}

		$('#btnAssignBuilding').click(
				function(e) {
					e.preventDefault();
					var data = {};
					data['buildingId'] = $('#buildingId').val();
					var staffs = $('#staffList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['staffs'] = staffs;
					assignStaff(data);
				});

		function assignStaff(data) {
			$.ajax({
				type : "POST",
				url : "http://localhost:8081/manager-building",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					console.log('success');
				},
				console : function(response) {
					console.log('success');
					console.log(response);
				}
			});
		};

		$('#btnDeleteBuilding').click(
				function(e) {
					e.preventDefault();
					var data = {};
					var buildings = $('#buildingList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['buildings'] = buildings;
					deleteBuildings(data);
				});

		function deleteBuildings(data) {
			$.ajax({
				type : "DELETE",
				url : "http://localhost:8081/delete-building",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					console.log('success');
				},
				console : function(response) {
					console.log('success');
					console.log(response);
				}
			});
		};
	</script>
</body>
</html>