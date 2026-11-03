package com.portfolioproject.repository;

import com.portfolioproject.model.Student;

public class StudentRepository extends InMemoryRepository<Student, String> {
    @Override
    protected String getId(Student s) { return s.getId(); }
}