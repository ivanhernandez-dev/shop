package dev.ivanhernandez.backoffice.courses.application.search_by_criteria;

import dev.ivanhernandez.backoffice.courses.application.BackofficeCourseResponse;
import dev.ivanhernandez.backoffice.courses.application.BackofficeCoursesResponse;
import dev.ivanhernandez.backoffice.courses.domain.BackofficeCourseRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.criteria.Criteria;
import dev.ivanhernandez.shared.domain.criteria.Filters;
import dev.ivanhernandez.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public final class BackofficeCoursesByCriteriaSearcher {
	private final BackofficeCourseRepository repository;

	public BackofficeCoursesByCriteriaSearcher(BackofficeCourseRepository repository) {
		this.repository = repository;
	}

	public BackofficeCoursesResponse search(
		Filters filters,
		Order order,
		Optional<Integer> limit,
		Optional<Integer> offset
	) {
		Criteria criteria = new Criteria(filters, order, limit, offset);

		return new BackofficeCoursesResponse(
			repository.matching(criteria)
				.stream()
				.map(BackofficeCourseResponse::fromAggregate)
				.collect(Collectors.toList())
		);
	}
}