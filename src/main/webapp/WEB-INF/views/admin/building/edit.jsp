<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="buildingApi" value="/api/buildings" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
					<li class="active">Tòa nhà</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h1>
						Tòa nhà <small> <i
							class="ace-icon fa fa-angle-double-right"></i> Thay đổi thông tin
							tòa nhà
						</small>
					</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<form:form cssClass="form-horizontal" commandName="newModel"
						id="formEdit" method="POST">
						<form:hidden path="staffId" />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="name">
								Tên tòa nhà </label>
							<div class="col-sm-9">
								<form:input path="name" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="street"> Đường </label>
							<div class="col-sm-9">
								<form:input path="street" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="district"> Quận </label>
							<div class="col-sm-9">
								<form:select path="district" id="district"
									style="display: block; width: 50%;">
									<c:if test="${newModel.district != null}">
										<form:option value="" label="${newModel.district}"/>
										<form:options items="${districts}" />
									</c:if>
									<c:if test="${newModel.district == null}">
										<form:option value="" label="---chọn quận---" />
										<form:options items="${districts}" />
									</c:if>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="structure">Kết cấu </label>
							<div class="col-sm-9">
								<form:input path="structure" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="numberOfBasement">Số tầng hầm </label>
							<div class="col-sm-9">
								<input type="number" id="numberOfBasement"
									class="col-xs-10 col-sm-10" name="numberOfBasement">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="floorArea"> Diện tích sàn </label>
							<div class="col-sm-9">
								<input type="number" id="floorArea" class="col-xs-10 col-sm-10"
									name="floorArea" value="${newModel.floorArea}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="direction"> Hướng</label>
							<div class="col-sm-9">
								<form:input path="direction" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="level"> Hạng</label>
							<div class="col-sm-9">
								<form:input path="level" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentPrice"> Giá thuê</label>
							<div class="col-sm-9">
								<input type="number" id="rentPrice" class="col-xs-10 col-sm-10"
									name="rentPrice" value="${newModel.rentPrice}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentPriceDescription"> Chi tiết giá thuê</label>
							<div class="col-sm-9">
								<form:input path="rentPriceDescription"
									cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="serviceFee"> Phí dịch vụ</label>
							<div class="col-sm-9">
								<form:input path="serviceFee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="carFee"> Phí ô tô</label>
							<div class="col-sm-9">
								<form:input path="carFee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="motoFee"> Phí xe máy</label>
							<div class="col-sm-9">
								<form:input path="motoFee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="overtimeFee"> Phí ngoài giờ</label>
							<div class="col-sm-9">
								<form:input path="overtimeFee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="waterFee"> Tiền nước</label>
							<div class="col-sm-9">
								<form:input path="waterFee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="electricityFee"> Tiền điện</label>
							<div class="col-sm-9">
								<form:input path="electricityFee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="deposit"> Tiền đặt cọc</label>
							<div class="col-sm-9">
								<form:input path="deposit" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="payment"> Thanh toán</label>
							<div class="col-sm-9">
								<form:input path="payment" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentTime"> Thời gian thuê</label>
							<div class="col-sm-9">
								<form:input path="rentTime" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="decorationTime"> Thời gian trang trí</label>
							<div class="col-sm-9">
								<form:input path="decorationTime" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="brokeragetee"> Người môi giới</label>
							<div class="col-sm-9">
								<form:input path="brokeragetee" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="note">
								Ghi chú</label>
							<div class="col-sm-9">
								<form:input path="note" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentArea"> Diện tích thuê</label>
							<div class="col-sm-9">
								<form:input path="rentArea" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="buildingTypes"> Loại tòa nhà </label>
							<div class="col-sm-9">
								<form:checkboxes items="${buildingTypes}" path="types" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 pull-right">
								<button type="button" class="btn btn-success"
									id="btnAddBuilding">Thêm tòa nhà</button>
								<button type="button" class="btn btn-success">Hủy</button>
							</div>
						</div>
						<form:hidden path="id" id="buildingId" />
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<script>
		$('#btnAddBuilding').click(function() {
			var data = {};
			var fromData = $('#formEdit').serializeArray();
			var buildingTypes = [];
			$.each(fromData, function(index, values) {
				if (values.name === 'types') {
					buildingTypes.push(values.value);
				} else {
					data['' + values.name + ''] = values.value;
				}
			});
			data['types'] = buildingTypes;
			$.ajax({
				type : 'POST',
				url : '${buildingApi}',
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					$('#listBuilding').click();
					console.log('success');
				},
				error : function(response) {
					console.log('fail');
					console.log(response);
				}
			});
		});
	</script>
</body>
</html>
