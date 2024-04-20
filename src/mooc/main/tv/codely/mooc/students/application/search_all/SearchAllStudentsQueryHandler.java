package tv.codely.mooc.students.application.search_all;

import tv.codely.mooc.students.application.StudentsResponse;
import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.query.QueryHandler;

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
