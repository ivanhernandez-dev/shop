package dev.ivanhernandez.apps.inventory.backend.controller.health_check;

import dev.ivanhernandez.apps.inventory.InventoryApplicationTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerShould extends InventoryApplicationTestCase {
	@Test
	void check_the_app_is_working_ok() throws Exception {
		assertResponse("/health-check", 200, "{'application':'inventory_backend','status':'ok'}");
	}
}
