package com.crud.backend.interfaces;

import java.util.List;

public interface ServiceImpl<T> {
    public abstract List<T> getAll();

    public abstract List<T> getRecommendedList();

    public abstract T getById(String id);

    public abstract void save(T parent);

    public abstract void put(T parent);

    public abstract List<T> getByParentId(String id);

}
