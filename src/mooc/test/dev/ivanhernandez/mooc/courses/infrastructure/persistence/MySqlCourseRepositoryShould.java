package dev.ivanhernandez.mooc.courses.infrastructure.persistence;

import dev.ivanhernandez.mooc.courses.CoursesModuleInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses.domain.Course;
import dev.ivanhernandez.mooc.courses.domain.CourseIdMother;
import dev.ivanhernandez.mooc.courses.domain.CourseMother;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlCourseRepositoryShould extends CoursesModuleInfrastructureTestCase {
	@Test
	void save_a_course() {
		Course course = CourseMother.random();

		mySqlCourseRepository.save(course);
	}

	@Test
	void return_an_existing_course() {
		Course course = CourseMother.random();

		mySqlCourseRepository.save(course);

		assertEquals(Optional.of(course), mySqlCourseRepository.search(course.id()));
	}

	@Test
	void not_return_a_non_existing_course() {
		assertFalse(mySqlCourseRepository.search(CourseIdMother.random()).isPresent());
	}
}
