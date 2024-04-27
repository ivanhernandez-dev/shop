package dev.ivanhernandez.mooc.courses.application.search_last;

import dev.ivanhernandez.mooc.courses.application.CourseResponse;
import dev.ivanhernandez.mooc.courses.application.CoursesResponse;
import dev.ivanhernandez.mooc.courses.domain.CourseRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.criteria.Criteria;
import dev.ivanhernandez.shared.domain.criteria.Filters;
import dev.ivanhernandez.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public final class LastCoursesSearcher {
	private final CourseRepository repository;

	public LastCoursesSearcher(CourseRepository repository) {
		this.repository = repository;
	}

	public CoursesResponse search(int courses) {
		Criteria criteria = new Criteria(
			Filters.none(),
			Order.none(),
			Optional.of(courses),
			Optional.empty()
		);

		return new CoursesResponse(
			repository.matching(criteria).stream().map(CourseResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
