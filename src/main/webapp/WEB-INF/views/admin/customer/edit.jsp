<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="customerAPI" value="/api/customer" />
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
					<li class="active">Khách hàng</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h1>
						Khách hàng <small> <i
							class="ace-icon fa fa-angle-double-right"></i> Thay đổi thông tin
							khách hàng
						</small>
					</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<form:form cssClass="form-horizontal" commandName="newModel"
						id="formEdit" method="POST">
						<form:hidden path="staffId" />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="fullName"> Tên khách hàng </label>
							<div class="col-sm-9">
								<form:input path="fullName" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="street"> Số điện thoại</label>
							<div class="col-sm-9">
								<form:input path="phone" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="floorArea"> Email </label>
							<div class="col-sm-9">
								<form:input path="email" cssClass="col-xs-10 col-sm-10" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-9 pull-right">
								<button type="button" class="btn btn-success"
									id="btnAddCustomer">Thêm khách hàng</button>
								<button type="button" class="btn btn-success">Hủy</button>
							</div>
						</div>
						<form:hidden path="id" id="customerId" />
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<script>
		$('#btnAddCustomer').click(function() {
			var data = {};
			var fromData = $('#formEdit').serializeArray();
			$.each(fromData, function(index, values) {
					data['' + values.name + ''] = values.value;
			});
			$.ajax({
				type : 'POST',
				url : '${customerAPI}',
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					console.log(reponse);
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
