package com.portfolioproject.comparator;

import com.portfolioproject.model.Result;
import java.util.Comparator;

public final class ResultComparators {
    private ResultComparators() {}

    public static final Comparator<Result> BY_SCORE_DESC =
            Comparator.comparingInt(Result::getScore).reversed();

    public static final Comparator<Result> BY_SCORE_ASC =
            Comparator.comparingInt(Result::getScore);

    public static final Comparator<Result> BY_STUDENT_THEN_SCORE =
            Comparator.comparing(Result::getStudentId)
                      .thenComparing(Result::getScore, Comparator.reverseOrder());
}