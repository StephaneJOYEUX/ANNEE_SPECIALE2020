package com.iut.as.interfaces;

import java.util.List;

import com.iut.as.modele.Client;

public interface IDaoClient extends IDao<Client> {

	List<Client> getListClient();
}
