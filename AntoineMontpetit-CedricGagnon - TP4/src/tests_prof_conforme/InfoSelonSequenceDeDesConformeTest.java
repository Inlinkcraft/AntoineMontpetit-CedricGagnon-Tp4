package tests_prof_conforme;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.Test;

import data.SequenceDeDes;

public class InfoSelonSequenceDeDesConformeTest
{

	@Test
	public void testInfoSelonSequenceDeDesConforme()
			throws ClassNotFoundException, Exception
	{
		// Package et nom de la classe
		Class c = Class.forName("data.InfoSelonSequenceDeDes");

		// Constructeurs

		// Attributs et constantes

		// Certaines méthodes
		assertTrue(c.getMethod("pointage", new Class[]
		{ SequenceDeDes.class }).getReturnType() == int.class);
		assertTrue((c.getMethod("pointage", new Class[]
		{ SequenceDeDes.class }).getModifiers()
				& (Modifier.PUBLIC + Modifier.STATIC)) == Modifier.PUBLIC
						+ Modifier.STATIC);

		assertTrue(c.getMethod("message", new Class[]
		{ SequenceDeDes.class }).getReturnType() == String.class);
		assertTrue((c.getMethod("message", new Class[]
		{ SequenceDeDes.class }).getModifiers()
				& (Modifier.PUBLIC + Modifier.STATIC)) == Modifier.PUBLIC
						+ Modifier.STATIC);
	}

}
