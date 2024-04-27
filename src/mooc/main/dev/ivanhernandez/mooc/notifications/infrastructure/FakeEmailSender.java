package dev.ivanhernandez.mooc.notifications.infrastructure;

import dev.ivanhernandez.mooc.notifications.domain.Email;
import dev.ivanhernandez.mooc.notifications.domain.EmailSender;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class FakeEmailSender implements EmailSender {
	@Override
	public void send(Email email) {
		// In the future...
	}
}
