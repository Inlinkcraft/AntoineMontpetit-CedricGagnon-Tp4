package tests_prof_conforme;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.Test;

import data.DeA6Faces;
import data.Joueur;
import data.MainDe5Des;
import data.SequenceDeDes;

public class jeuDeDesConformeTest
{

	@Test
	public void testJeuDeDesConforme() throws ClassNotFoundException, Exception
	{
		// Package et nom de la classe
		Class c = Class.forName("application.JeuDeDes");

		// Constructeurs

		// Attributs et constantes
		assertTrue(c.getDeclaredField("NBR_TOUR").getType() == int.class);
		assertTrue((c.getDeclaredField("NBR_TOUR").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue(c.getDeclaredField("joueur1").getType() == Joueur.class);
		assertTrue((c.getDeclaredField("joueur1").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE)) == Modifier.STATIC
						+ Modifier.PRIVATE);
		assertTrue(c.getDeclaredField("joueur2").getType() == Joueur.class);
		assertTrue((c.getDeclaredField("joueur2").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE)) == Modifier.STATIC
						+ Modifier.PRIVATE);
		assertTrue(c.getDeclaredField("mainCourante")
				.getType() == MainDe5Des.class);
		assertTrue((c.getDeclaredField("mainCourante").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE)) == Modifier.STATIC
						+ Modifier.PRIVATE);

		// Certaines méthodes
		assertTrue(c.getDeclaredMethod("creerJoueur", new Class[]
		{ String.class }).getReturnType() == Joueur.class);
		assertTrue((c.getDeclaredMethod("creerJoueur", new Class[]
		{ String.class }).getModifiers()
				& (Modifier.PRIVATE + Modifier.STATIC)) == Modifier.PRIVATE
						+ Modifier.STATIC);
		assertTrue(c.getDeclaredMethod("jouer", new Class[]
		{}).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("jouer", new Class[]
		{}).getModifiers()
				& (Modifier.PRIVATE + Modifier.STATIC)) == Modifier.PRIVATE
						+ Modifier.STATIC);
		assertTrue(c.getDeclaredMethod("jouerTourJoueurCourant", new Class[]
		{ Joueur.class }).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("jouerTourJoueurCourant", new Class[]
		{ Joueur.class }).getModifiers()
				& (Modifier.PRIVATE + Modifier.STATIC)) == Modifier.PRIVATE
						+ Modifier.STATIC);
		assertTrue(c.getDeclaredMethod("evaluerMainDeDesCourante", new Class[]
		{}).getReturnType() == SequenceDeDes.class);
		assertTrue((c.getDeclaredMethod("evaluerMainDeDesCourante", new Class[]
		{}).getModifiers()
				& (Modifier.PRIVATE + Modifier.STATIC)) == Modifier.PRIVATE
						+ Modifier.STATIC);
	}
}
