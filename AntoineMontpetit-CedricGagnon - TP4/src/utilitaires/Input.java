/**
 * @author Jocelyn -- C�gep Limoilou
 *
 * @version 2013
 */
package utilitaires;

import javax.swing.JOptionPane;

/**
 * Cette classe offre certains outils utiles.
 *
 */
public class Input
{
	/**
	 * Saisir un entier. La saisie est non bloquante.
	 *
	 * @param pQuestion cha�ne permettant de poser une question.
	 *
	 * @return Integer, un objet entier (Integer) permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a d�cid� d'annuler la saisie.
	 *
	 */
	public static Integer saisirEntier(String pQuestion)
	{
		Integer objetEntier = null;
		boolean valide = false;
		String reponse = "";

		// Saisir tant que pas valide
		do
		{
			// Bo�te de dialogue de saisie
			reponse = JOptionPane.showInputDialog(null, pQuestion);

			if (reponse != null)
			{
				try
				{
					objetEntier = new Integer(Integer.parseInt(reponse));
					valide = true;
				}
				catch (Exception e)
				{
					valide = false;
				}
			}
		}
		while (!valide && reponse != null);

		return objetEntier;
	}

	/**
	 * Saisir une cha�ne de caract�res. La saisie est non bloquante.
	 *
	 * @param pQuestion cha�ne permettant de poser une question.
	 *
	 * @return String un objet cha�ne de caract�res permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a d�cid� d'annuler la saisie.
	 */
	public static String saisirString(String pQuestion)
	{
		String stringTemp = null;
		boolean valide = false;
		String reponse = "";

		// Saisir tant que pas valide
		do
		{
			// Bo�te de dialogue de saisie
			reponse = JOptionPane.showInputDialog(null, pQuestion);

			if (reponse != null)
			{
				stringTemp = reponse;
				valide = true;
			}
		}
		while (!valide && reponse != null);

		return stringTemp;
	}

	/**
	 * Permet d'afficher une question (message) dans une bo�te de confirmation
	 * avec les boutons oui et non
	 *
	 * @param pQuestion
	 * @return
	 */
	public static boolean confirmerMessage(String pQuestion)
	{
		boolean confirme = true;

		// Bo�te de dialogue d'affichage
		if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(null,
				pQuestion, "Confirmation", JOptionPane.YES_NO_OPTION))
		{
			confirme = false;
		}

		return confirme;
	}
}
