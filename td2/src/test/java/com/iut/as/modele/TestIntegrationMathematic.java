package com.iut.as.modele;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iut.as.interfaces.IMaths;

/***
 * Classe de test d' intégration :
 * 
 * @author stephane.joyeux
 *
 */
public class TestIntegrationMathematic {

	private IMaths maths;
	private IMaths mathsMock;
	private IMaths mathsSpy;

	@Before
	public void setUp() {
		// 1. Création d'un objet de type 'Mathematic' :
		this.maths = new Mathematic();
		// 2. Création d'un mock objet (un objet FAUX -> Fake tout au long de sa
		// création) :
		this.mathsMock = mock(IMaths.class);
		// 3. Création d'un spy : = new Mathematic();
		// Même chose que son implémentation réelle -> Sauf que je peux changer son
		// comportement en cours de route !
		this.mathsSpy = spy(Mathematic.class);
	}

	@Test
	public void testCalculAdditionEtMultiplication() {
		// test du résultat 2 * 2 + 4;
		when(mathsMock.multiplication(anyInt(), anyInt())).thenReturn(4);
		// assertEquals(4, mathsMock.multiplication(3, 4));
		assertEquals(8, maths.addition(mathsMock.multiplication(8, 32), 4));
	}

	@Test
	public void testAdditionAvecSpy() {
		// Comportement normal :
		assertEquals(7, mathsSpy.addition(3, 4));
		assertEquals(8, mathsSpy.addition(4, 4));
		// Je change son comportement !
		Mockito.doReturn(4).when(mathsSpy).addition(anyInt(), anyInt());
		assertEquals(4, mathsSpy.addition(4, 4));
		assertEquals(4, mathsSpy.addition(4, 3));
		assertEquals(4, mathsSpy.addition(4, 0));
		assertEquals(-1, mathsSpy.soustraction(3, 4));
	}

}
