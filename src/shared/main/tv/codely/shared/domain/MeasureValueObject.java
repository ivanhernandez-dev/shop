package tv.codely.shared.domain;

public abstract class MeasureValueObject {
	Double value;

	public MeasureValueObject(Double value) {
		this.value = value;
	}

	public Double value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		MeasureValueObject that = (MeasureValueObject) o;

		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public void ensureValidMeasure(Double value) {
		if (value < 0) {
			throw new IllegalArgumentException("The measure must be greater or equal than 0");
		}
	}
}
