package dev.ivanhernandez.backoffice.courses.application.search_by_criteria;

import dev.ivanhernandez.backoffice.courses.application.BackofficeCoursesResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;
import dev.ivanhernandez.shared.domain.criteria.Filters;
import dev.ivanhernandez.shared.domain.criteria.Order;

@Component
public final class SearchBackofficeCoursesByCriteriaQueryHandler implements QueryHandler<SearchBackofficeCoursesByCriteriaQuery, BackofficeCoursesResponse> {
	private final BackofficeCoursesByCriteriaSearcher searcher;

	public SearchBackofficeCoursesByCriteriaQueryHandler(BackofficeCoursesByCriteriaSearcher searcher) {
		this.searcher = searcher;
	}

	@Override
	public BackofficeCoursesResponse handle(SearchBackofficeCoursesByCriteriaQuery query) {
		Filters filters = Filters.fromValues(query.filters());
		Order order = Order.fromValues(query.orderBy(), query.orderType());

		return searcher.search(filters, order, query.limit(), query.offset());
	}
}
