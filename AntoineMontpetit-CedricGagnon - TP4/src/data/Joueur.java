package data;

/**
 * 
 * @author Cédric Gagnon
 * @version automne 2020
 *
 */
public class Joueur {
	private static final int LONGUEUR_NOM_MAX = 20;
	private static final int LONGUEUR_NOM_MIN = 3;
	private String nom;
	private static final String NOM_DEFAUT = "Bob";
	private int pointage;
	private static final int POINTAGE_MIN = 0;
	
	public Joueur(String pNom){
		pointage=0;
		nom=NOM_DEFAUT;
		if(validerNom(pNom)) {
			nom=pNom;
		}
	}
	
	public String getNom() {
		return(nom);
	}
	
	public void setNom(String pNom) {
		if(validerNom(pNom)) {
			nom=pNom;
		}
	}
	
	public int getPointage(){
		return(pointage);
	}
	
	public void setPointage(int pPointage){
		if(validerPointage(pointage)) {
			pointage=pPointage;
		}
	}
	
	public int ajouterPointage(int pointageDePlus) {
		if(pointageDePlus>=POINTAGE_MIN) {
			pointage+=pointageDePlus;
		}
		return(pointage);
	}
	
	public static boolean validerNom(String pNom) {
		return(pNom.length()>=LONGUEUR_NOM_MIN && pNom.length()<=LONGUEUR_NOM_MAX);
	}
	
	private static boolean validerPointage(int pPointage) {
		return(pPointage>=POINTAGE_MIN);
	}
	
	public String toString() {
		return(nom+" : "+pointage);
	}
}
