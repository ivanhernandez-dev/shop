package dev.ivanhernandez.apps.inventory.backend.controller.category;

import dev.ivanhernandez.apps.inventory.InventoryApplicationTestCase;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Transactional
class CategoryGetControllerShould extends InventoryApplicationTestCase {
	@Test
	void find_an_existing_category() throws Exception {
		String id = "8b3342ed-6544-4abe-8a94-76b530f37a42";
		String body = "{\"id\": \"8b3342ed-6544-4abe-8a94-76b530f37a42\", \"name\": \"Category 1\"}";

		assertResponse(String.format("/categories/%s", id), HttpStatus.OK.value(), body);
	}

	@Test
	void throw_an_exception_when_category_does_not_exists() throws Exception {
		String id = "8b3342ed-6544-4abe-8a94-76b530f37a43";
		String body = "{\"error_code\": \"category_not_exist\", \"message\": \"The category <8b3342ed-6544-4abe-8a94-76b530f37a43> does not exist\"}";

		assertResponse(String.format("/categories/%s", id), HttpStatus.NOT_FOUND.value(), body);
	}
}
