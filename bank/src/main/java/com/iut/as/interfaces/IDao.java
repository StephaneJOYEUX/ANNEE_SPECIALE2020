package com.iut.as.interfaces;

public interface IDao<T> {

	boolean create(T object);

	boolean update(T object);

	T readById(int id);

	T readByKey(String key);

	boolean delete(T object);
}
