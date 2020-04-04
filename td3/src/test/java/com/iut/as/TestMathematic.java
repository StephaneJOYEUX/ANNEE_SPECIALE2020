package com.iut.as;

import static java.lang.Double.valueOf;
import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;
import com.iut.as.modele.Mathematic;

public class TestMathematic {

	// On passe toujours par l'interface : Mock - Spy
	private IMaths maths;

	@Before
	public void setUp() {
		this.maths = new Mathematic();
	}

	@Test(expected = MathematicException.class)
	public void testAdditionAvecPremierNombreNull() {
		assertEquals(4, maths.addition(null, 2).intValue());
	}

	@Test(expected = MathematicException.class)
	public void testAdditionAvecDeuxiemeNombreNull() {
		assertEquals(11, maths.addition(4, null).intValue());
	}

	@Test(expected = MathematicException.class)
	public void testAdditionAvecNombresNull() {
		assertEquals(11, maths.addition(null, null).intValue());
	}

	@Test
	public void testAdditionAvecNombrePositif() {
		assertEquals(4, maths.addition(2, 2).intValue());
		assertEquals(11, maths.addition(4, 7).intValue());
	}

	@Test
	public void testSoustractionAvecNombrePositif() {
		assertEquals(0, maths.soustraction(2, 2).intValue());
		assertEquals(new Integer(-3), maths.soustraction(4, 7));
	}

	@Test
	public void testDivisionAvecNombrePositif() {
		assertEquals(1d, maths.division(2, 2));
		assertEquals(2d, maths.division(8, 4));
	}

	@Test
	public void testMultiplicationAvecNombrePositif() {
		assertEquals(28, maths.multiplication(4, 7).intValue());
		assertEquals(12, maths.multiplication(3, 4).intValue());
	}

	@Test
	public void testMultiplicationAvecNombreNegatif() {
		assertEquals(-28, maths.multiplication(-4, 7).intValue());
		assertEquals(-12, maths.multiplication(-3, 4).intValue());
		assertEquals(-28, maths.multiplication(4, -7).intValue());
	}

	@Test
	public void testMultiplicationAvecNombresNegatifs() {
		assertEquals(28, maths.multiplication(-4, -7).intValue());
		assertEquals(14, maths.multiplication(-7, -2).intValue());
	}

	@Test
	public void testMultiplicationAvec0() {
		assertEquals(0, maths.multiplication(0, -7).intValue());
		assertEquals(0, maths.multiplication(-7, 0).intValue());
		assertEquals(0, maths.multiplication(0, 0).intValue());
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

	@Test
	public void testDivisionParZeroDernierePossibilite() {
		try {
			assertEquals(-4d, maths.division(-16, 0));
		} catch (MathematicException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(expected = MathematicException.class)
	public void testDivisionWithNull() {
		assertEquals(-4d, maths.division(null, -1));
		assertEquals(-4d, maths.division(-16, null));
		assertEquals(-4d, maths.division(null, null));
	}
}
