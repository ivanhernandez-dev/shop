package dev.ivanhernandez.mooc.courses.domain;

import dev.ivanhernandez.shared.domain.IntegerMother;
import dev.ivanhernandez.shared.domain.RandomElementPicker;

public final class CourseDurationMother {
	public static CourseDuration create(String value) {
		return new CourseDuration(value);
	}

	public static CourseDuration random() {
		return create(
			String.format(
				"%s %s",
				IntegerMother.random(),
				RandomElementPicker.from("months", "years", "days", "hours", "minutes", "seconds")
			)
		);
	}
}
