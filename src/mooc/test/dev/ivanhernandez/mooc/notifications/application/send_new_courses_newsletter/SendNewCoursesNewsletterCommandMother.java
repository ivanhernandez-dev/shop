package dev.ivanhernandez.mooc.notifications.application.send_new_courses_newsletter;

import dev.ivanhernandez.shared.domain.UuidMother;

public final class SendNewCoursesNewsletterCommandMother {
	public static SendNewCoursesNewsletterCommand random() {
		return new SendNewCoursesNewsletterCommand(UuidMother.random());
	}
}
