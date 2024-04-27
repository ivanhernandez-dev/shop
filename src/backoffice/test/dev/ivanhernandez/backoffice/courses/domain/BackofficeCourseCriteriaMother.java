package dev.ivanhernandez.backoffice.courses.domain;

import dev.ivanhernandez.shared.domain.criteria.Criteria;
import dev.ivanhernandez.shared.domain.criteria.Filter;
import dev.ivanhernandez.shared.domain.criteria.Filters;
import dev.ivanhernandez.shared.domain.criteria.Order;

import java.util.Arrays;

public final class BackofficeCourseCriteriaMother {
	public static Criteria nameAndDurationContains(String name, String duration) {
		Filter nameFilter = Filter.create("name", "contains", name);
		Filter durationFilter = Filter.create("duration", "contains", duration);

		return new Criteria(new Filters(Arrays.asList(nameFilter, durationFilter)), Order.asc("name"));
	}
}
