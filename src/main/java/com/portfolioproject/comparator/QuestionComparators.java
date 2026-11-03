package com.portfolioproject.comparator;

import com.portfolioproject.model.Question;
import java.util.Comparator;

public final class QuestionComparators {
    private QuestionComparators() {}

    public static final Comparator<Question> BY_DIFFICULTY =
            Comparator.comparingInt(Question::getDifficulty);

    public static final Comparator<Question> BY_SUBJECT_THEN_ID =
            Comparator.comparing(Question::getSubject)
                      .thenComparing(Question::getId);
}