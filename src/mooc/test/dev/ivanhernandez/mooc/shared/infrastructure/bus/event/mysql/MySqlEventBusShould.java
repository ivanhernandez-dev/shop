package dev.ivanhernandez.mooc.shared.infrastructure.bus.event.mysql;

import dev.ivanhernandez.mooc.MoocContextInfrastructureTestCase;
import dev.ivanhernandez.mooc.courses.domain.CourseCreatedDomainEventMother;
import dev.ivanhernandez.shared.domain.course.CourseCreatedDomainEvent;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

@Transactional
class MySqlEventBusShould extends MoocContextInfrastructureTestCase {
	@Autowired
	private MySqlEventBus eventBus;
	@Autowired
	private MySqlDomainEventsConsumer consumer;

	@Test
	void publish_and_consume_domain_events_from_msql() throws InterruptedException {
		CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

		eventBus.publish(Collections.singletonList(domainEvent));

		Thread consumerProcess = new Thread(() -> consumer.consume());
		consumerProcess.start();

		Thread.sleep(100);

		consumer.stop();
	}
}
