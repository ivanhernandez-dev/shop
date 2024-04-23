package tv.codely.inventory.stocks.infrastructure.persistence;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.shelves.domain.ShelfId;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockRepository;
import tv.codely.shared.domain.Component;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Primary
@Component
@Transactional("inventory-transaction_manager")
public class MySqlStockRepository extends HibernateRepository<Stock> implements StockRepository {
	public MySqlStockRepository(@Qualifier("inventory-session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Stock.class);
	}

	@Override
	public void save(Stock stock) {
		super.persist(stock);
	}

	@Override
	public Optional<Stock> search(ProductId productId, ShelfId shelfId) {
		try {
			CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
			CriteriaQuery<Stock> query = criteriaBuilder.createQuery(Stock.class);
			Root<Stock> root = query.from(Stock.class);

			Predicate predicate = criteriaBuilder.conjunction();
			predicate = criteriaBuilder.and(
				predicate,
				criteriaBuilder.equal(root.get("shelf").get("id"), shelfId),
				criteriaBuilder.equal(root.get("product").get("id"), productId)
			);

			query.select(root).where(predicate);

			return Optional.ofNullable(this.sessionFactory.getCurrentSession().createQuery(query).getSingleResult());
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public void update(Stock stock) {
		super.update(stock);
	}

	@Override
	public void delete(ProductId productId, ShelfId shelfId) {
		Session session = this.sessionFactory.getCurrentSession();

		Stock recordToBeDeleted = this.search(productId, shelfId).orElseThrow();

		session.delete(recordToBeDeleted);
	}
}
