package dev.ivanhernandez.mooc.courses.domain;

import dev.ivanhernandez.shared.domain.IdentifierValueObject;

public final class CourseId extends IdentifierValueObject {
	public CourseId(String value) {
		super(value);
	}

	public CourseId() {
	}
}
