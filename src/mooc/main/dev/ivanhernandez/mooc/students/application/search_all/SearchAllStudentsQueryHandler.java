package dev.ivanhernandez.mooc.students.application.search_all;

import dev.ivanhernandez.mooc.students.application.StudentsResponse;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

@Component
public final class SearchAllStudentsQueryHandler implements QueryHandler<SearchAllStudentsQuery, StudentsResponse> {
	private final AllStudentsSearcher searcher;

	public SearchAllStudentsQueryHandler(AllStudentsSearcher searcher) {
		this.searcher = searcher;
	}

	@Override
	public StudentsResponse handle(SearchAllStudentsQuery query) {
		return searcher.search();
	}
}
