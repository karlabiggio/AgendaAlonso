package org.student.domain;

import java.util.List;

public interface StudentRepository {
    void add(Student student);
    void delete(String name);
    void update(String oldName, String newName);
    List<Student> obtains();
    Student getStudent(String name);
}

