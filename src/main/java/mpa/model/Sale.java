package mpa.model;

import static mpa.util.Constants.ADD_OPERATION;
import static mpa.util.Constants.MULTIPLY_OPERATION;
import static mpa.util.Constants.SUBTRACT_OPERATION;

public class Sale implements Item {

	private String product;
	private int value;
	private int numberOfOccurrences;

	public Sale(String product, int value) {
		this.product = product;
		this.value = value;
		this.numberOfOccurrences = 1;
	}

	public Sale(String product, int value, int numberOfOccurrences) {
		this.product = product;
		this.value = value;
		this.numberOfOccurrences = numberOfOccurrences;
	}
	
	public int getValue() {
		return value * numberOfOccurrences;
	}

	public void makeAdjustment(Adjustment adj) {
		switch (adj.getOperation()) {
		case ADD_OPERATION:
			this.value += adj.getValue();
		case MULTIPLY_OPERATION:
			this.value *= adj.getValue();
		case SUBTRACT_OPERATION:
			this.value -= adj.getValue();
		}
	}

	public String getProduct() {
		return product;
	}

	public String getOperation() {
		return "SALE";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfOccurrences;
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
		Sale other = (Sale) obj;
		if (numberOfOccurrences != other.numberOfOccurrences)
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
