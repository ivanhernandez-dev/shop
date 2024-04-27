package dev.ivanhernandez.inventory;

import dev.ivanhernandez.apps.inventory.backend.InventoryBackendApplication;
import dev.ivanhernandez.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = InventoryBackendApplication.class)
@SpringBootTest
public abstract class InventoryContextInfrastructureTestCase extends InfrastructureTestCase {
}
