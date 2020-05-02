package com.iut.as.interfaces;

public interface IDao<T> {

	/* Opération CRUD -> Create / Read / Update / Delete */

	boolean create(T object);

	boolean update(T object);

	T readById(int id);

	T readByKey(String key);

	boolean delete(T object);
}
