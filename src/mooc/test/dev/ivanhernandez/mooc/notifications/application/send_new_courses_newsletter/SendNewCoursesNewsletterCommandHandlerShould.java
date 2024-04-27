package dev.ivanhernandez.mooc.notifications.application.send_new_courses_newsletter;

import dev.ivanhernandez.mooc.courses.application.CoursesResponse;
import dev.ivanhernandez.mooc.courses.application.CoursesResponseMother;
import dev.ivanhernandez.mooc.courses.application.search_last.SearchLastCoursesQuery;
import dev.ivanhernandez.mooc.courses.application.search_last.SearchLastCoursesQueryMother;
import dev.ivanhernandez.mooc.notifications.application.NotificationsModuleUnitTestCase;
import dev.ivanhernandez.mooc.notifications.domain.NewCoursesNewsletter;
import dev.ivanhernandez.mooc.notifications.domain.NewCoursesNewsletterEmailSent;
import dev.ivanhernandez.mooc.notifications.domain.NewCoursesNewsletterEmailSentMother;
import dev.ivanhernandez.mooc.notifications.domain.NewCoursesNewsletterMother;
import dev.ivanhernandez.mooc.students.application.StudentResponse;
import dev.ivanhernandez.mooc.students.application.StudentResponseMother;
import dev.ivanhernandez.mooc.students.application.StudentsResponse;
import dev.ivanhernandez.mooc.students.application.StudentsResponseMother;
import dev.ivanhernandez.mooc.students.application.search_all.SearchAllStudentsQuery;
import dev.ivanhernandez.mooc.students.application.search_all.SearchAllStudentsQueryMother;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandlerExecutionError;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandlerExecutionError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

final class SendNewCoursesNewsletterCommandHandlerShould extends NotificationsModuleUnitTestCase {
	SendNewCoursesNewsletterCommandHandler handler;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		handler = new SendNewCoursesNewsletterCommandHandler(
			new NewCoursesNewsletterSender(queryBus, uuidGenerator, sender, eventBus)
		);
	}

	@Test
	void not_send_the_newsletter_when_there_are_no_courses() throws QueryHandlerExecutionError, CommandHandlerExecutionError {
		SendNewCoursesNewsletterCommand command = SendNewCoursesNewsletterCommandMother.random();

		SearchLastCoursesQuery coursesQuery = SearchLastCoursesQueryMother.create(3);
		CoursesResponse coursesResponse = CoursesResponseMother.empty();

		shouldAsk(coursesQuery, coursesResponse);

		handler.handle(command);
	}

	@Test
	void not_send_the_newsletter_when_there_are_no_students() throws QueryHandlerExecutionError, CommandHandlerExecutionError {
		SendNewCoursesNewsletterCommand command = SendNewCoursesNewsletterCommandMother.random();

		SearchLastCoursesQuery coursesQuery = SearchLastCoursesQueryMother.create(3);
		CoursesResponse coursesResponse = CoursesResponseMother.random();

		SearchAllStudentsQuery studentsQuery = SearchAllStudentsQueryMother.random();
		StudentsResponse studentsResponse = StudentsResponseMother.empty();

		shouldAsk(coursesQuery, coursesResponse);
		shouldAsk(studentsQuery, studentsResponse);

		handler.handle(command);
	}

	@Test
	void send_the_new_courses_newsletter() throws QueryHandlerExecutionError, CommandHandlerExecutionError {
		SendNewCoursesNewsletterCommand command = SendNewCoursesNewsletterCommandMother.random();

		SearchLastCoursesQuery coursesQuery = SearchLastCoursesQueryMother.create(3);
		CoursesResponse coursesResponse = CoursesResponseMother.times(3);

		SearchAllStudentsQuery studentsQuery = SearchAllStudentsQueryMother.random();
		StudentResponse student = StudentResponseMother.random();
		StudentResponse otherStudent = StudentResponseMother.random();
		StudentsResponse studentsResponse = StudentsResponseMother.create(Arrays.asList(student, otherStudent));

		NewCoursesNewsletter newsletter = NewCoursesNewsletterMother.create(student, coursesResponse);
		NewCoursesNewsletter otherNewsletter = NewCoursesNewsletterMother.create(otherStudent, coursesResponse);

		NewCoursesNewsletterEmailSent domainEvent = NewCoursesNewsletterEmailSentMother.create(
			newsletter.id(),
			student.id()
		);
		NewCoursesNewsletterEmailSent otherDomainEvent = NewCoursesNewsletterEmailSentMother.create(
			otherNewsletter.id(),
			otherStudent.id()
		);

		shouldAsk(coursesQuery, coursesResponse);
		shouldAsk(studentsQuery, studentsResponse);

		shouldGenerateUuids(newsletter.id().value(), otherNewsletter.id().value());

		handler.handle(command);

		shouldHaveSentEmail(newsletter);
		shouldHavePublished(domainEvent);

		shouldHaveSentEmail(otherNewsletter);
		shouldHavePublished(otherDomainEvent);
	}
}
