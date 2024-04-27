package dev.ivanhernandez.apps.mooc.backend.command;

import dev.ivanhernandez.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeRabbitMqDomainEventsCommand extends ConsoleCommand {

	private final RabbitMqDomainEventsConsumer consumer;

	public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void execute(String[] args) {
		consumer.consume();
	}
}
