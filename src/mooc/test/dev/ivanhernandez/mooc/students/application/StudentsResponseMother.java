package dev.ivanhernandez.mooc.students.application;

import dev.ivanhernandez.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class StudentsResponseMother {
	public static StudentsResponse create(List<StudentResponse> courses) {
		return new StudentsResponse(courses);
	}

	public static StudentsResponse random() {
		return create(ListMother.random(StudentResponseMother::random));
	}

	public static StudentsResponse empty() {
		return create(Collections.emptyList());
	}
}
