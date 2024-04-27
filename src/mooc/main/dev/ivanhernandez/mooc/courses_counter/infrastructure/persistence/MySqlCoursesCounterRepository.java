package dev.ivanhernandez.mooc.courses_counter.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounter;
import dev.ivanhernandez.mooc.courses_counter.domain.CoursesCounterRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Component
@Transactional("mooc-transaction_manager")
public class MySqlCoursesCounterRepository extends HibernateRepository<CoursesCounter> implements CoursesCounterRepository {
	public MySqlCoursesCounterRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, CoursesCounter.class);
	}

	@Override
	public void save(CoursesCounter counter) {
		persist(counter);
	}

	@Override
	public Optional<CoursesCounter> search() {
		List<CoursesCounter> coursesCounter = all();

		return 0 == coursesCounter.size() ? Optional.empty() : Optional.ofNullable(coursesCounter.get(0));
	}
}
