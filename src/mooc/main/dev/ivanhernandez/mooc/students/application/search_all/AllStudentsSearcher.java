package dev.ivanhernandez.mooc.students.application.search_all;

import dev.ivanhernandez.mooc.students.application.StudentResponse;
import dev.ivanhernandez.mooc.students.application.StudentsResponse;
import dev.ivanhernandez.mooc.students.domain.StudentRepository;
import dev.ivanhernandez.shared.domain.Component;

import java.util.stream.Collectors;

@Component
public final class AllStudentsSearcher {
	private final StudentRepository repository;

	public AllStudentsSearcher(StudentRepository repository) {
		this.repository = repository;
	}

	public StudentsResponse search() {
		return new StudentsResponse(
			repository.searchAll().stream().map(StudentResponse::fromAggregate).collect(Collectors.toList())
		);
	}
}
