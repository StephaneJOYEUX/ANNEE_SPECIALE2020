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
		System.out.println("Update obj" + obj.toString());
	}
}
