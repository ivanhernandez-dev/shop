package dev.ivanhernandez.mooc.courses_counter.infrastructure.persistence;

import dev.ivanhernandez.mooc.courses_counter.CoursesCounterModuleInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounter;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterMother;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
class MySqlCoursesCounterRepositoryShould extends CoursesCounterModuleInfrastructureTestCase {
	@Test
	void return_an_existing_courses_counter() {
		CoursesCounter counter = CoursesCounterMother.random();

		repository.save(counter);

		assertEquals(Optional.of(counter), repository.search());
	}
}
