package dev.ivanhernandez.mooc.notifications.application.send_new_courses_newsletter;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.command.CommandHandler;

@Component
public final class SendNewCoursesNewsletterCommandHandler implements CommandHandler<SendNewCoursesNewsletterCommand> {
	private final NewCoursesNewsletterSender sender;

	public SendNewCoursesNewsletterCommandHandler(NewCoursesNewsletterSender sender) {
		this.sender = sender;
	}

	@Override
	public void handle(SendNewCoursesNewsletterCommand command) {
		sender.send();
	}
}
