package dev.ivanhernandez.inventory.stocks.infrastructure.persistence;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import dev.ivanhernandez.inventory.shared.domain.ProductId;
import dev.ivanhernandez.inventory.shared.domain.ShelfId;
import dev.ivanhernandez.inventory.stocks.domain.Stock;
import dev.ivanhernandez.inventory.stocks.domain.StockRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Primary
@Component
@Transactional
public class MysqlStockRepository extends HibernateRepository<Stock> implements StockRepository {
	MysqlStockRepository(@Qualifier("inventory-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Stock.class);
	}


	@Override
	public void save(Stock stock) {
		super.persist(stock);
	}

	@Override
	public Optional<Stock> search(ProductId productId, ShelfId shelfId) {
		try {
			CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
			CriteriaQuery<Stock> query = builder.createQuery(Stock.class);
			Root<Stock> root = query.from(Stock.class);

			Predicate predicate = builder.and(
				builder.equal(root.get("productId"), productId),
				builder.equal(root.get("shelfId"), shelfId)
			);

			query.select(root).where(predicate);

			return Optional.of(sessionFactory.getCurrentSession().createQuery(query).getSingleResult());
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public void delete(ProductId productId, ShelfId shelfId) {
		Session session = sessionFactory.getCurrentSession();

		Stock stock = search(productId, shelfId).orElseThrow();

		session.delete(stock);
	}

	@Override
	public void update(Stock stock) {
		super.update(stock);
	}
}
