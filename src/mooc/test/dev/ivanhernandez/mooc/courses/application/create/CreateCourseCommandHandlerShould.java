package dev.ivanhernandez.mooc.courses.application.create;

import dev.ivanhernandez.mooc.courses.CoursesModuleUnitTestCase;
import dev.ivanhernandez.mooc.courses.domain.Course;
import dev.ivanhernandez.mooc.courses.domain.CourseCreatedDomainEventMother;
import dev.ivanhernandez.mooc.courses.domain.CourseMother;
import dev.ivanhernandez.shared.domain.course.CourseCreatedDomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CreateCourseCommandHandlerShould extends CoursesModuleUnitTestCase {
	private CreateCourseCommandHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		handler = new CreateCourseCommandHandler(new CourseCreator(repository, eventBus));
	}

	@Test
	void create_a_valid_course() {
		CreateCourseCommand command = CreateCourseCommandMother.random();

		Course course = CourseMother.fromRequest(command);
		CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

		handler.handle(command);

		shouldHaveSaved(course);
		shouldHavePublished(domainEvent);
	}
}
