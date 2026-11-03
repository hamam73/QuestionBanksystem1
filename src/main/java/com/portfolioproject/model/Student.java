package com.portfolioproject.model;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String id;
    private String name;

    public Student() {}
    public Student(String id, String name) { this.id = id; this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public int compareTo(Student other) {
        int byName = this.name.compareTo(other.name);
        return byName != 0 ? byName : this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student s)) return false;
        return Objects.equals(id, s.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() { return "Student{" + id + ", '" + name + "'}"; }
}