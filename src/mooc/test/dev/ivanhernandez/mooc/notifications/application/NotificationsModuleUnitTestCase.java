package dev.ivanhernandez.mooc.notifications.application;

import dev.ivanhernandez.mooc.notifications.domain.Email;
import dev.ivanhernandez.mooc.notifications.domain.EmailSender;
import dev.ivanhernandez.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public abstract class NotificationsModuleUnitTestCase extends UnitTestCase {
	protected EmailSender sender;

	@BeforeEach
	protected void setUp() {
		super.setUp();

		sender = mock(EmailSender.class);
	}

	public void shouldHaveSentEmail(Email email) {
		ArgumentCaptor<Email> argument = ArgumentCaptor.forClass(Email.class);

		verify(sender, atLeastOnce()).send(argument.capture());

		List<Email> emails = argument.getAllValues();

		assertTrue(emails.contains(email));
	}
}
