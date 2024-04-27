package dev.ivanhernandez.mooc.steps.infrastructure.persistence;

import dev.ivanhernandez.mooc.steps.domain.Step;
import dev.ivanhernandez.mooc.steps.domain.StepId;
import dev.ivanhernandez.mooc.steps.domain.StepRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional("mooc-transaction_manager")
public class MySqlStepRepository extends HibernateRepository<Step> implements StepRepository {
	public MySqlStepRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Step.class);
	}

	@Override
	public void save(Step step) {
		persist(step);
	}

	@Override
	public Optional<? extends Step> search(StepId id) {
		return byId(id);
	}
}
