package dev.ivanhernandez.mooc.courses.domain;

import dev.ivanhernandez.shared.domain.StringValueObject;

public final class CourseDuration extends StringValueObject {
	public CourseDuration(String value) {
		super(value);
	}

	private CourseDuration() {
		super("");
	}
}
