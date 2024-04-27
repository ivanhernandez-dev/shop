package dev.ivanhernandez.backoffice.courses.application.create;

import dev.ivanhernandez.backoffice.courses.domain.BackofficeCourse;
import dev.ivanhernandez.backoffice.courses.domain.BackofficeCourseRepository;
import dev.ivanhernandez.shared.domain.Component;

@Component
public final class BackofficeCourseCreator {
	private final BackofficeCourseRepository repository;

	public BackofficeCourseCreator(BackofficeCourseRepository repository) {
		this.repository = repository;
	}

	public void create(String id, String name, String duration) {
		this.repository.save(new BackofficeCourse(id, name, duration));
	}
}
