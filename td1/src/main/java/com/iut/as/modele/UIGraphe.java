package com.iut.as.modele;

import com.iut.as.interfaces.IObserver;

/**
 * User interface
 * 
 * @author stephane.joyeux
 *
 */
public class UIGraphe implements IObserver {

	private int num;

	public int getNum() {
		return num;
	}

	public UIGraphe(int num) {
		this.num = num;
	}

	@Override
	public void update(Observable obj) {
		// Je suis prévenu que le bilan est à jour :
		System.out.println("Update obj" + obj.toString());
		if (obj instanceof Bilan) {
			// Nous recevons bien une instance de Bilan :
			Bilan bilan = (Bilan) obj; // Je 'caste' mon obj en Bilan !
			// réaliser d'autre opérations de mise à jour de l'écran !
			System.out.println(" --> le graphe " + this.num + " est mis à jour ");
			System.out.println(" --> le bilan concerné est le N° " + bilan.getNum());
		}
	}
}
