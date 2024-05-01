package dev.ivanhernandez.apps.inventory.backend;

import dev.ivanhernandez.apps.inventory.backend.command.ConsumeMySqlDomainEventsCommand;
import dev.ivanhernandez.apps.inventory.backend.command.ConsumeRabbitMqDomainEventsCommand;
import dev.ivanhernandez.shared.domain.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
	value = {"dev.ivanhernandez.shared", "dev.ivanhernandez.inventory", "dev.ivanhernandez.apps.inventory.backend"}
)
public class InventoryBackendApplication {
	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
				put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
				put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
			}
		};
	}
}
