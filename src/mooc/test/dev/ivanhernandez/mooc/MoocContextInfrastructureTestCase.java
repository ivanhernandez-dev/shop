package dev.ivanhernandez.mooc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import dev.ivanhernandez.apps.mooc.backend.MoocBackendApplication;
import dev.ivanhernandez.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = MoocBackendApplication.class)
@SpringBootTest
public abstract class MoocContextInfrastructureTestCase extends InfrastructureTestCase {
}
