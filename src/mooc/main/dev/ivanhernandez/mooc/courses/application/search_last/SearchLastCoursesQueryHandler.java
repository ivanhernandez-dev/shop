package dev.ivanhernandez.mooc.courses.application.search_last;

import dev.ivanhernandez.mooc.courses.application.CoursesResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class SearchLastCoursesQueryHandler implements QueryHandler<SearchLastCoursesQuery, CoursesResponse> {
	private final LastCoursesSearcher searcher;

	public SearchLastCoursesQueryHandler(LastCoursesSearcher searcher) {
		this.searcher = searcher;
	}

	@Override
	public CoursesResponse handle(SearchLastCoursesQuery query) {
		return searcher.search(query.total());
	}
}
