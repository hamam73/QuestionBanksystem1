package com.portflioproject.service;

import com.portfolioproject.model.Question;
import com.portfolioproject.model.Student;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public final class SearchService {
    private SearchService() {}

    public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
        return items.stream().filter(predicate).toList();
    }

    public static List<Question> searchQuestions(List<Question> questions, String keyword) {
        String kw = keyword == null ? "" : keyword.toLowerCase(Locale.ROOT);
        return filter(questions, q ->
                q.getText().toLowerCase(Locale.ROOT).contains(kw) ||
                q.getSubject().toLowerCase(Locale.ROOT).contains(kw));
    }

    public static List<Student> searchStudents(List<Student> students, String keyword) {
        String kw = keyword == null ? "" : keyword.toLowerCase(Locale.ROOT);
        return filter(students, s ->
                s.getName().toLowerCase(Locale.ROOT).contains(kw) ||
                s.getId().toLowerCase(Locale.ROOT).contains(kw));
    }

    public static <T> Optional<T> findFirst(List<T> items, Predicate<T> predicate) {
        return items.stream().filter(predicate).findFirst();
    }
}