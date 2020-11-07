<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingApi" value="/api/buildings" />
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
					<form class="form-horizontal" role="form" id="formEdit">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">
								Tên tòa nhà </label>

							<div class="col-sm-9">
								<input type="text" id="name" class="col-xs-10 col-sm-10"
									name="name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">
								Sô tầng hầm </label>

							<div class="col-sm-9">
								<input type="text" id="street" class="col-xs-10 col-sm-10"
									name="street">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">
								Quận </label>
							<div class="col-sm-9">
								<select name="" id="" style="display: block; width: 80%;">
									<option value="">--Chọn quận--</option>
									<option value="">Quận 1</option>
									<option value="">Quận 2</option>
									<option value="">Quận 3</option>
									<option value="">Quận 4</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Kết
								cấu </label>
							<div class="col-sm-9">
								<input type="text" id="structure" class="col-xs-10 col-sm-10"
									name="structure">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">Số
								tầng hầm </label>
							<div class="col-sm-9">
								<input type="number" id="numberOfBasement"
									class="col-xs-10 col-sm-10" name="numberOfBasement">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="">
								Diện tích sàn </label>
							<div class="col-sm-9">
								<input type="number" id="floorArea" class="col-xs-10 col-sm-10"
									name="floorArea">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Hướng</label>
							<div class="col-sm-9">
								<input type="text" id="direction" class="col-xs-10 col-sm-10"
									name="direction">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Hạng</label>
							<div class="col-sm-9">
								<input type="text" id="level" class="col-xs-10 col-sm-10"
									name="level">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Giá thuê</label>
							<div class="col-sm-9">
								<input type="number" id="rentPrice" class="col-xs-10 col-sm-10"
									name="rentPrice">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Chi tiết giá thuê</label>
							<div class="col-sm-9">
								<input type="text" id="rentPriceDescription"
									class="col-xs-10 col-sm-10" name="rentPriceDescription">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Phí dịch vụ</label>
							<div class="col-sm-9">
								<input type="text" id="serviceFee" class="col-xs-10 col-sm-10"
									name="serviceFee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Phí ô tô</label>
							<div class="col-sm-9">
								<input type="text" id="carFee" class="col-xs-10 col-sm-10"
									name="carFee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Phí xe máy</label>
							<div class="col-sm-9">
								<input type="text" id="motoFee" class="col-xs-10 col-sm-10"
									name="motoFee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Phí ngoài giờ</label>
							<div class="col-sm-9">
								<input type="text" id="overtimeFee" class="col-xs-10 col-sm-10"
									name="overtimeFee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Tiền nước</label>
							<div class="col-sm-9">
								<input type="text" id="waterFee" class="col-xs-10 col-sm-10"
									name="waterFee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Tiền điện</label>
							<div class="col-sm-9">
								<input type="text" id="electricityFee"
									class="col-xs-10 col-sm-10" name="electricityFee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Tiền đặt cọc</label>
							<div class="col-sm-9">
								<input type="text" id="deposit" class="col-xs-10 col-sm-10"
									name="deposit">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Thanh toán</label>
							<div class="col-sm-9">
								<input type="text" id="payment" class="col-xs-10 col-sm-10"
									name="payment">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Thời gian thuê</label>
							<div class="col-sm-9">
								<input type="text" id="rentTime" class="col-xs-10 col-sm-10"
									name="rentTime">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Thời gian trang trí</label>
							<div class="col-sm-9">
								<input type="text" id="decorationTime"
									class="col-xs-10 col-sm-10" name="decorationTime">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Người môi giới</label>
							<div class="col-sm-9">
								<input type="number" id="brokeragetee"
									class="col-xs-10 col-sm-10" name="brokeragetee">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Ghi chú</label>
							<div class="col-sm-9">
								<input type="text" id="note" class="col-xs-10 col-sm-10"
									name="note">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentAreas"> Diện tích thuê</label>
							<div class="col-sm-9">
								<input type="text" id="rentArea" class="col-xs-10 col-sm-10"
									name="rentArea">
							</div>
						</div>



						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="buildingTypes"> Loại tòa nhà </label>
							<div class="col-sm-9">
								<label class="checkbox-inline "> <input type="checkbox"
									id="buildingTypes" value="TANG_TRET" name="buildingTypes">
									<b>Tầng trệt</b>
								</label> <label class="checkbox-inline"> <input type="checkbox"
									id="buildingTypes" value="NGUYEN_CAN" name="buildingTypes">
									<b> Nguyên căn</b>
								</label> <label class="checkbox-inline"> <input type="checkbox"
									id="buildingTypes" value="NOI_THAT" name="buildingTypes">
									<b>Nội thất</b>
								</label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 pull-right">
								<button type="button" class="btn btn-success"
									id="btnAddBuilding">Thêm tòa nhà</button>
								<button type="button" class="btn btn-success">Hủy</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
	$('#btnAddBuilding').click(function(){
        var data = {};
        var fromData = $('#formEdit').serializeArray();
        var buildingTypes = [];
        $.each(fromData, function (index, values) { 
             if (values.name === 'buildingTypes') {
                buildingTypes.push(values.value);
             } else {
                 data['' +values.name+ ''] = values.value;
             }
        });
        data['buildingType'] = buildingTypes;
        $.ajax({
            type: 'POST',
            url: '${buildingApi}',
            data: JSON.stringify(data),
            dataType: "json",
            contentType : "application/json",
            success: function (response) {
                console.log('success');
            },
            console: function(response){
                console.log('success');
                console.log(response);
            }
        });
    });
	</script>
</body>
</html>
