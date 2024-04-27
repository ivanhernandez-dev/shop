package dev.ivanhernandez.apps.inventory.backend.controller.product;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import dev.ivanhernandez.apps.inventory.InventoryApplicationTestCase;

@Transactional
public class ProductsPutControllerShould extends InventoryApplicationTestCase {
	@Test
	void create_a_valid_non_existing_product() throws Exception {
		assertRequestWithBody(
			"PUT",
			"/products/1aab45ba-3c7a-4344-8936-78466eca77fa",
			"{\"name\": \"The best product\", \"description\": \"The best product description\", \"price\": \"100\", \"weight\": 200, \"color\": \"red\", \"material\": \"wood\", \"categoryId\": \"8b3342ed-6544-4abe-8a94-76b530f37a42\"}",
			201
		);
	}
}
