package tv.codely.mooc.courses_counter.application.find;

import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Component
public final class FindCoursesCounterQueryHandler implements QueryHandler<FindCoursesCounterQuery, CoursesCounterResponse> {
    private final CoursesCounterFinder finder;

    public FindCoursesCounterQueryHandler(CoursesCounterFinder finder) {
        this.finder = finder;
    }

    @Override
    public CoursesCounterResponse handle(FindCoursesCounterQuery query) {
        return finder.find();
    }
}
