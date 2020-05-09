package com.iut.as.modele;

import static com.iut.as.factory.modele.CompteFactory.getCompte;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.iut.as.enumerations.ETypeCompte;

public class TestCompteAvecDecouvert {

	private Compte compte;

	private static final String NUM_COMPTE_TEST = "FR12 112345";
	private static final double MONTANT_INITIAL = 100d;
	private static final double DECOUVERT_AUTORISE_MONTANT_INITIAL = 500d;

	@Before
	public void setUp() {
		compte = getCompte(ETypeCompte.AVEC_DECOUVERT, NUM_COMPTE_TEST, MONTANT_INITIAL,
				DECOUVERT_AUTORISE_MONTANT_INITIAL);
	}

	@Test
	public void testCrediter() {
		// Je vais créditer mon compte de 100e :
		assertTrue(compte.crediter(100d));
		assertTrue(compte.decouvertAutorise());
		// Mon solde doit être égal ) mon solde initial + 100e.
		assertEquals(200d, compte.getSolde(), 1);
	}

	@Test
	public void testDebiterAvecSoldeSuffisant() {
		// Je vais débiter mon compte de 100e:
		assertTrue(compte.debiter(100d));
		assertTrue(compte.decouvertAutorise());
		// Mon solde doit être égal à mon solde initial + 100e.
		assertEquals(0, compte.getSolde(), 1);
	}

	@Test
	public void testDebiterAvecSoldeInsuffisantMaisDecouvertAutorise() {
		// Je vais débiter mon compte de 150e:
		assertTrue(compte.debiter(150d));
		assertTrue(compte.decouvertAutorise());
		// Mon solde doit être égal
		assertEquals(-50, compte.getSolde(), 1);
	}

	@Test
	public void testDebiterAvecSoldeInsuffisantMaisDecouvertAutoriseAtteint() {
		// Je vais débiter mon compte de 601e:
		assertFalse(compte.debiter(601d));
		assertTrue(compte.decouvertAutorise());
		// Mon solde doit être égal à 500eoui.
		assertEquals(MONTANT_INITIAL, compte.getSolde(), 1);
	}
}
