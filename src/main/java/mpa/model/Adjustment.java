package mpa.model;

public class Adjustment implements Item {

	private String product;
	private int value;
	private String operation;
	
	public Adjustment(String product, int value, String operation) {
		this.product = product;
		this.value = value;
		this.operation = operation;
	}

	public String getProduct() {
		return product;
	}

	public int getValue() {
		return value;
	}
	
	public String getOperation() {
		return operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + value;
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
		Adjustment other = (Adjustment) obj;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
}
