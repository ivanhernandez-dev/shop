package dev.ivanhernandez.mooc.students.application.search_all;

import dev.ivanhernandez.shared.domain.bus.query.Query;

import java.util.Objects;

public final class SearchAllStudentsQuery implements Query {
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return o != null && getClass() == o.getClass();
	}

	@Override
	public int hashCode() {
		return Objects.hash("SearchAllStudentsQuery");
	}
}
