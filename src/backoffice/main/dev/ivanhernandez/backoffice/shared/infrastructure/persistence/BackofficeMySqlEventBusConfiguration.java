package dev.ivanhernandez.backoffice.shared.infrastructure.persistence;

import dev.ivanhernandez.shared.infrastructure.bus.event.DomainEventsInformation;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackofficeMySqlEventBusConfiguration {
	private final SessionFactory sessionFactory;
	private final DomainEventsInformation domainEventsInformation;
	private final SpringApplicationEventBus bus;

	public BackofficeMySqlEventBusConfiguration(
		@Qualifier("backoffice-session_factory") SessionFactory sessionFactory,
		DomainEventsInformation domainEventsInformation,
		SpringApplicationEventBus bus
	) {
		this.sessionFactory = sessionFactory;
		this.domainEventsInformation = domainEventsInformation;
		this.bus = bus;
	}

	@Bean
	public MySqlEventBus backofficeMysqlEventBus() {
		return new MySqlEventBus(sessionFactory);
	}

	@Bean
	public MySqlDomainEventsConsumer backofficeMySqlDomainEventsConsumer() {
		return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
	}
}