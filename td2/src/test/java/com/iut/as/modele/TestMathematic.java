package com.iut.as.modele;

import static java.lang.Double.valueOf;
import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;

/**
 * @description : Test de la classe {@link Mathematic}.
 * 
 * @author stephane.joyeux
 *
 */
public class TestMathematic {

	// Utilisation de l'interface : Je veux m'abstraire de l'implémentation réelle
	// de l'objet (-> Mock Oject)
	private IMaths maths;

	@Before
	public void setUp() {
		this.maths = new Mathematic();
	}

	@Test
	public void testAdditionAvecNombrePositif() {
		assertEquals(4, maths.addition(2, 2));
		assertEquals(11, maths.addition(4, 7));
	}

	@Test
	public void testSoustractionAvecNombrePositif() {
		assertEquals(0, maths.soustraction(2, 2));
		assertEquals(-3, maths.soustraction(4, 7));
	}

	@Test
	public void testDivisionAvecNombrePositif() {
		assertEquals(1d, maths.division(2, 2));
		assertEquals(2d, maths.division(8, 4));
	}

	@Test
	public void testMultiplicationAvecNombrePositif() {
		assertEquals(28, maths.multiplication(4, 7));
		assertEquals(12, maths.multiplication(3, 4));
	}

	@Test
	public void testMultiplicationAvecNombreNegatif() {
		assertEquals(-28, maths.multiplication(-4, 7));
		assertEquals(-12, maths.multiplication(-3, 4));
		assertEquals(-28, maths.multiplication(4, -7));
	}

	@Test
	public void testMultiplicationAvecNombresNegatifs() {
		assertEquals(28, maths.multiplication(-4, -7));
		assertEquals(14, maths.multiplication(-7, -2));
	}

	@Test
	public void testMultiplicationAvec0() {
		assertEquals(0, maths.multiplication(0, -7));
		assertEquals(0, maths.multiplication(-7, 0));
		assertEquals(0, maths.multiplication(0, 0));
	}

	@Test
	public void testDivisionAvecNombresPositifs() {
		// On reçoit du double :
		assertEquals(4d, maths.division(16, 4));
		assertEquals(4, valueOf(maths.division(8, 2)).intValue());
	}

	@Test
	public void testDivisionAvecNombresNegatifs() {
		// On reçoit du double :
		assertEquals(-4d, maths.division(-16, 4));
		assertEquals(4d, maths.division(-16, -4));
		assertEquals(-4, valueOf(maths.division(8, -2)).intValue());
	}

	@Test(expected = MathematicException.class)
	public void testDivisionParZero() {
		// Approche plus TDD (Test Driven development)
		// L'exception nous aide à mieux gérer ce qu'il faut faire en cas d'erreur !
		assertEquals(-4d, maths.division(-16, 0));
	}

	@Test(expected = MathematicException.class)
	public void testDivisionWithNull() {
		assertEquals(-4d, maths.division(null, -1));
		assertEquals(-4d, maths.division(-16, null));
		assertEquals(-4d, maths.division(null, null));
	}
}
