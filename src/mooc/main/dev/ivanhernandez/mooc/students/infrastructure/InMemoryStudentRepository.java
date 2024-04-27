package dev.ivanhernandez.mooc.students.infrastructure;

import dev.ivanhernandez.mooc.students.domain.Student;
import dev.ivanhernandez.mooc.students.domain.StudentId;
import dev.ivanhernandez.mooc.students.domain.StudentRepository;
import dev.ivanhernandez.shared.domain.Component;
import dev.ivanhernandez.shared.domain.UuidGenerator;

import java.util.Arrays;
import java.util.List;

@Component
public final class InMemoryStudentRepository implements StudentRepository {
	private UuidGenerator generator;

	public InMemoryStudentRepository(UuidGenerator generator) {
		this.generator = generator;
	}

	@Override
	public List<Student> searchAll() {
		return Arrays.asList(
			new Student(new StudentId(generator.generate()), "name", "surname", "email@mail.com"),
			new Student(new StudentId(generator.generate()), "Other name", "Other surname", "another@mail.com")
		);
	}
}
