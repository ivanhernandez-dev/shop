package dev.ivanhernandez.mooc.courses;

import org.junit.jupiter.api.BeforeEach;
import dev.ivanhernandez.mooc.courses.domain.Course;
import dev.ivanhernandez.mooc.courses.domain.CourseRepository;
import dev.ivanhernandez.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class CoursesModuleUnitTestCase extends UnitTestCase {
	protected CourseRepository repository;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		repository = mock(CourseRepository.class);
	}

	public void shouldHaveSaved(Course course) {
		verify(repository, atLeastOnce()).save(course);
	}
}
