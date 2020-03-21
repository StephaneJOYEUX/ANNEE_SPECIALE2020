package com.iut.as.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iut.as.interfaces.IObserver;

/**
 * L'objet qui est observé !!
 * @author stephane.joyeux
 *
 */
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

	public void addObserver(IObserver o) {
		if (observers != null) {
			// J'atoute un observeur à ma liste !
			observers.add(o);
		}
	}

	/* Utilisation du pattern Itérator */
	public void notifyObserv() {
		Iterator<IObserver> it = this.observers.iterator();
		// Parcours de la liste de 'TOUS' les observateurs ...
		while (it.hasNext()) {
			// Le seul qui permet de parcourir une liste et de modifier son contenu pendant son parcours.			
			it.next().update(this);
		}

		// Autre manière de parcourir une liste !!
//		for (IObserver iObserver : observers) {
//			
//		}

	}

	@Override
	public String toString() {
		return "Observable";
	}
}
