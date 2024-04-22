package tv.codely.inventory.stocks.infrastructure.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.inventory.products.domain.Product;
import tv.codely.inventory.products.domain.ProductId;
import tv.codely.inventory.shelves.domain.ShelfId;
import tv.codely.inventory.stocks.domain.Stock;
import tv.codely.inventory.stocks.domain.StockRepository;
import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.domain.criteria.Filters;
import tv.codely.shared.domain.criteria.Order;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		HashMap<String, String> productIdFilter = new HashMap<>();
		productIdFilter.put("field", "productId");
		productIdFilter.put("value", productId.value());
		productIdFilter.put("operator", "=");

		HashMap<String, String> shelfIdFilter = new HashMap<>();
		shelfIdFilter.put("field", "shelfId");
		shelfIdFilter.put("value", shelfId.value());
		shelfIdFilter.put("operator", "=");

		Criteria criteria = new Criteria(
			Filters.fromValues(
				List.of(
					productIdFilter,
					shelfIdFilter
				)),
			Order.none(),
			Optional.empty(),
			Optional.empty()
		);

		List<Stock> stocks = super.byCriteria(criteria);

		return stocks.isEmpty() ? Optional.empty() : Optional.of(stocks.get(0));
	}

	@Override
	public void update(Stock stock) {
		super.update(stock);
	}

	@Override
	public void delete(ProductId productId, ShelfId shelfId) {
		Session session = sessionFactory.getCurrentSession();

		Stock recordToBeDeleted = this.search(productId, shelfId).orElseThrow();

		session.delete(recordToBeDeleted);
	}
}
