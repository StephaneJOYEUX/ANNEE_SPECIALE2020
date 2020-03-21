package com.iut.as.modele;

public class Bilan extends Observable {

	private int num;

	public int getNum() {
		return num;
	}

	public Bilan(int num) {
		System.out.println("Bilan N° " + num + " est créé.");
		this.num = num;
	}

	/* Permet d'indiquer que le bilan est mis à jour. */
	public void setChange() {		
		System.out.println("Moi bilan " + this.num + " ... je préviens les observateurs de se mettre à jour !");
		// J'appelle tous les observateurs .. pour leur dire ... coucou je suis à jour !!
		this.notifyObserv();
	}
	
	public void doSomething(){
		System.out.println("Bilan N° " + this.num + " je fais quelque chose ...");
	}
	
	public void doSomethingElse() {
		System.out.println("Bilan N° " + this.num + " je fais quelque chose d'autre ...");
	}	
}
