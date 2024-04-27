package dev.ivanhernandez.mooc.students.domain;

import java.util.List;

public interface StudentRepository {
	List<Student> searchAll();
}
