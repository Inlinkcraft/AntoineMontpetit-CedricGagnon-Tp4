package tests_prof_conforme;

import static org.junit.Assert.*;
import org.junit.Test;

import data.SequenceDeDes;

public class SequenceDeDesConformeTest
{

	@Test
	public void testSequenceDeDesConforme()
			throws ClassNotFoundException, Exception
	{
		// Package et nom de la classe
		Class c = Class.forName("data.SequenceDeDes");

		// Constructeurs

		// Attributs et constantes
		assertNotNull(SequenceDeDes.CINQ_EGAUX);
		assertNotNull(SequenceDeDes.QUATRE_EGAUX);
		assertNotNull(SequenceDeDes.FULL);
		assertNotNull(SequenceDeDes.SERIE_LONGUE);
		assertNotNull(SequenceDeDes.BRELAN);
		assertNotNull(SequenceDeDes.SERIE_COURTE);
		assertNotNull(SequenceDeDes.DEUX_PAIRES);
		assertNotNull(SequenceDeDes.UNE_PAIRE);

		// Certaines méthodes
	}
}
