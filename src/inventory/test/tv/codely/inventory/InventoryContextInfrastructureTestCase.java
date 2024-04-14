package tv.codely.inventory;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.inventory.backend.InventoryBackendApplication;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = InventoryBackendApplication.class)
@SpringBootTest
public abstract class InventoryContextInfrastructureTestCase extends InfrastructureTestCase {
}
