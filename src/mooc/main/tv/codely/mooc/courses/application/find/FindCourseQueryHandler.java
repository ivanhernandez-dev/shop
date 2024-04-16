package tv.codely.mooc.courses.application.find;

import tv.codely.mooc.courses.application.CourseResponse;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseNotExist;
import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Component
public final class FindCourseQueryHandler implements QueryHandler<FindCourseQuery, CourseResponse> {
    private final CourseFinder finder;

    public FindCourseQueryHandler(CourseFinder finder) {
        this.finder = finder;
    }

    @Override
    public CourseResponse handle(FindCourseQuery query) throws CourseNotExist {
        return finder.find(new CourseId(query.id()));
    }
}
