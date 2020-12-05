package data;

/**
 * 
 * Classe représentant un joueur possédant un nom et un pointage
 * 
 * @author Cédric Gagnon
 * @version automne 2020
 *
 */
public class Joueur
{
	/**
	 * La Longueur maximum du nom
	 */
	private static final int LONGUEUR_NOM_MAX = 20;

	/**
	 * La longueur mininimu du nom
	 */
	private static final int LONGUEUR_NOM_MIN = 3;

	/**
	 * Le nom du joueur
	 */
	private String nom;

	/**
	 * Le nom par default
	 */
	private static final String NOM_DEFAUT = "Bob";

	/**
	 * Le pointage du joueur
	 */
	private int pointage;

	/**
	 * Le pointage minimum
	 */
	private static final int POINTAGE_MIN = 0;

	/**
	 * Met le pointage à zéro et donne le nom au joueur s'il est valide, sinon
	 * nom par défaut.
	 * 
	 * @param pNom - Le nom du joueur
	 */
	public Joueur(String pNom)
	{
		pointage = 0;
		nom = NOM_DEFAUT;
		if (validerNom(pNom))
		{
			nom = pNom;
		}
	}

	/**
	 * Retourne le nom du joueur
	 * 
	 * @return - Le nom du joueur
	 */
	public String getNom()
	{
		return (nom);
	}

	/**
	 * Assigne un nouveau nom au joueur s'il est valide.
	 * 
	 * @param pNom - Le nom de a set
	 */
	private void setNom(String pNom)
	{
		if (validerNom(pNom))
		{
			nom = pNom;
		}
	}

	/**
	 * Retourne le pointage du joueur
	 * 
	 * @return - le pointage
	 */
	public int getPointage()
	{
		return (pointage);
	}

	/**
	 * Assigne un nouveau pointage au joueur s'il est valide (>=0)
	 * 
	 * @param pPointage - le pointage a set
	 */
	private void setPointage(int pPointage)
	{
		if (validerPointage(pointage))
		{
			pointage = pPointage;
		}
	}

	/**
	 * Ajoute le pointage reçu en entrée, s'il est valide (>=0), à celui du
	 * joueur et retourne le nouveau pointage.
	 * 
	 * @param pointageDePlus - Le pointage a rajouté
	 * @return - Le nouveau pointage
	 */
	public int ajouterPointage(int pointageDePlus)
	{
		if (pointageDePlus >= POINTAGE_MIN)
		{
			pointage += pointageDePlus;
		}
		return (pointage);
	}

	/**
	 * Valide le nom
	 * 
	 * @param pNom - le nom à valider
	 * @return - true si ces valide
	 */
	public static boolean validerNom(String pNom)
	{
		return (pNom.length() >= LONGUEUR_NOM_MIN
				&& pNom.length() <= LONGUEUR_NOM_MAX);
	}

	/**
	 * Valide la valeur du pointage (>=0).
	 * 
	 * @param pPointage - le pointage a valider
	 * @return - true si le ce pointage est vrai
	 */
	private static boolean validerPointage(int pPointage)
	{
		return (pPointage >= POINTAGE_MIN);
	}

	/**
	 * Retourne l'info du joueur sous cette forme: Arthur : 0
	 */
	public String toString()
	{
		return (nom + " : " + pointage);
	}
}
