package com.iut.as.modele;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;

public class TestMathematicTDD {

	private IMaths maths;

	@Before
	// Le before s'execute avant chaque test ..
	// Il permet de réinitialiser le contexte d'exécution ..
	public void setUp() {
		this.maths = null; // Au départ la classe "MathematicTDD" n'existe pas .. !!
		this.maths = new MathematicTDD();
	}

	@Test
	public void testAddition() {
		assertEquals(2, maths.addition(1, 1));
	}

	@Test
	public void testSoustraction() {
		// Ce test fonctionne mais pour autant la méthode est complètement fausse !!!
		assertEquals(0, maths.soustraction(1, 1));
		assertEquals(2, maths.soustraction(4, 2));
	}

	@Test
	public void testDivision() {
		assertEquals(2d, maths.division(4, 2));
	}

	@Test(expected = MathematicException.class)
	public void testDivisionParZero() {
		assertEquals(2d, maths.division(4, 0));
	}

}
