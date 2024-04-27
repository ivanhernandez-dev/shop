package dev.ivanhernandez.mooc.students.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;

public final class StudentsResponse implements Response {
	private final List<StudentResponse> students;

	public StudentsResponse(List<StudentResponse> students) {
		this.students = students;
	}

	public List<StudentResponse> students() {
		return students;
	}
}
