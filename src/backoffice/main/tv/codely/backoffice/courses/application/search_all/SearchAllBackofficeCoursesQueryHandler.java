package tv.codely.backoffice.courses.application.search_all;

import tv.codely.backoffice.courses.application.BackofficeCoursesResponse;
import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.query.QueryHandler;

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
