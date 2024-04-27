package dev.ivanhernandez.mooc.courses.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class CourseName extends StringValueObject {
	public CourseName(String value) {
		super(value);
	}

	public CourseName() {
		super("");
	}
}
