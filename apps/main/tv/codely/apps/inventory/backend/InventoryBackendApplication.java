package tv.codely.apps.inventory.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
	value = { "tv.codely.shared", "tv.codely.inventory", "tv.codely.apps.inventory.backend" }
)
public class InventoryBackendApplication {
	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{}
		};
	}
}
