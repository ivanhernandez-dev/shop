package dev.ivanhernandez.mooc.courses_counter.application.find;

import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.Objects;

public final class CoursesCounterResponse implements Response {
	private Integer total;

	public CoursesCounterResponse(Integer total) {
		this.total = total;
	}

	public Integer total() {
		return total;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CoursesCounterResponse that = (CoursesCounterResponse) o;
		return total.equals(that.total);
	}

	@Override
	public int hashCode() {
		return Objects.hash(total);
	}
}