package dev.ivanhernandez.mooc.notifications.application.send_new_courses_newsletter;

import dev.ivanhernandez.shared.domain.bus.command.Command;

public final class SendNewCoursesNewsletterCommand implements Command {
	private final String id;

	public SendNewCoursesNewsletterCommand(String id) {
		this.id = id;
	}

	public String id() {
		return id;
	}
}
