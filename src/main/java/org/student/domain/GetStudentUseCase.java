package org.student.domain;


public class GetStudentUseCase {
    private final StudentRepository repository;

    public GetStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Student execute(String name) {
        return repository.getStudent(name);
    }
}
