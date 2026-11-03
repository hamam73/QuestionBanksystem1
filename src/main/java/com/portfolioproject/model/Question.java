package com.portfolioproject.model;

import java.util.Objects;

public class Question implements Comparable<Question> {
    private String id;
    private String text;
    private String subject;
    private String answer;
    private int difficulty;

    public Question() {}

    public Question(String id, String text, String subject, String answer, int difficulty) {
        this.id = id;
        this.text = text;
        this.subject = subject;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
    public int getDifficulty() { return difficulty; }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }

    @Override
    public int compareTo(Question other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question q)) return false;
        return Objects.equals(id, q.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Question{" + id + ", '" + text + "', " + subject + ", diff=" + difficulty + "}";
    }
}