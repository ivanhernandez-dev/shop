package dev.ivanhernandez.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import dev.ivanhernandez.apps.backoffice.frontend.BackofficeFrontendApplication;
import dev.ivanhernandez.backoffice.courses.ElasticsearchEnvironmentArranger;
import dev.ivanhernandez.shared.infrastructure.InfrastructureTestCase;

import java.io.IOException;

@ContextConfiguration(classes = BackofficeFrontendApplication.class)
@SpringBootTest
public abstract class BackofficeContextInfrastructureTestCase extends InfrastructureTestCase {
	@Autowired
	private ElasticsearchEnvironmentArranger elasticsearchArranger;

	protected void clearElasticsearch() throws IOException {
		elasticsearchArranger.arrange("backoffice", "backoffice_courses");
	}
}
