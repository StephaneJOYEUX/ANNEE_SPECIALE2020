package com.iut.as.modele;

import static com.iut.as.modele.factory.EtudiantFactory.getListEtudiants;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

public class TestEtudiant {

	private Etudiant etudiant;

	@Before
	public void setUp() {
		// On récupère bien un étudiant !
		etudiant = getListEtudiants().get(0);
	}

	@Test
	public void testEqualsIsTrue() {
		Etudiant obj = new Etudiant();
		obj.setId(1);
		obj.setNom("JOYEUX");
		obj.setPrenom("Stéphane");
		assertEquals(etudiant, obj);
	}

	@Test
	public void testEqualsIsFalse() {
		Etudiant obj = new Etudiant();
		obj.setId(2);
		obj.setNom("JOYEUX");
		obj.setPrenom("Stéphane");
		assertNotSame(etudiant, obj);
	}
}
