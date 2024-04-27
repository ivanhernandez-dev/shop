package dev.ivanhernandez.mooc.courses.application;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.List;

public final class CoursesResponse implements Response {
	private final List<CourseResponse> courses;

	public CoursesResponse(List<CourseResponse> courses) {
		this.courses = courses;
	}

	public List<CourseResponse> courses() {
		return courses;
	}
}
