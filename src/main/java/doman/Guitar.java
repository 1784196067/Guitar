package doman;

public class Guitar {
	private String serialNumber, builder, model, type, backWood, topWood;
	private double price;

	public Guitar() {
		super();
	}

	
	public Guitar(String builder, String model, String type, String backWood, String topWood) {
		super();
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public Guitar(String serialNumber, double price,
	                String builder, String model, String type,
	                String backWood, String topWood) {
	    this.serialNumber = serialNumber;
	    this.price = price;
	    this.builder = builder;
	    this.model = model;
	    this.type = type;
	    this.backWood = backWood;
	    this.topWood = topWood;
	  }

	  public String getSerialNumber() {
	    return serialNumber;
	  }

	  public double getPrice() {
	    return price;
	  }
	  public void setPrice(float newPrice) {
	    this.price = newPrice;
	  }
	  public String getBuilder() {
	    return builder;
	  }
	  public String getModel() {
	    return model;
	  }
	  public String getType() {
	    return type;
	  }
	  public String getBackWood() {
	    return backWood;
	  }
	  public String getTopWood() {
	    return topWood;
	  }

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return builder.toLowerCase() + " " + model.toLowerCase() + " " +  type.toLowerCase() + " " + backWood.toLowerCase()
				+ " " + topWood.toLowerCase();
	}
	
	
}
