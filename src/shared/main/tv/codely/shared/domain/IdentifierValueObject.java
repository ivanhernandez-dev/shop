package tv.codely.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class IdentifierValueObject implements Serializable {
	final protected String value;

	public IdentifierValueObject(String value) {
		ensureValidUuid(value);

		this.value = value;
	}

	protected IdentifierValueObject() {
		this.value = null;
	}

	public String value() {
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
		IdentifierValueObject that = (IdentifierValueObject) o;
		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	private void ensureValidUuid(String value) throws IllegalArgumentException {
		UUID.fromString(value);
	}

	@Override
	public String toString() {
		return value;
	}
}
