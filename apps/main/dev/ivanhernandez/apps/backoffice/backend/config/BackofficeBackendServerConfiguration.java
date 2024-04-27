package dev.ivanhernandez.apps.backoffice.backend.config;

import dev.ivanhernandez.apps.backoffice.backend.middleware.BasicHttpAuthMiddleware;
import dev.ivanhernandez.shared.domain.bus.command.CommandBus;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackofficeBackendServerConfiguration {

	private final CommandBus bus;

	public BackofficeBackendServerConfiguration(CommandBus bus) {
		this.bus = bus;
	}

	@Bean
	public FilterRegistrationBean<BasicHttpAuthMiddleware> basicHttpAuthMiddleware() {
		FilterRegistrationBean<BasicHttpAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new BasicHttpAuthMiddleware(bus));
		registrationBean.addUrlPatterns("/health-check");

		return registrationBean;
	}
}
