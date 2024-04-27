package dev.ivanhernandez.mooc.courses_counter.application.find;

import dev.ivanhernandez.shared.domain.IntegerMother;

final class CoursesCounterResponseMother {
	public static CoursesCounterResponse create(Integer value) {
		return new CoursesCounterResponse(value);
	}

	public static CoursesCounterResponse random() {
		return create(IntegerMother.random());
	}
}
