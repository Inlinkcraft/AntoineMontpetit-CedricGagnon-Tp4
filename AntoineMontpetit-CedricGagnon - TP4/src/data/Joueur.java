package data;

/**
 * 
 * Classe représentant un joueur possédant un nom et un pointage
 * 
 * @author Cédric Gagnon
 * @version automne 2020
 *
 */
public class Joueur {
	/**
	 * la longueur maximal d'un nom de joueur
	 */
	private static final int LONGUEUR_NOM_MAX = 20;
	
	/**
	 * la longueur minimum d'un nom de joueur
	 */
	private static final int LONGUEUR_NOM_MIN = 3;
	
	/**
	 * Le nom par default aka bob
	 */
	private static final String NOM_DEFAUT = "Bob";
	
	/**
	 * Le pointage minimum
	 */
	private static final int POINTAGE_MIN = 0;
	
	/**
	 * Le nom du joueur
	 */
	private String nom;
	
	/**
	 * Le pointage du joueur
	 */
	private int pointage;
	
	/**
	 * Met le pointage à zéro et donne le nom au joueur s'il est valide, sinon nom par défaut.
	 * @param pNom - Le nom en String tu joueur
	 */
	public Joueur(String pNom){
		pointage=0;
		nom=NOM_DEFAUT;
		if(validerNom(pNom)) {
			nom=pNom;
		}
	}
	
	/**
	 * Retourne le nom du joueur
	 * @return - Le nom du joueur
	 */
	public String getNom() {
		return(nom);
	}
	
	/**
	 * Assigne un nouveau nom au joueur s'il est valide.
	 * @param pNom - le nouveau nom du joueur
	 */
	public void setNom(String pNom) {
		if(validerNom(pNom)) {
			nom=pNom;
		}
	}
	
	/**
	 * Retourne le pointage du joueur
	 * @return - Le pointage du joueur
	 */
	public int getPointage(){
		return(pointage);
	}
	
	/**
	 * Assigne un nouveau pointage au joueur s'il est valide (>=0)
	 * @param pPointage - le nouveau pointage
	 */
	public void setPointage(int pPointage){
		if(validerPointage(pointage)) {
			pointage=pPointage;
		}
	}
	
	/**
	 * Ajoute le pointage reçu en entrée, s'il est valide (>=0), à celui du joueur et retourne le nouveau pointage.
	 * @param pointageDePlus - Le pointage a rajouter
	 * @return - Le nouveau pointage
	 */
	public int ajouterPointage(int pointageDePlus) {
		if(pointageDePlus>=POINTAGE_MIN) {
			pointage+=pointageDePlus;
		}
		return(pointage);
	}
	
	/**
	 * Valide le nom
	 * @param pNom - Le nom a valider
	 * @return - true si le nom est valide
	 */
	public static boolean validerNom(String pNom) {
		return(pNom.length()>=LONGUEUR_NOM_MIN && pNom.length()<=LONGUEUR_NOM_MAX);
	}
	
	/**
	 * Valide la valeur du pointage (>=0).
	 * @param pPointage - pointage a valider
	 * @return - true si le pointage est valide
	 */
	private static boolean validerPointage(int pPointage) {
		return(pPointage>=POINTAGE_MIN);
	}
	
	/**
	 * Retourne l'info du joueur sous cette forme: Arthur : 0
	 * @return - le string de cette methode
	 */
	public String toString() {
		return(nom+" : "+pointage);
	}
}
