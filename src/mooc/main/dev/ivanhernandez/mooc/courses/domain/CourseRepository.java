package dev.ivanhernandez.mooc.courses.domain;

import dev.ivanhernandez.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
	void save(Course course);

	Optional<Course> search(CourseId id);

	List<Course> matching(Criteria criteria);
}
