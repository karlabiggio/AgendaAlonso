package org.student.domain;

public class Student {
    private String name;
    private final int fileNumber;

    public Student(String name, int fileNumber) {
        this.name = name;
        this.fileNumber = fileNumber;
    }

    public String getName() {
        return name;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fileNumber=" + fileNumber +
                '}';
    }
}
