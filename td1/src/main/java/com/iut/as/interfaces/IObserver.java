package com.iut.as.interfaces;

import com.iut.as.modele.Observable;

public interface IObserver {

	// Obligation d'implémenter cette fonction :
	void update(Observable obj);
}
