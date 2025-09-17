package org.student.domain;

public class DeleteStudentUseCase {
    private final StudentRepository repository;

    public DeleteStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public void execute(String name) {
        repository.delete(name);
    }
}
