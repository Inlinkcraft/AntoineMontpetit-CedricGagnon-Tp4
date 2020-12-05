package application;

import data.InfoSelonSequenceDeDes;
import data.Joueur;
import data.MainDe5Des;
import data.SequenceDeDes;
import utilitaires.Input;
import utilitaires.Output;

/**
 * Classe permettant de g�rer l'application jeu de d�s
 * 
 * @version automne 2020
 * 
 * @author Antoine
 *
 */
public class JeuDeDes
{

	/**
	 * Le nombre de tour ?
	 */
	private static final int NBR_TOUR = 3;

	/**
	 * Le joueur 1
	 */
	private static Joueur joueur1;

	/**
	 * Le joueur 2
	 */
	private static Joueur joueur2;

	/**
	 * la main courante du joueur
	 */
	private static MainDe5Des mainCourante;

	/**
	 * Utilise "Input.saisirString(...)" du package utilitaires fourni. Saisit
	 * le nom d'un joueur dans une boucle (tant que pas annuler et pas valide).
	 * Le nom saisi ne contient pas d'espaces inutiles et est mis en majuscules.
	 * Ensuite, cr�e un joueur avec le nom saisi (si valide). Si la saisie est
	 * annul�e, la m�thode retourne null.
	 * 
	 * @param message - Le message qui demande le nom du joueur
	 * @return - Le joueur
	 */
	private static Joueur creerJoueur(String message)
	{
		String nomDeJoueur = "";
		Joueur joueurCree = null;

		do
		{
			nomDeJoueur = Input.saisirString(message);
		}
		while (nomDeJoueur != null && !Joueur.validerNom(nomDeJoueur));
		if (nomDeJoueur != null)
		{
			joueurCree = new Joueur(nomDeJoueur.trim().toUpperCase());
		}
		return joueurCree;
	}

	/**
	 * Utilise "Input.confirmerMessage(...)" et "Output.afficherMessage(...)".
	 * Boucle principale pour jouer. Fait jouer les deux joueurs tant qu'il
	 * veulent � tour de r�le. Lorsque le jeu se termine (joueur a r�pondu non �
	 * la question "Voulez-vous jouer encore ?"), le pointage final des joueurs
	 * est affich� ainsi que le message de fin.
	 */
	private static void jouer()
	{
		mainCourante = new MainDe5Des();
		do
		{
			jouerTourJoueurCourant(joueur1);
			jouerTourJoueurCourant(joueur2);
		}
		while (Input.confirmerMessage("Voulez-vous jouer encore?"));
		Output.afficherMessage("Merci d'avoir utilis� cette application...\n\n"
				+ joueur1.getNom() + " vous avez " + joueur1.getPointage()
				+ " point(s).\n" + joueur2.getNom() + " vous avez "
				+ joueur2.getPointage() + " point(s).");

	}

	/**
	 * Utilise "Input.saisirEntier(...)" et "Output.afficherMessage(...)".
	 * Commence par brasser tous les d�s de la main courante avant d'entrer dans
	 * une boucle qui permet de faire jouer les 3 tours ou moins, au joueur re�u
	 * en param�tre. Pour chaque tour, on affiche l'info du tour et la main du
	 * joueur. On �value la main de d�s et on affiche les points s'il y en a. On
	 * demande les num�ros de d�s � relancer et s'il y en a on brasse ces d�s.
	 * En terminant, on affiche l'info du tour, la main courante, les points de
	 * la main s'il y en a sinon le message "D�sol�, vous n'avez aucun gain :o("
	 * 
	 * @param joueurCourant
	 */
	private static void jouerTourJoueurCourant(Joueur joueurCourant)
	{
		String prochainRelance = "12345";
		int currentRoll = 0;
		// int currentTour = 0;

		while (currentRoll < NBR_TOUR)
		{
			if (prochainRelance != null)
				mainCourante.brasserMainDeDes(prochainRelance);

			if (currentRoll < NBR_TOUR - 1)
			{

				String msgPointsGagnes = "\n\n"
						+ InfoSelonSequenceDeDes
								.message(evaluerMainDeDesCourante())
						+ " pour " + InfoSelonSequenceDeDes.pointage(
								evaluerMainDeDesCourante())
						+ " points.";
				String message = "Tour " + (currentRoll + 1) + "/" + NBR_TOUR
						+ " pour " + joueurCourant.getNom()
						+ ", vous avez pr�sentement "
						+ joueurCourant.getPointage()
						+ " point(s)\n\nVoici votre main de d�s:\n\n"
						+ mainCourante.toString() + msgPointsGagnes
						+ "\n\nChoisir le num�ro des d�s que vous voulez relancer (\"Annuler\" pour arr�ter la saisie)!";
				Integer temp = Input.saisirEntier(message);
				prochainRelance = "";
				if (temp != null)
					prochainRelance = temp.toString();
			}
			else
			{
				String msgPointsGagnes = InfoSelonSequenceDeDes
						.message(evaluerMainDeDesCourante())
						+ " pour un gain de " + InfoSelonSequenceDeDes.pointage(
								evaluerMainDeDesCourante())
						+ " points.";
				if (InfoSelonSequenceDeDes
						.pointage(evaluerMainDeDesCourante()) == 0)
				{
					msgPointsGagnes = "\n\nD�sol�, vous n'avez aucun gain :o(";
				}
				String message = "Tour " + (currentRoll + 1) + "/" + NBR_TOUR
						+ " pour " + joueurCourant.getNom()
						+ ", vous avez pr�sentement "
						+ joueurCourant.ajouterPointage(InfoSelonSequenceDeDes
								.pointage(evaluerMainDeDesCourante()))
						+ " point(s)\n\nVoici votre main de d�s:\n\n"
						+ mainCourante.toString() + "\n\n" + msgPointsGagnes;
				Output.afficherMessage(message);
			}
			currentRoll++;
			// System.out.println(currentRoll);
		}

	}

	/**
	 * Boucle permettant d'�valuer la main de d�s courante pour toutes les
	 * s�quences de d�s dans l'ordre d�croissant du pointage des s�quences. Elle
	 * arr�te son �valuation lorsqu'elle trouve une s�quence valide (pr�sente
	 * dans la main).
	 * 
	 * @return - Une s�quence valide ou null si aucune.
	 */
	private static SequenceDeDes evaluerMainDeDesCourante()
	{
		SequenceDeDes retour = null;
		SequenceDeDes[] valeurs =
		{ SequenceDeDes.CINQ_EGAUX, SequenceDeDes.QUATRE_EGAUX,
				SequenceDeDes.FULL, SequenceDeDes.BRELAN,
				SequenceDeDes.DEUX_PAIRES, SequenceDeDes.UNE_PAIRE,
				SequenceDeDes.SERIE_LONGUE, SequenceDeDes.SERIE_COURTE };
		for (int i = 0; i < valeurs.length && retour == null; i++)
		{
			if (mainCourante.evaluerMainDeDes(valeurs[i]))
			{
				retour = valeurs[i];
			}
		}
		return (retour);
	}

	/**
	 * Point d'entr�e de l'application. La m�thode cr�e le "joueur1" (m�thode
	 * creerJoueur) et si le "joueur1" est cr�� sans annulation, on cr�e le
	 * "joueur2" de la m�me fa�on. Par la suite, si les deux joueurs sont cr��s,
	 * elle appelle la m�thode "jouer" pour entrer dans la boucle de jeu. Si un
	 * des 2 joueurs n'a pas pu �tre cr�� l'application se termine avec un
	 * message d'explication.
	 * 
	 * @param args - ?
	 */
	public static void main(String[] args)
	{
		boolean quitter = false;
		joueur1 = creerJoueur("Nom joueur 1");
		if (joueur1 == null)
			quitter = true;

		if (!quitter)
			joueur2 = creerJoueur("Nom joueur 2");

		if (joueur2 == null)
			quitter = true;

		if (joueur1 == null)
		{
		}
		else if (joueur2 == null)
		{
			Output.afficherMessage(
					"D�soler, pour jouer, il faut saisir le nom de 2 joueurs!\n\nLe progrmme va se terminer...");
		}
		else
		{
			jouer();
		}
	}

}
