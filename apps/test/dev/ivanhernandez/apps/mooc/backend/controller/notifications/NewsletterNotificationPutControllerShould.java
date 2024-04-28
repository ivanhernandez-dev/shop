package dev.ivanhernandez.apps.mooc.backend.controller.notifications;

import dev.ivanhernandez.apps.mooc.MoocApplicationTestCase;
import org.junit.jupiter.api.Test;

final class NewsletterNotificationPutControllerShould extends MoocApplicationTestCase {

	@Test
	void create_a_valid_non_existing_course() throws Exception {
		assertRequest("PUT", "/newsletter/6eebbe60-50e7-400a-810c-3e0af0943ee6", 201);
	}
}