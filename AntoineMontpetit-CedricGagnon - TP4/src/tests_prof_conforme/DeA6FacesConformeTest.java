package tests_prof_conforme;

import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Modifier;
import data.DeA6Faces;

public class DeA6FacesConformeTest
{

	@Test
	public void testDeA6FacesConforme() throws ClassNotFoundException, Exception
	{
		// Package et nom de la classe
		Class c = Class.forName("data.DeA6Faces");

		// Constructeurs
		assertTrue(c.getConstructor(new Class[]
		{}).getName() == "data.DeA6Faces");
		assertTrue(c.getConstructor(new Class[]
		{ byte.class }).getName() == "data.DeA6Faces");

		// Attributs et constantes
		assertTrue(c.getDeclaredField("FACE_MIN").getType() == byte.class);
		assertTrue((c.getDeclaredField("FACE_MIN").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue(c.getDeclaredField("FACE_MAX").getType() == byte.class);
		assertTrue((c.getDeclaredField("FACE_MAX").getModifiers()
				& (Modifier.STATIC + Modifier.PRIVATE
						+ Modifier.FINAL)) == Modifier.STATIC + Modifier.PRIVATE
								+ Modifier.FINAL);
		assertTrue((c.getField("NBR_FACES").getType() == byte.class)
				&& (DeA6Faces.NBR_FACES == 6));
		assertTrue((c.getField("NBR_FACES").getModifiers() & Modifier.STATIC
				+ Modifier.PUBLIC + Modifier.FINAL) == Modifier.STATIC
						+ Modifier.PUBLIC + Modifier.FINAL);
		assertTrue(c.getDeclaredField("faceVisible").getType() == byte.class);
		assertTrue((c.getDeclaredField("faceVisible").getModifiers()
				& (Modifier.PRIVATE)) == Modifier.PRIVATE);

		// Certaines méthodes
		assertTrue(c.getDeclaredMethod("setFaceVisible", new Class[]
		{ byte.class }).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("setFaceVisible", new Class[]
		{ byte.class }).getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("validerFaceVisible", new Class[]
		{ byte.class }).getReturnType() == boolean.class);
		assertTrue((c.getDeclaredMethod("validerFaceVisible", new Class[]
		{ byte.class }).getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE);

		assertTrue(c.getMethod("getFaceVisible", new Class[]
		{}).getReturnType() == byte.class);
		assertTrue((c.getDeclaredMethod("getFaceVisible", new Class[]
		{}).getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC);

		assertTrue(c.getMethod("brasser", new Class[]
		{}).getReturnType() == void.class);
		assertTrue((c.getDeclaredMethod("brasser", new Class[]
		{}).getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC);

		assertTrue(c.getMethod("toString", new Class[]
		{}).getReturnType() == String.class);
		assertTrue((c.getDeclaredMethod("toString", new Class[]
		{}).getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC);
	}
}
