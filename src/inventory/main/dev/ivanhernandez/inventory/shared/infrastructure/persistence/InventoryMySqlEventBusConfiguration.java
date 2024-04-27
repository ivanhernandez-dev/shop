package dev.ivanhernandez.inventory.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dev.ivanhernandez.shared.infrastructure.bus.event.DomainEventsInformation;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;

@Configuration
public class InventoryMySqlEventBusConfiguration {
	private final SessionFactory sessionFactory;
	private final DomainEventsInformation domainEventsInformation;
	private final SpringApplicationEventBus bus;

	public InventoryMySqlEventBusConfiguration(
		@Qualifier("inventory-session_factory") SessionFactory sessionFactory,
		DomainEventsInformation domainEventsInformation,
		SpringApplicationEventBus bus
	) {
		this.sessionFactory = sessionFactory;
		this.domainEventsInformation = domainEventsInformation;
		this.bus = bus;
	}

	@Bean
	public MySqlEventBus inventoryMysqlEventBus() {
		return new MySqlEventBus(sessionFactory);
	}

	@Bean
	public MySqlDomainEventsConsumer inventoryMySqlDomainEventsConsumer() {
		return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
	}
}
