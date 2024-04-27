package dev.ivanhernandez.inventory;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import dev.ivanhernandez.apps.inventory.backend.InventoryBackendApplication;
import dev.ivanhernandez.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = InventoryBackendApplication.class)
@SpringBootTest
public abstract class InventoryContextInfrastructureTestCase extends InfrastructureTestCase {
}
