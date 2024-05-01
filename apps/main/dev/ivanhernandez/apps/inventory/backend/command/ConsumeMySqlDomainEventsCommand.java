package dev.ivanhernandez.apps.inventory.backend.command;

import dev.ivanhernandez.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import dev.ivanhernandez.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {

	private final MySqlDomainEventsConsumer consumer;

	public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void execute(String[] args) {
		consumer.consume();
	}
}
