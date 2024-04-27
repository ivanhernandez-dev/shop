package dev.ivanhernandez.mooc.students.application;

import dev.ivanhernandez.mooc.students.domain.StudentId;
import dev.ivanhernandez.mooc.students.domain.StudentIdMother;
import dev.ivanhernandez.shared.domain.EmailMother;
import dev.ivanhernandez.shared.domain.WordMother;

public final class StudentResponseMother {
	public static StudentResponse create(StudentId id, String name, String surname, String email) {
		return new StudentResponse(id.value(), name, surname, email);
	}

	public static StudentResponse random() {
		return create(StudentIdMother.random(), WordMother.random(), WordMother.random(), EmailMother.random());
	}
}
