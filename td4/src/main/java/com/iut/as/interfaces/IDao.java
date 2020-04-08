package com.iut.as.interfaces;

import java.util.List;

/***
 * 
 * Dao standard -> utilisation du type T = Généric en Java.
 * 
 * @author stephane.joyeux
 *
 * @param <T>
 */
public interface IDao<T> {

	T read(int id);

	List<T> getList();

	boolean update(T object);

	boolean delete(T object);
}
