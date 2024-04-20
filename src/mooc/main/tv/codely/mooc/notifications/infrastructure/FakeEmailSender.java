package tv.codely.mooc.notifications.infrastructure;

import tv.codely.mooc.notifications.domain.Email;
import tv.codely.mooc.notifications.domain.EmailSender;
import tv.codely.shared.domain.Component;

@Component
public final class FakeEmailSender implements EmailSender {
	@Override
	public void send(Email email) {
		// In the future...
	}
}
