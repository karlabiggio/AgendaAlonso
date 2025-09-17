package org.student.data;

import org.student.domain.Student;

import java.util.List;

public interface StudentData {
    public void save(Student student);
    public void saveList(List<Student> studentList);
    public Student findByName(String name);
    public List<Student> findAll();
    public void delete(String modelId);
}
