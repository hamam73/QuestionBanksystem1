package com.portflioproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class SortService {
    private SortService() {}

    public static <T extends Comparable<? super T>> List<T> sortNatural(List<T> items) {
        List<T> copy = new ArrayList<>(items);
        Collections.sort(copy);
        return copy;
    }

    public static <T> List<T> sortBy(List<T> items, Comparator<? super T> comparator) {
        List<T> copy = new ArrayList<>(items);
        copy.sort(comparator);
        return copy;
    }
}