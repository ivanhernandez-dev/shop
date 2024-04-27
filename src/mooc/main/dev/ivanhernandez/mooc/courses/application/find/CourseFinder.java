package dev.ivanhernandez.mooc.courses.application.find;

import dev.ivanhernandez.mooc.courses.application.CourseResponse;
import dev.ivanhernandez.mooc.courses.domain.CourseId;
import dev.ivanhernandez.mooc.courses.domain.CourseNotExist;
import dev.ivanhernandez.mooc.courses.domain.CourseRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class CourseFinder {
	private final CourseRepository repository;

	public CourseFinder(CourseRepository repository) {
		this.repository = repository;
	}

	public CourseResponse find(CourseId id) throws CourseNotExist {
		return repository.search(id)
			.map(CourseResponse::fromAggregate)
			.orElseThrow(() -> new CourseNotExist(id));
	}
}
