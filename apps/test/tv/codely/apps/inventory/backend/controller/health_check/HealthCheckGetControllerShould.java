package tv.codely.apps.inventory.backend.controller.health_check;

import org.junit.jupiter.api.Test;
import tv.codely.apps.inventory.InventoryApplicationTestCase;

final class HealthCheckGetControllerShould extends InventoryApplicationTestCase {
	@Test
	void check_the_app_is_working_ok() throws Exception {
		assertResponse("/health-check", 200, "{'application':'inventory_backend','status':'ok'}");
	}
}
