package dev.ivanhernandez.mooc.notifications.domain;

import dev.ivanhernandez.mooc.courses.application.CoursesResponse;
import dev.ivanhernandez.mooc.courses.application.CoursesResponseMother;
import dev.ivanhernandez.mooc.students.application.StudentResponse;
import dev.ivanhernandez.mooc.students.application.StudentResponseMother;

public final class NewCoursesNewsletterMother {
	public static NewCoursesNewsletter create(EmailId id, StudentResponse student, CoursesResponse courses) {
		return new NewCoursesNewsletter(id, student, courses);
	}

	public static NewCoursesNewsletter create(StudentResponse student, CoursesResponse courses) {
		return new NewCoursesNewsletter(EmailIdMother.random(), student, courses);
	}

	public static NewCoursesNewsletter random() {
		return create(EmailIdMother.random(), StudentResponseMother.random(), CoursesResponseMother.random());
	}
}
