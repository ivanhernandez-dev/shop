package dev.ivanhernandez.apps.mooc.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import dev.ivanhernandez.apps.mooc.backend.command.ConsumeMySqlDomainEventsCommand;
import dev.ivanhernandez.apps.mooc.backend.command.ConsumeRabbitMqDomainEventsCommand;
import dev.ivanhernandez.shared.domain.Component;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
	value = {"dev.ivanhernandez.shared", "dev.ivanhernandez.mooc", "dev.ivanhernandez.apps.mooc.backend"}
)
public class MoocBackendApplication {

	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
				put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
				put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
			}
		};
	}
}
