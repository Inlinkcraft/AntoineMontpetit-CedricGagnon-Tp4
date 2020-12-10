package tests_prof_conforme;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.Test;

import data.DeA6Faces;
import data.SequenceDeDes;

public class MainDe5DesConformeTest
{

	@Test
	public void testMainDe5DesConforme()
			throws ClassNotFoundException, Exception
	{
		// Package et nom de la classe
		Class c = Class.forName("data.MainDe5Des");

		// Constructeurs
		assertTrue(c.getConstructor(new Class[]
		{}).getName() == "data.MainDe5Des");
		assertTrue(c.getConstructor(new Class[]
		{ byte[].class }).getName() == "data.MainDe5Des");

		// Attributs et constantes
		assertTrue(c.getDeclaredField("NBR_DE_DES").getType() == byte.class);
		assertTrue((c.getDeclaredField("NBR_DE_DES").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue(
				c.getDeclaredField("mainDeDes").getType() == DeA6Faces[].class);
		assertTrue((c.getDeclaredField("mainDeDes").getModifiers()
				& (Modifier.PRIVATE)) == Modifier.PRIVATE);

		// Certaines méthodes

		assertTrue(c.getDeclaredMethod("validerNoDe", new Class[]
		{ byte.class }).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("validerNoDe", new Class[]
		{ byte.class }).getModifiers()
				& (Modifier.PRIVATE + Modifier.STATIC)) == Modifier.PRIVATE
						+ Modifier.STATIC);
		assertTrue(c.getDeclaredMethod("compterValeursDes", new Class[]
		{}).getReturnType() == byte[].class);
		assertTrue((c.getDeclaredMethod("compterValeursDes", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerCinqEgaux", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerCinqEgaux", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerQuatreEgaux", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerQuatreEgaux", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerFull", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerFull", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerSerieLongue", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerSerieLongue", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerBrelan", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerBrelan", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerSerieCourte", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerSerieCourte", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerDeuxPaires", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerDeuxPaires", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("evaluerUnePaire", new Class[]
		{}).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerUnePaire", new Class[]
		{}).getModifiers() & (Modifier.PRIVATE)) == Modifier.PRIVATE);

		assertTrue(c.getMethod("brasserDeNo", new Class[]
		{ byte.class }).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("brasserDeNo", new Class[]
		{ byte.class }).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("getNbrDes", new Class[]
		{}).getReturnType() == byte.class);
		assertTrue((c.getDeclaredMethod("getNbrDes", new Class[]
		{}).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("brasserMainDeDes", new Class[]
		{ String.class }).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("brasserMainDeDes", new Class[]
		{ String.class }).getModifiers()
				& (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("getValeurDeNo", new Class[]
		{ byte.class }).getReturnType() == byte.class);
		assertTrue((c.getDeclaredMethod("getValeurDeNo", new Class[]
		{ byte.class }).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("getNbrDes", new Class[]
		{}).getReturnType() == byte.class);
		assertTrue((c.getDeclaredMethod("getNbrDes", new Class[]
		{}).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("evaluerMainDeDes", new Class[]
		{ SequenceDeDes.class }).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("evaluerMainDeDes", new Class[]
		{ SequenceDeDes.class }).getModifiers()
				& (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("toStringMainDeDes", new Class[]
		{}).getReturnType() == String.class);
		assertTrue((c.getDeclaredMethod("toStringMainDeDes", new Class[]
		{}).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
		assertTrue(c.getMethod("toString", new Class[]
		{}).getReturnType() == String.class);
		assertTrue((c.getDeclaredMethod("toString", new Class[]
		{}).getModifiers() & (Modifier.PUBLIC)) == Modifier.PUBLIC);
	}
}
