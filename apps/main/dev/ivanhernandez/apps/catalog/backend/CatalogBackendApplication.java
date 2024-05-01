package dev.ivanhernandez.apps.catalog.backend;

import dev.ivanhernandez.shared.domain.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Component.class),
	value = {"dev.ivanhernandez.shared", "dev.ivanhernandez.catalog", "dev.ivanhernandez.apps.catalog.backend"}
)
public class CatalogBackendApplication {
	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
			}
		};
	}
}
