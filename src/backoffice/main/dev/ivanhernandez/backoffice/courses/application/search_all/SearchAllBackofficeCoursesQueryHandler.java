package dev.ivanhernandez.backoffice.courses.application.search_all;

import dev.ivanhernandez.backoffice.courses.application.BackofficeCoursesResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class SearchAllBackofficeCoursesQueryHandler implements QueryHandler<SearchAllBackofficeCoursesQuery, BackofficeCoursesResponse> {
	private final AllBackofficeCoursesSearcher searcher;

	public SearchAllBackofficeCoursesQueryHandler(AllBackofficeCoursesSearcher searcher) {
		this.searcher = searcher;
	}

	@Override
	public BackofficeCoursesResponse handle(SearchAllBackofficeCoursesQuery query) {
		return searcher.search();
	}
}
