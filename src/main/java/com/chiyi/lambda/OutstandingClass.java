package com.chiyi.lambda;

import java.util.List;

public class OutstandingClass {
    private String name;
    private List<Student> students;

    public OutstandingClass() {
    }

    public OutstandingClass(String name, List<Student> studentList) {
        this.name=name;
        this.students = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
