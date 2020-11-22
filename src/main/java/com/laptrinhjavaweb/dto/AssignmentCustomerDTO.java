package com.laptrinhjavaweb.dto;

public class AssignmentCustomerDTO {

	private Long customerId;
	private Long staffId;
	private Long[] staffIds;
	private String status;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Long[] getStaffIds() {
		return staffIds;
	}
	public void setStaffIds(Long[] staffIds) {
		this.staffIds = staffIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
