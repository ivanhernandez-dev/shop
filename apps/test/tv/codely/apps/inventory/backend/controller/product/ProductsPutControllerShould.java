package tv.codely.apps.inventory.backend.controller.product;

import org.junit.jupiter.api.Test;
import tv.codely.apps.inventory.InventoryApplicationTestCase;

final public class ProductsPutControllerShould extends InventoryApplicationTestCase {
	@Test
	void create_a_valid_non_existing_product() throws Exception {
		assertRequestWithBody(
			"PUT",
			"/products/1aab45ba-3c7a-4344-8936-78466eca77fa",
			"{\"name\": \"The best product\", \"price\": 100}",
			201
		);
	}
}
