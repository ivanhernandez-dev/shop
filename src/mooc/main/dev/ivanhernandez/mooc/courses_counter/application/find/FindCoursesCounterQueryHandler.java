package dev.ivanhernandez.mooc.courses_counter.application.find;

import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.bus.query.QueryHandler;

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
