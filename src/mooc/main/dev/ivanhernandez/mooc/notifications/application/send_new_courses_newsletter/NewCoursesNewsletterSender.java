package dev.ivanhernandez.mooc.notifications.application.send_new_courses_newsletter;

import dev.ivanhernandez.mooc.courses.application.CoursesResponse;
import dev.ivanhernandez.mooc.courses.application.search_last.SearchLastCoursesQuery;
import dev.ivanhernandez.mooc.notifications.domain.EmailSender;
import dev.ivanhernandez.mooc.notifications.domain.NewCoursesNewsletter;
import dev.ivanhernandez.mooc.students.application.StudentResponse;
import dev.ivanhernandez.mooc.students.application.StudentsResponse;
import dev.ivanhernandez.mooc.students.application.search_all.SearchAllStudentsQuery;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.UuidGenerator;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;

@Component
public final class NewCoursesNewsletterSender {
	private final static Integer TOTAL_COURSES = 3;
	private final QueryBus queryBus;
	private final EmailSender sender;
	private final UuidGenerator uuidGenerator;
	private final EventBus eventBus;

	public NewCoursesNewsletterSender(
		QueryBus queryBus,
		UuidGenerator uuidGenerator,
		EmailSender sender,
		EventBus eventBus
	) {
		this.queryBus = queryBus;
		this.uuidGenerator = uuidGenerator;
		this.sender = sender;
		this.eventBus = eventBus;
	}

	public void send() {
		CoursesResponse courses = queryBus.ask(new SearchLastCoursesQuery(TOTAL_COURSES));

		if (courses.courses().size() > 0) {
			StudentsResponse students = queryBus.ask(new SearchAllStudentsQuery());

			students.students().forEach(student -> send(student, courses));
		}
	}

	public void send(StudentResponse student, CoursesResponse courses) {
		NewCoursesNewsletter newsletter = NewCoursesNewsletter.send(uuidGenerator.generate(), student, courses);

		sender.send(newsletter);

		eventBus.publish(newsletter.pullDomainEvents());
	}
}
