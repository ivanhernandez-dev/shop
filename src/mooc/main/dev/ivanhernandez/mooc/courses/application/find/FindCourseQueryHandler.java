package dev.ivanhernandez.mooc.courses.application.find;

import dev.ivanhernandez.mooc.courses.application.CourseResponse;
import dev.ivanhernandez.mooc.courses.domain.CourseId;
import dev.ivanhernandez.mooc.courses.domain.CourseNotExist;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

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
