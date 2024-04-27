package dev.ivanhernandez.inventory.shared.infrastructure.persistence;

import dev.ivanhernandez.shared.infrastructure.config.Parameter;
import dev.ivanhernandez.shared.infrastructure.config.ParameterNotExist;
import dev.ivanhernandez.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class InventoryHibernateConfiguration {
	private final HibernateConfigurationFactory factory;
	private final Parameter config;
	private final String CONTEXT_NAME = "inventory";

	public InventoryHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
		this.factory = factory;
		this.config = config;
	}

	@Bean("inventory-transaction_manager")
	public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
		return factory.hibernateTransactionManager(sessionFactory());
	}

	@Bean("inventory-session_factory")
	public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
		return factory.sessionFactory(CONTEXT_NAME, dataSource());
	}

	@Bean("inventory-data_source")
	public DataSource dataSource() throws IOException, ParameterNotExist {
		return factory.dataSource(
			config.get("INVENTORY_DATABASE_HOST"),
			config.getInt("INVENTORY_DATABASE_PORT"),
			config.get("INVENTORY_DATABASE_NAME"),
			config.get("INVENTORY_DATABASE_USER"),
			config.get("INVENTORY_DATABASE_PASSWORD")
		);
	}
}
