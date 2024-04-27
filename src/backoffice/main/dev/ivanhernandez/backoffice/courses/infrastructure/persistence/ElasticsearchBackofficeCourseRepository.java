package dev.ivanhernandez.backoffice.courses.infrastructure.persistence;

import org.springframework.context.annotation.Primary;
import dev.ivanhernandez.backoffice.courses.domain.BackofficeCourse;
import dev.ivanhernandez.backoffice.courses.domain.BackofficeCourseRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.criteria.Criteria;
import dev.ivanhernandez.shared.infrastructure.elasticsearch.ElasticsearchClient;
import dev.ivanhernandez.shared.infrastructure.elasticsearch.ElasticsearchRepository;

import java.util.List;

@Primary
@Component
public final class ElasticsearchBackofficeCourseRepository extends ElasticsearchRepository<BackofficeCourse> implements BackofficeCourseRepository {
	public ElasticsearchBackofficeCourseRepository(ElasticsearchClient client) {
		super(client);
	}

	@Override
	public void save(BackofficeCourse course) {
		persist(course.id(), course.toPrimitives());
	}

	@Override
	public List<BackofficeCourse> searchAll() {
		return searchAllInElastic(BackofficeCourse::fromPrimitives);
	}

	@Override
	public List<BackofficeCourse> matching(Criteria criteria) {
		return searchByCriteria(criteria, BackofficeCourse::fromPrimitives);
	}

	@Override
	protected String moduleName() {
		return "courses";
	}
}
