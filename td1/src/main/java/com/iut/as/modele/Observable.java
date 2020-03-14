package com.iut.as.modele;

import java.util.ArrayList;
import java.util.List;

import com.iut.as.interfaces.IObserver;

public class Observable {

	// Observable contient une liste d'observeurs.
	private List<IObserver> observers;

	public Observable() {
		// Lors de la construction de l'objet, j'init ma collection.
		this.observers = new ArrayList<>();
	}

	public List<IObserver> getObservers() {
		return observers;
	}

	public void addObersver(IObserver o) {
		if (observers != null) {
			// J'atoute un observeur à ma liste !
			observers.add(o);
		}
	}

	@Override
	public String toString() {
		return "Observable";
	}
}
