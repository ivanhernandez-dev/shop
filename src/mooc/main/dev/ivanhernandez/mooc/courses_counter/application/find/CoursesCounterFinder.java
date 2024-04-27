package dev.ivanhernandez.mooc.courses_counter.application.find;

import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounter;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterNotInitialized;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class CoursesCounterFinder {
	private CoursesCounterRepository repository;

	public CoursesCounterFinder(CoursesCounterRepository repository) {
		this.repository = repository;
	}

	public CoursesCounterResponse find() {
		CoursesCounter coursesCounter = repository.search().orElseGet(() -> {
			throw new CoursesCounterNotInitialized();
		});

		return new CoursesCounterResponse(coursesCounter.total().value());
	}
}
