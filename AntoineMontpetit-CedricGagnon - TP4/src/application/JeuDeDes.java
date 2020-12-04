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

	private static final int NBR_TOUR = 3;

	private static Joueur joueur1;
	private static Joueur joueur2;
	private static MainDe5Des mainCourante;

	private static Joueur creerJoueur(String message)
	{
		String nomDeJoueur = "";
		Joueur joueurCree = null;
		do
		{
			nomDeJoueur = Input.saisirString(message);
		}
		while (nomDeJoueur!=null && !Joueur.validerNom(nomDeJoueur));
		if(nomDeJoueur!=null) {
			joueurCree=new Joueur(nomDeJoueur.trim().toUpperCase());
		}
		return joueurCree;
	}

	private static void jouer()
	{
		mainCourante=new MainDe5Des();
		do {
			jouerTourJoueurCourant(joueur1);
			jouerTourJoueurCourant(joueur2);
		}
		while(Input.confirmerMessage("Voulez-vous jouer encore?"));
		Output.afficherMessage("Merci d'avoir utilisé cette application...\n\n"+joueur1.getNom()+" vous avez "+joueur1.getPointage()+" point(s).\n"+joueur2.getNom()+" vous avez "+joueur2.getPointage()+" point(s).");

	}

	private static void jouerTourJoueurCourant(Joueur joueurCourant)
	{
		String prochainRelance="12345";
		int currentRoll = 0;
		int currentTour = 0;

		
		while (currentRoll < NBR_TOUR)
		{
			if(prochainRelance!=null)
				mainCourante.brasserMainDeDes(prochainRelance);
			
			
			if (currentRoll < NBR_TOUR - 1)
			{
				String msgPointsGagnes="\n\n"+InfoSelonSequenceDeDes.message(evaluerMainDeDesCourante())+" pour "+InfoSelonSequenceDeDes.pointage(evaluerMainDeDesCourante())+" points.";
				String message = "Tour " + (currentRoll+1) + "/" + NBR_TOUR
						+ " pour " + joueurCourant.getNom()
						+ ", vous avez présentement "
						+ joueurCourant.getPointage()
						+ " point(s)\n\nVoici votre main de dés:\n\n"
						+ mainCourante.toString() + msgPointsGagnes
						+ "\n\nChoisir le numéro des dés que vous voulez relancer (\"Annuler\" pour arrêter la saisie)!";
				Integer temp=Input.saisirEntier(message);
				prochainRelance="";
				if(temp!=null)
					prochainRelance=temp.toString();
			}
			else
			{
				String msgPointsGagnes=InfoSelonSequenceDeDes.message(evaluerMainDeDesCourante())+" pour un gain de "+InfoSelonSequenceDeDes.pointage(evaluerMainDeDesCourante())+" points.";
				if (InfoSelonSequenceDeDes.pointage(evaluerMainDeDesCourante())==0)
				{
					msgPointsGagnes = "\n\nDésolé, vous n'avez aucun gain :o(";
				}
				String message = "Tour " + (currentRoll+1) + "/" + NBR_TOUR
						+ " pour " + joueurCourant.getNom()
						+ ", vous avez présentement "
						+ joueurCourant.ajouterPointage(InfoSelonSequenceDeDes.pointage(evaluerMainDeDesCourante()))
						+ " point(s)\n\nVoici votre main de dés:\n\n"
						+ mainCourante.toString() + "\n\n" + msgPointsGagnes;
				Output.afficherMessage(message);
			}
			currentRoll++;
			//System.out.println(currentRoll);
		}

	}
	private static SequenceDeDes evaluerMainDeDesCourante() {
		SequenceDeDes retour=null;
		SequenceDeDes[] valeurs =
			{ SequenceDeDes.CINQ_EGAUX, SequenceDeDes.QUATRE_EGAUX,
					SequenceDeDes.FULL, SequenceDeDes.BRELAN,
					SequenceDeDes.DEUX_PAIRES, SequenceDeDes.UNE_PAIRE,
					SequenceDeDes.SERIE_LONGUE, SequenceDeDes.SERIE_COURTE };
		for (int i = 0; i < valeurs.length && retour == null; i++)
		{
			if (mainCourante.evaluerMainDeDes(valeurs[i]))
			{
				retour=valeurs[i];
			}
		}
		return(retour);
	}
	public static void main(String[] args)
	{
		boolean quitter=false;
		joueur1=creerJoueur("Nom joueur 1");
		if(joueur1==null)
			quitter=true;
		
		if(!quitter)
			joueur2=creerJoueur("Nom joueur 2");
		
		if(joueur2==null)
			quitter=true;
		
		if(joueur1==null) {
		}
		else if(joueur2==null) {
			Output.afficherMessage("Désoler, pour jouer, il faut saisir le nom de 2 joueurs!\n\nLe progrmme va se terminer...");
		}
		else {
			jouer();
		}
	
		
		int x=0;
		//jouerTourJoueurCourant(joueur1);
	}

}
