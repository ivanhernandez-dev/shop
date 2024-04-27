package dev.ivanhernandez.apps.backoffice.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import dev.ivanhernandez.shared.domain.Component;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
	value = {"dev.ivanhernandez.shared", "dev.ivanhernandez.backoffice", "dev.ivanhernandez.mooc", "dev.ivanhernandez.apps.backoffice.frontend"}
)
public class BackofficeFrontendApplication {

	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
			}
		};
	}
}
