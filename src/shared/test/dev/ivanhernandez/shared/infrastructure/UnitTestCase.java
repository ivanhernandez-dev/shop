package dev.ivanhernandez.shared.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import dev.ivanhernandez.shared.domain.UuidGenerator;
import dev.ivanhernandez.shared.domain.bus.event.DomainEvent;
import dev.ivanhernandez.shared.domain.bus.event.EventBus;
import dev.ivanhernandez.shared.domain.bus.query.Query;
import dev.ivanhernandez.shared.domain.bus.query.QueryBus;
import dev.ivanhernandez.shared.domain.bus.query.Response;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {
	protected EventBus eventBus;
	protected QueryBus queryBus;
	protected UuidGenerator uuidGenerator;

	@BeforeEach
	protected void setUp() {
		eventBus = mock(EventBus.class);
		queryBus = mock(QueryBus.class);
		uuidGenerator = mock(UuidGenerator.class);
	}

	public void shouldHavePublished(List<DomainEvent> domainEvents) {
		verify(eventBus, atLeastOnce()).publish(domainEvents);
	}

	public void shouldHavePublished(DomainEvent domainEvent) {
		shouldHavePublished(Collections.singletonList(domainEvent));
	}

	public void shouldGenerateUuid(String uuid) {
		when(uuidGenerator.generate()).thenReturn(uuid);
	}

	public void shouldGenerateUuids(String uuid, String... others) {
		when(uuidGenerator.generate()).thenReturn(uuid, others);
	}

	public void shouldAsk(Query query, Response response) {
		when(queryBus.ask(query)).thenReturn(response);
	}
}
