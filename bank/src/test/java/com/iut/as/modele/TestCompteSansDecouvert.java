package com.iut.as.modele;

import org.junit.Before;

public class TestCompteSansDecouvert {

	private CompteSansDecouvert compte;

	@Before
	public void setUp() {
		compte = new CompteSansDecouvert("123456", 100d);
	}

}
