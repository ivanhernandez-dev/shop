package dev.ivanhernandez.backoffice.courses.application.search_all;

import dev.ivanhernandez.backoffice.courses.application.BackofficeCourseResponse;
import dev.ivanhernandez.backoffice.courses.application.BackofficeCoursesResponse;
import dev.ivanhernandez.backoffice.courses.domain.BackofficeCourseRepository;
import dev.ivanhernandez.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllBackofficeCoursesSearcher {
	private final BackofficeCourseRepository repository;

	public AllBackofficeCoursesSearcher(BackofficeCourseRepository repository) {
		this.repository = repository;
	}

	public BackofficeCoursesResponse search() {
		return new BackofficeCoursesResponse(
			repository.searchAll().stream().map(BackofficeCourseResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
