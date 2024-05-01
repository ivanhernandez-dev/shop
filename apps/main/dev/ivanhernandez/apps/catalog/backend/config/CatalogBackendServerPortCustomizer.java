package dev.ivanhernandez.apps.catalog.backend.config;

import dev.ivanhernandez.shared.infrastructure.config.Parameter;
import dev.ivanhernandez.shared.infrastructure.config.ParameterNotExist;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public final class CatalogBackendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	private final Parameter param;

	public CatalogBackendServerPortCustomizer(Parameter param) {
		this.param = param;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		try {
			factory.setPort(param.getInt("CATALOG_BACKEND_SERVER_PORT"));
		} catch (ParameterNotExist parameterNotExist) {
			parameterNotExist.printStackTrace();
		}
	}
}
