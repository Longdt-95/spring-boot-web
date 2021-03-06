package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {

	private String name;
	private String street;
	private String ward;
	private String district;
	private String level;
	private Integer numberOfBasement;
	private Integer floorArea;
	private String direction;
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private String managerName;
	private String managerPhone;
	private Long staffId;
	private String[] types = new String[] {};

	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}

	public Integer getRentAreaTo() {
		return rentAreaTo;
	}

	public Integer getRentPriceFrom() {
		return rentPriceFrom;
	}

	public Integer getRentPriceTo() {
		return rentPriceTo;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public Long getstaffId() {
		return staffId;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getWard() {
		return ward;
	}

	public String getDistrict() {
		return district;
	}

	public String getLevel() {
		return level;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public String getDirection() {
		return direction;
	}

	private BuildingSearchBuilder(BuilderBuilding builder) {
		this.name = builder.name;
		this.street = builder.street;
		this.direction = builder.direction;
		this.district = builder.district;
		this.numberOfBasement = builder.numberOfBasement;
		this.ward = builder.ward;
		this.floorArea = builder.floorArea;
		this.level = builder.level;
		this.staffId = builder.staffId;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.managerName = builder.managerName;
		this.managerPhone = builder.managerPhone;
		this.types = builder.types;
	}

	public String[] getTypes() {
		return types;
	}

	// Builder Class
	public static class BuilderBuilding {

		private String name;
		private String street;
		private String ward;
		private String district;
		private String level;
		private Integer numberOfBasement;
		private Integer floorArea;
		private String direction;
		private Integer rentAreaFrom;
		private Integer rentAreaTo;
		private Integer rentPriceFrom;
		private Integer rentPriceTo;
		private String managerName;
		private String managerPhone;
		private Long staffId;
		private String[] types = new String[] {};

		public BuilderBuilding setRentAreaFrom(Integer rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}

		public BuilderBuilding setRentAreaTo(Integer rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}

		public BuilderBuilding setRentPriceFrom(Integer rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}

		public BuilderBuilding setRentPriceTo(Integer rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}

		public BuilderBuilding setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}

		public BuilderBuilding setManagerPhone(String managerPhone) {
			this.managerPhone = managerPhone;
			return this;
		}

		public BuilderBuilding setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}

		public BuilderBuilding setName(String name) {
			this.name = name;
			return this;
		}

		public BuilderBuilding setStreet(String street) {
			this.street = street;
			return this;
		}

		public BuilderBuilding setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public BuilderBuilding setDistrict(String district) {
			this.district = district;
			return this;
		}

		public BuilderBuilding setLevel(String level) {
			this.level = level;
			return this;
		}

		public BuilderBuilding setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public BuilderBuilding setFloorArea(Integer floorarea) {
			this.floorArea = floorarea;
			return this;
		}

		public BuilderBuilding setDirection(String direction) {
			this.direction = direction;
			return this;
		}

		public BuilderBuilding setTypes(String[] types) {
			this.types = types;
			return this;
		}

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}
}
