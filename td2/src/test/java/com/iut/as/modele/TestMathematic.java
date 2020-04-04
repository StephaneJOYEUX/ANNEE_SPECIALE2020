package com.iut.as.modele;

import static java.lang.Double.valueOf;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.iut.as.exception.MathematicException;
import com.iut.as.interfaces.IMaths;

/**
 * @description : Test de la classe {@link Mathematic}.
 * 
 * @author stephane.joyeux
 *
 */
public class TestMathematic {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// Utilisation de l'interface : Je veux m'abstraire de l'implémentation réelle
	// de l'objet (-> Mock Oject)
	private IMaths maths;
	private IMaths mathsMock;

	@Before
	public void setUp() {
		// 1. Création d'un objet de type 'Mathematic' :
		this.maths = new Mathematic();
		// 2. Création d'un mock objet :
		mathsMock = mock(IMaths.class);
	}

	@Test
	public void testAdditionAvecMock() {
		// Simulation de la méthode addition ...
		// Peu importe les valeurs de a et b --> Le résultat sera toujours 4 !
		when(mathsMock.addition(anyInt(), anyInt())).thenReturn(4);
		assertEquals(4, mathsMock.addition(4, 3));
	}

	@Test
	public void testDivisionAvecMock() {
		// Simulation de la méthode addition ...
		// Peu importe les valeurs de a et b --> Le résultat sera toujours 4 !
		when(mathsMock.division(anyInt(), anyInt())).thenReturn(4d);
		// Je m'assure que je n'aurai JAMAIS de division par zero ...
		assertEquals(4d, mathsMock.division(4, 0));
		assertEquals(4d, mathsMock.division(4, 3));
		assertEquals(4d, mathsMock.division(-4, -3));
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

	@Test
	public void testDivisionParZeroAutrePossibilite() {
		thrown.expect(MathematicException.class);
		// thrown.expectMessage("com.iut.as.exception.MathematicException: Division par
		// zero");
		maths.division(-16, 0);
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
