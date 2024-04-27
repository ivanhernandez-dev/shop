package dev.ivanhernandez.apps.backoffice.backend;

import dev.ivanhernandez.shared.domain.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
	value = {"dev.ivanhernandez.shared", "dev.ivanhernandez.backoffice", "dev.ivanhernandez.apps.backoffice.backend"}
)
public class BackofficeBackendApplication {

	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
			}
		};
	}
}
