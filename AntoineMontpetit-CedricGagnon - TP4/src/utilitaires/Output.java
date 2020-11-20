package utilitaires;

import javax.swing.JOptionPane;

public class Output
{

	/**
	 * Permet d'afficher un message.
	 *
	 * @param message
	 */
	public static void afficherMessage(String message)
	{
		// Boîte de dialogue d'affichage
		JOptionPane.showMessageDialog(null, message, "Information",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
