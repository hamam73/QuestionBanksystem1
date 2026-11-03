package com.portfolioproject.app;

import java.io.IOException;
import java.nio.file.Path;

import com.portflioproject.service.SearchService;
import com.portflioproject.service.SortService;
import com.portflioproject.storage.JsonStorage;
import com.portfolioproject.comparator.QuestionComparators;
import com.portfolioproject.comparator.ResultComparators;
import com.portfolioproject.model.Question;
import com.portfolioproject.model.Result;
import com.portfolioproject.model.Student;
import com.portfolioproject.repository.QuestionRepository;
import com.portfolioproject.repository.ResultRepository;
import com.portfolioproject.repository.StudentRepository;

public class Main {
    private static final Path DATA_DIR       = Path.of("data");
    private static final Path QUESTIONS_FILE = DATA_DIR.resolve("questions.json");
    private static final Path STUDENTS_FILE  = DATA_DIR.resolve("students.json");
    private static final Path RESULTS_FILE   = DATA_DIR.resolve("results.json");

    public static void main(String[] args) throws IOException {
        QuestionRepository questionRepo = new QuestionRepository();
        StudentRepository  studentRepo  = new StudentRepository();
        ResultRepository   resultRepo   = new ResultRepository();

        seedQuestions(questionRepo);
        seedStudents(studentRepo);
        seedResults(resultRepo);

        System.out.println("=== Questions containing 'Java' ===");
        SearchService.searchQuestions(questionRepo.findAll(), "Java").forEach(System.out::println);

        System.out.println("\n=== Students whose name contains 'Ali' ===");
        SearchService.searchStudents(studentRepo.findAll(), "Ali").forEach(System.out::println);

        System.out.println("\n=== Results sorted by score (Descending) ===");
        SortService.sortBy(resultRepo.findAll(), ResultComparators.BY_SCORE_DESC).forEach(System.out::println);

        System.out.println("\n=== Questions sorted by difficulty ===");
        SortService.sortBy(questionRepo.findAll(), QuestionComparators.BY_DIFFICULTY).forEach(System.out::println);

        System.out.println("\n=== Students sorted naturally (By Name) ===");
        SortService.sortNatural(studentRepo.findAll()).forEach(System.out::println);

        JsonStorage.save(QUESTIONS_FILE, questionRepo.findAll(), Question.class);
        JsonStorage.save(STUDENTS_FILE,  studentRepo.findAll(),  Student.class);
        JsonStorage.save(RESULTS_FILE,   resultRepo.findAll(),   Result.class);
        System.out.println("\nSaved to: " + DATA_DIR.toAbsolutePath());

        QuestionRepository loaded = new QuestionRepository();
        JsonStorage.load(QUESTIONS_FILE, Question.class).forEach(loaded::save);
        System.out.println("Loaded " + loaded.count() + " questions from JSON.");

        loaded.findById("Q1").ifPresent(q -> System.out.println("Search by ID: " + q));
    }

    private static void seedQuestions(QuestionRepository repo) {
        repo.save(new Question("Q1", "What is Java?", "Programming", "A language", 2));
        repo.save(new Question("Q2", "What is HashMap?", "Collections", "Key-value map", 3));
        repo.save(new Question("Q3", "What is OOP?", "Programming", "Object Oriented", 2));
        repo.save(new Question("Q4", "What is a Set?", "Collections", "No duplicates", 1));
        repo.save(new Question("Q5", "What is a Comparator?", "Generics", "Sorting helper", 4));
    }

    private static void seedStudents(StudentRepository repo) {
        repo.save(new Student("S1", "Ali"));
        repo.save(new Student("S2", "Sara"));
        repo.save(new Student("S3", "Omar"));
        repo.save(new Student("S4", "Alia"));
    }

    private static void seedResults(ResultRepository repo) {
        repo.save(new Result("R1", "S1", "Q1", 80));
        repo.save(new Result("R2", "S2", "Q2", 95));
        repo.save(new Result("R3", "S1", "Q3", 60));
        repo.save(new Result("R4", "S3", "Q4", 70));
        repo.save(new Result("R5", "S2", "Q5", 88));
    }
}