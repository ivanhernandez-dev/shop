package dev.ivanhernandez.mooc.shared.infrastructure.persistence;

import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoocRabbitMqEventBusConfiguration {
	private final RabbitMqPublisher publisher;
	private final MySqlEventBus failoverPublisher;

	public MoocRabbitMqEventBusConfiguration(
		RabbitMqPublisher publisher,
		@Qualifier("moocMysqlEventBus") MySqlEventBus failoverPublisher
	) {
		this.publisher = publisher;
		this.failoverPublisher = failoverPublisher;
	}

	@Bean
	public RabbitMqEventBus moocRabbitMqEventBus() {
		return new RabbitMqEventBus(publisher, failoverPublisher);
	}
}
