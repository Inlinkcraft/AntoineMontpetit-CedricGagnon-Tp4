package utilitaires;

import javax.swing.JOptionPane;

public class Output
{

	/**
	 * Permet d'afficher un message.
	 *
	 * @param message - le message a afficher
	 */
	public static void afficherMessage(String message)
	{
		// Boite de dialogue d'affichage
		JOptionPane.showMessageDialog(null, message, "Information",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
