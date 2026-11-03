package com.portfolioproject.repository;

import com.portfolioproject.model.Question;

public class QuestionRepository extends InMemoryRepository<Question, String> {
    @Override
    protected String getId(Question q) { return q.getId(); }
}