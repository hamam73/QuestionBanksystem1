package com.portfolioproject.model;

import java.util.Objects;

public class Result {
    private String id;
    private String studentId;
    private String questionId;
    private int score;

    public Result() {}
    
    public Result(String id, String studentId, String questionId, int score) {
        this.id = id;
        this.studentId = studentId;
        this.questionId = questionId;
        this.score = score;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getQuestionId() { return questionId; }
    public void setQuestionId(String questionId) { this.questionId = questionId; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result r)) return false;
        return Objects.equals(id, r.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Result{" + id + ", student=" + studentId
                + ", question=" + questionId + ", score=" + score + "}";
    }
}