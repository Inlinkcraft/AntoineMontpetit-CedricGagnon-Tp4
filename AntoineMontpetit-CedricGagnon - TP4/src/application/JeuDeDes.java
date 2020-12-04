package application;

import data.Joueur;
import data.MainDe5Des;
import utilitaires.Input;

/**
 * Classe permettant de gérer l'application jeu de dés
 * 
 * @version automne 2020
 * 
 * @author Antoine
 *
 */
public class JeuDeDes {
	
	private static final int NBR_TOOR = 3;
	
	private static Joueur joueur1;
	private static Joueur joueur2;
	private static MainDe5Des mainCourante;
	
	private static Joueur creerJoueur(String message) {
		String nomDeJoueur = "";
		do {
			nomDeJoueur = Input.saisirString(message);
		}while(Joueur.validerNom(nomDeJoueur));
		return new Joueur(nomDeJoueur);
	}
	
}
