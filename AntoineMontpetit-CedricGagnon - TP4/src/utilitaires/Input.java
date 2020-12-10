/**
 * @author Jocelyn -- Cégep Limoilou
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
	 * @param pQuestion chaéne permettant de poser une question.
	 *
	 * @return Integer, un objet entier (Integer) permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
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
			// Boéte de dialogue de saisie
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
	 * Saisir une chaéne de caractéres. La saisie est non bloquante.
	 *
	 * @param pQuestion chaéne permettant de poser une question.
	 *
	 * @return String un objet chaéne de caractéres permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
	 */
	public static String saisirString(String pQuestion)
	{
		String stringTemp = null;
		boolean valide = false;
		String reponse = "";

		// Saisir tant que pas valide
		do
		{
			// Boéte de dialogue de saisie
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
	 * Permet d'afficher une question (message) dans une boite de confirmation
	 * avec les boutons oui et non
	 *
	 * @param pQuestion - La question sous forme de string
	 * @return - true si le joueur a cliké sur oui.
	 */
	public static boolean confirmerMessage(String pQuestion)
	{
		boolean confirme = true;

		// Boéte de dialogue d'affichage
		if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(null,
				pQuestion, "Confirmation", JOptionPane.YES_NO_OPTION))
		{
			confirme = false;
		}

		return confirme;
	}
}
