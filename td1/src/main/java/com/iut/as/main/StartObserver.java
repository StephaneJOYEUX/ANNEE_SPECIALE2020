package com.iut.as.main;

import com.iut.as.modele.Bilan;
import com.iut.as.modele.UIGraphe;

public class StartObserver {

	public static void main(String[] args) {
		// ------------------------
		// 1. Create two Graphes : deux écrans qui regardent !
		// ------------------------
		UIGraphe myGraphe1 = new UIGraphe(1);
		UIGraphe myGraphe2 = new UIGraphe(2);
		// UIAndroid myGraphe3 = new UIAndroid();

		// ----------------------------
		// 2a. Create One Bilan : l'objet qui est observé !
		// ----------------------------
		Bilan bilan = new Bilan(1);

		// ----------------------------
		// 2b. Create One Bilan : (deuxième objet observé) 
		// ----------------------------
		Bilan bilan2 = new Bilan(2);

		// ----------------------------------------
		// 3a. Add the two observers to the bilan :
		// -----------------------------------------
		bilan.addObserver(myGraphe1);
		bilan.addObserver(myGraphe2);
		// bilan.addObserver(myGraphe3);

		// -------------------------------------------
		// 3b. Add one observer to the second bilan :
		// -------------------------------------------
		bilan2.addObserver(myGraphe2);

		bilan.doSomething(); // Bilan fait quelque chose
		bilan.doSomethingElse(); // Autre autre
		bilan2.doSomething();

		// Update Only one Graph : (force refresh)
		myGraphe1.update(bilan);

 		// Update All the Graphs : (refresh auto).
		// Chaque bilan notifie à tous ses observeurs qu'il est à jour !!
		//bilan.setChange();
		//bilan2.setChange();

		System.out.println("-------> End First TD Nr 1 .......");
	}

}
