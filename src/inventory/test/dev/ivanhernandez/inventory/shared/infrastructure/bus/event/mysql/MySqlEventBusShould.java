package dev.ivanhernandez.inventory.shared.infrastructure.bus.event.mysql;

import dev.ivanhernandez.inventory.category.domain.CategoryCreatedDomainEventMother;
import dev.ivanhernandez.shared.domain.category.CategoryCreatedDomainEvent;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import dev.ivanhernandez.inventory.InventoryContextInfrastructureTestCase;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;

import java.util.Collections;

@Transactional
class MySqlEventBusShould extends InventoryContextInfrastructureTestCase {
    @Autowired
    private MySqlEventBus             eventBus;
    @Autowired
    private MySqlDomainEventsConsumer consumer;

    @Test
    void publish_and_consume_domain_events_from_msql() throws InterruptedException {
        CategoryCreatedDomainEvent domainEvent = CategoryCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        Thread consumerProcess = new Thread(() -> consumer.consume());
        consumerProcess.start();

        Thread.sleep(100);

        consumer.stop();
    }
}
