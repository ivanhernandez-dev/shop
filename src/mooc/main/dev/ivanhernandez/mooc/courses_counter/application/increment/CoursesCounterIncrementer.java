package dev.ivanhernandez.mooc.courses_counter.application.increment;

import dev.ivanhernandez.mooc.courses.domain.CourseId;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounter;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.UuidGenerator;

@Component
public final class CoursesCounterIncrementer {
	private CoursesCounterRepository repository;
	private UuidGenerator uuidGenerator;

	public CoursesCounterIncrementer(CoursesCounterRepository repository, UuidGenerator uuidGenerator) {
		this.repository = repository;
		this.uuidGenerator = uuidGenerator;
	}

	public void increment(CourseId id) {
		CoursesCounter counter = repository.search()
			.orElseGet(() -> CoursesCounter.initialize(uuidGenerator.generate()));

		if (!counter.hasIncremented(id)) {
			counter.increment(id);

			repository.save(counter);
		}
	}
}
