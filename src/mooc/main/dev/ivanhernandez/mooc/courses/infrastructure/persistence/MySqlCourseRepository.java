package dev.ivanhernandez.mooc.courses.infrastructure.persistence;

import dev.ivanhernandez.mooc.courses.domain.Course;
import dev.ivanhernandez.mooc.courses.domain.CourseId;
import dev.ivanhernandez.mooc.courses.domain.CourseRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.criteria.Criteria;
import dev.ivanhernandez.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional("mooc-transaction_manager")
public class MySqlCourseRepository extends HibernateRepository<Course> implements CourseRepository {
	public MySqlCourseRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Course.class);
	}

	@Override
	public void save(Course course) {
		persist(course);
	}

	@Override
	public Optional<Course> search(CourseId id) {
		return byId(id);
	}

	@Override
	public List<Course> matching(Criteria criteria) {
		return byCriteria(criteria);
	}
}
