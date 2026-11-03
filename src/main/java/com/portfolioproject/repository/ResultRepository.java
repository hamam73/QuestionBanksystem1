package com.portfolioproject.repository;

import com.portfolioproject.model.Result;

public class ResultRepository extends InMemoryRepository<Result, String> {
    @Override
    protected String getId(Result r) { return r.getId(); }
}