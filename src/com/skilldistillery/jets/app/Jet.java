package com.skilldistillery.jets.app;

public abstract class Jet {

	private String model;
	private String type;
	private double speed;
	private int range;
	private long price;

	

	public Jet(String model, String type, double speed, int range, long price) {
		super();
		this.model = model;
		this.type = type;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		System.out.println(this.model + ": Flight Time: " + flightTime(speed, range) + "hrs at Mach: "
				+ getSpeedInMach(speed) + ".");
	}

	public double getSpeedInMach(double speed) {
		return speed / 767.269;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double flightTime(double speed, int range) {
		return (Math.round((range / speed) * 10.0) / 10.0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet Model: ").append(model).append(" Type: ").append(type).append(", Top Speed: ").append(speed).append("mph, range: ")
				.append(range).append(" miles, Price: $").append(price).append(" ");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		long temp;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
