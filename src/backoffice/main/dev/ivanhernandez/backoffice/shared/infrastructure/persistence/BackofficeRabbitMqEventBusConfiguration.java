package dev.ivanhernandez.backoffice.shared.infrastructure.persistence;

import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackofficeRabbitMqEventBusConfiguration {
	private final RabbitMqPublisher publisher;
	private final MySqlEventBus failoverPublisher;

	public BackofficeRabbitMqEventBusConfiguration(
		RabbitMqPublisher publisher,
		@Qualifier("backofficeMysqlEventBus") MySqlEventBus failoverPublisher
	) {
		this.publisher = publisher;
		this.failoverPublisher = failoverPublisher;
	}

	@Bean
	public RabbitMqEventBus backofficeRabbitMqEventBus() {
		return new RabbitMqEventBus(publisher, failoverPublisher);
	}
}
