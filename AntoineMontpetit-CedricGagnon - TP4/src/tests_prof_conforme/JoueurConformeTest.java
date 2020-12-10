package tests_prof_conforme;

import static org.junit.Assert.*;
import java.lang.reflect.Modifier;
import org.junit.Test;

public class JoueurConformeTest
{

	@Test
	public void testJoueurConforme() throws ClassNotFoundException, Exception
	{
		// Package et nom de la classe
		Class c = Class.forName("data.Joueur");

		// Constructeurs
		assertTrue(c.getConstructor(new Class[]
		{ String.class }).getName() == "data.Joueur");

		// Attributs et constantes
		assertTrue(c.getDeclaredField("POINTAGE_MIN").getType() == int.class);
		assertTrue((c.getDeclaredField("POINTAGE_MIN").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue(
				c.getDeclaredField("LONGUEUR_NOM_MIN").getType() == int.class);
		assertTrue((c.getDeclaredField("LONGUEUR_NOM_MIN").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue(
				c.getDeclaredField("LONGUEUR_NOM_MAX").getType() == int.class);
		assertTrue((c.getDeclaredField("LONGUEUR_NOM_MAX").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue(c.getDeclaredField("NOM_DEFAUT").getType() == String.class);
		assertTrue((c.getDeclaredField("NOM_DEFAUT").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);

		assertTrue(c.getDeclaredField("nom").getType() == String.class);
		assertTrue((c.getDeclaredField("nom").getModifiers()
				& (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredField("pointage").getType() == int.class);
		assertTrue((c.getDeclaredField("pointage").getModifiers()
				& (Modifier.PRIVATE)) == Modifier.PRIVATE);

		// Certaines méthodes
		assertTrue(c.getDeclaredMethod("setNom", new Class[]
		{ String.class }).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("setNom", new Class[]
		{ String.class }).getModifiers()
				& Modifier.PRIVATE) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("setPointage", new Class[]
		{ int.class }).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("setPointage", new Class[]
		{ int.class }).getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("validerPointage", new Class[]
		{ int.class }).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("validerPointage", new Class[]
		{ int.class }).getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE)) == Modifier.PRIVATE
						+ Modifier.STATIC);
		assertTrue(c.getMethod("getNom", new Class[]
		{}).getReturnType() == String.class);
		assertTrue((c.getDeclaredMethod("getNom", new Class[]
		{}).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("getPointage", new Class[]
		{}).getReturnType() == int.class);
		assertTrue((c.getDeclaredMethod("getPointage", new Class[]
		{}).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("ajouterPointage", new Class[]
		{ int.class }).getReturnType() == int.class);
		assertTrue((c.getDeclaredMethod("ajouterPointage", new Class[]
		{ int.class }).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("validerNom", new Class[]
		{ String.class }).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("validerNom", new Class[]
		{ String.class }).getModifiers()
				& (Modifier.STATIC + Modifier.PUBLIC)) == Modifier.PUBLIC
						+ Modifier.STATIC);
	}
}
