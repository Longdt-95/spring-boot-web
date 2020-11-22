package com.laptrinhjavaweb.builder;

public class CustomerSearchBuilder {

	private String fullName;
	private String phone;
	private String email;
	private Long staffId;
	
	public String getFullName() {
		return fullName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public Long getStaffId() {
		return staffId;
	}
	
	public CustomerSearchBuilder(builderCustomer builder) {
		this.email = builder.email;
		this.fullName = builder.fullName;
		this.phone = builder.phone;
		this.staffId = builder.staffId;
	}
	
	public static class builderCustomer {
		
		private String fullName;
		private String phone;
		private String email;
		private Long staffId;
		
		public builderCustomer setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}
		public builderCustomer setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		public builderCustomer setEmail(String email) {
			this.email = email;
			return this;
		}
		public builderCustomer setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		
		public CustomerSearchBuilder build() {
			return new CustomerSearchBuilder(this);
		}
	}
}
