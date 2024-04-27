package dev.ivanhernandez.mooc.courses.application;

import dev.ivanhernandez.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class CoursesResponseMother {
	public static CoursesResponse create(List<CourseResponse> courses) {
		return new CoursesResponse(courses);
	}

	public static CoursesResponse random() {
		return create(ListMother.random(CourseResponseMother::random));
	}

	public static CoursesResponse times(int times) {
		return create(ListMother.create(times, CourseResponseMother::random));
	}

	public static CoursesResponse empty() {
		return create(Collections.emptyList());
	}
}
