package application;

import data.InfoSelonSequenceDeDes;
import data.Joueur;
import data.MainDe5Des;
import data.SequenceDeDes;
import utilitaires.Input;
import utilitaires.Output;

/**
 * Classe permettant de gérer l'application jeu de dés
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
	 * Ensuite, crée un joueur avec le nom saisi (si valide). Si la saisie est
	 * annulée, la méthode retourne null.
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
	 * veulent à tour de rôle. Lorsque le jeu se termine (joueur a répondu non à
	 * la question "Voulez-vous jouer encore ?"), le pointage final des joueurs
	 * est affiché ainsi que le message de fin.
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
		Output.afficherMessage("Merci d'avoir utilisé cette application...\n\n"
				+ joueur1.getNom() + " vous avez " + joueur1.getPointage()
				+ " point(s).\n" + joueur2.getNom() + " vous avez "
				+ joueur2.getPointage() + " point(s).");

	}

	/**
	 * Utilise "Input.saisirEntier(...)" et "Output.afficherMessage(...)".
	 * Commence par brasser tous les dés de la main courante avant d'entrer dans
	 * une boucle qui permet de faire jouer les 3 tours ou moins, au joueur reçu
	 * en paramètre. Pour chaque tour, on affiche l'info du tour et la main du
	 * joueur. On évalue la main de dés et on affiche les points s'il y en a. On
	 * demande les numéros de dés à relancer et s'il y en a on brasse ces dés.
	 * En terminant, on affiche l'info du tour, la main courante, les points de
	 * la main s'il y en a sinon le message "Désolé, vous n'avez aucun gain :o("
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
						+ ", vous avez présentement "
						+ joueurCourant.getPointage()
						+ " point(s)\n\nVoici votre main de dés:\n\n"
						+ mainCourante.toString() + msgPointsGagnes
						+ "\n\nChoisir le numéro des dés que vous voulez relancer (\"Annuler\" pour arrêter la saisie)!";
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
					msgPointsGagnes = "\n\nDésolé, vous n'avez aucun gain :o(";
				}
				String message = "Tour " + (currentRoll + 1) + "/" + NBR_TOUR
						+ " pour " + joueurCourant.getNom()
						+ ", vous avez présentement "
						+ joueurCourant.ajouterPointage(InfoSelonSequenceDeDes
								.pointage(evaluerMainDeDesCourante()))
						+ " point(s)\n\nVoici votre main de dés:\n\n"
						+ mainCourante.toString() + "\n\n" + msgPointsGagnes;
				Output.afficherMessage(message);
			}
			currentRoll++;
			// System.out.println(currentRoll);
		}

	}

	/**
	 * Boucle permettant d'évaluer la main de dés courante pour toutes les
	 * séquences de dés dans l'ordre décroissant du pointage des séquences. Elle
	 * arrête son évaluation lorsqu'elle trouve une séquence valide (présente
	 * dans la main).
	 * 
	 * @return - Une séquence valide ou null si aucune.
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
	 * Point d'entrée de l'application. La méthode crée le "joueur1" (méthode
	 * creerJoueur) et si le "joueur1" est créé sans annulation, on crée le
	 * "joueur2" de la même façon. Par la suite, si les deux joueurs sont créés,
	 * elle appelle la méthode "jouer" pour entrer dans la boucle de jeu. Si un
	 * des 2 joueurs n'a pas pu être créé l'application se termine avec un
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
					"Désoler, pour jouer, il faut saisir le nom de 2 joueurs!\n\nLe progrmme va se terminer...");
		}
		else
		{
			jouer();
		}
	}

}
