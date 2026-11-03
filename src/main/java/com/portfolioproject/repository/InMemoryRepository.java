package com.portfolioproject.repository;

import java.util.*;

public abstract class InMemoryRepository<T, ID> implements Repository<T, ID> {
    protected final Map<ID, T> storage = new LinkedHashMap<>();

    protected abstract ID getId(T entity);

    @Override
    public void save(T entity) {
        Objects.requireNonNull(entity, "entity");
        storage.put(getId(entity), entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean deleteById(ID id) {
        return storage.remove(id) != null;
    }

    @Override
    public int count() { return storage.size(); }

    @Override
    public void clear() { storage.clear(); }
}