package dev.ivanhernandez.mooc.courses_counter.domain;

import dev.ivanhernandez.shared.domain.IdentifierValueObject;

public final class CoursesCounterId extends IdentifierValueObject {
	public CoursesCounterId(String value) {
		super(value);
	}

	private CoursesCounterId() {
	}
}
