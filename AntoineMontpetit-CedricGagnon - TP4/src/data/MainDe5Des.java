package data;

/**
 * 
 * Classe représentant une main de 5 dés
 * 
 * @author Antoine Montpetit
 * @version automne 2020
 * 
 */
public class MainDe5Des
{

	/**
	 * main de dés
	 */
	private DeA6Faces[] mainDeDes;

	/**
	 * Nombre de dés total
	 */
	private static final byte NBR_DE_DES = 5;

	/**
	 * Crée le tableau de 5 dés et ajoute des dés dedans.
	 */
	public MainDe5Des()
	{
		this(new byte[NBR_DE_DES]);
	}

	/**
	 * Permet de construire une main de 5 dés à partir d'un vecteur de 5 valeurs
	 * qui représentent les faces visibles des 5 dés. Utilise le constructeur de
	 * dé avec paramètre. Très utile pour faire des tests de la présente classe
	 * 
	 * @param tabFaceVsible - Un tableau de 5 valeurs, les faces visibles des
	 *            dés.
	 */
	public MainDe5Des(byte[] tabFaceVsible)
	{
		if (validerNoDe((byte) tabFaceVsible.length))
		{
			mainDeDes = new DeA6Faces[tabFaceVsible.length];

			for (int i = 0; i < mainDeDes.length; i++)
			{
				mainDeDes[i] = new DeA6Faces(tabFaceVsible[i]);
			}
		}
		else
		{
			mainDeDes = new DeA6Faces[NBR_DE_DES];

			for (int i = 0; i < mainDeDes.length; i++)
			{
				mainDeDes[i] = new DeA6Faces();
			}
		}

	}

	/**
	 * Brasse le dé dont le numéro est "noDe", s'il est valide.
	 * 
	 * @param noDe - Index du dé à brasser
	 */
	public void brasserDeNo(byte noDe)
	{
		if (validerNoDe(noDe))
			mainDeDes[noDe - 1].brasser();
	}

	/**
	 * Brasse chaque dé indiqué par son numéro dans la chaîne de caractères
	 * reçue. Exemple si on reçoit la chaîne "235" on doit brasser les dés
	 * numéro 2, 3 et 5. Vous trouverez dans la classe Character une méthode qui
	 * retourne la valeur numérique d'un caractère
	 * 
	 * @param infoDesABrasser - Dés à brasser
	 */
	public void brasserMainDeDes(String infoDesABrasser)
	{
		for (int i = 0; i < infoDesABrasser.length(); i++)
		{
			brasserDeNo(
					Byte.parseByte(String.valueOf(infoDesABrasser.charAt(i))));
		}
	}

	/**
	 * Compte le nombre de dés selon la valeur de la face visible. Compte le
	 * nombre de 1, de 2, de 3 et ainsi de suite selon la face visible de chaque
	 * dé de la main. Cette méthode sera utile à toutes les méthodes evaluer.
	 *
	 * Exemple pour la main de 5 dés suivante:
	 * 
	 * No. du dé : 1 2 3 4 5 Valeur : [4] [5] [1] [4] [3]
	 * 
	 * Le tableau de sortie aurait les valeurs suivantes:
	 * 
	 * valeur du dé : 1 2 3 4 5 6 indice : 0 1 2 3 4 5 Nombre de fois: [1] [0]
	 * [1] [2] [1] [0] La main possède donc un 1, zéro 2, un 3, deux 4, un 5 et
	 * zéro 6
	 * 
	 * @return - un tableau de byte dont chaque élément représente le nombre de
	 *         dés d'une certaine valeur.
	 */
	private byte[] compterValeurDes()
	{
		byte[] compte =
		{ 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < mainDeDes.length; i++)
		{
			compte[mainDeDes[i].getFaceVisible() - 1]++;
		}
		return compte;
	}

	/**
	 * Évalue si la main de dés équivaut à 3 égaux.
	 * 
	 * @return - true si la main contient un brelan
	 */
	private boolean evaluerBrelan()
	{
		byte[] compte = compterValeurDes();
		boolean estBrelan = false;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] == 3)
			{
				estBrelan = true;
			}
		}
		return estBrelan;
	}

	/**
	 * Évalue si la main de dés équivaut à 5 égaux.
	 * 
	 * @return - true si la main a 5 chiffres pareils
	 */
	private boolean evaluerCinqEgaux()
	{
		byte[] compte = compterValeurDes();
		boolean estCinqEgaux = false;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] == 5)
			{
				estCinqEgaux = true;
			}
		}
		return estCinqEgaux;
	}

	/**
	 * Évalue si la main de dés équivaut à 2 paires.
	 * 
	 * @return - true si la main contient deux paires
	 */
	private boolean evaluerDeuxPaires()
	{
		byte[] compte = compterValeurDes();
		boolean estPair = false;
		boolean estDeuxPair = false;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] == 2)
			{
				if (!estPair)
				{
					estPair = true;
				}
				else
				{
					estDeuxPair = true;
				}
			}
		}
		return estDeuxPair;
	}

	/**
	 * Évalue si la main de dés équivaut à un brelan et une paire.
	 * 
	 * @return - true si la main contient un brelan et une paire
	 */
	private boolean evaluerFull()
	{
		return evaluerBrelan() && evaluerUnePaire();
	}

	/**
	 * Évalue la main de dés selon la séquence reçue en paramètre. Se sert de
	 * toutes les autres méthodes evaluer. L'ordre d'évaluation est important.
	 * 
	 * @param sequence - la séquence à évaluer
	 * @return - true si la séquence demandée est contenue dans la main
	 */
	public boolean evaluerMainDeDes(SequenceDeDes sequence)
	{
		boolean estSequence = false;
		switch (sequence)
		{
			case BRELAN:
				estSequence = evaluerBrelan();
				break;
			case CINQ_EGAUX:
				estSequence = evaluerCinqEgaux();
				break;
			case DEUX_PAIRES:
				estSequence = evaluerDeuxPaires();
				break;
			case FULL:
				estSequence = evaluerFull();
				break;
			case QUATRE_EGAUX:
				estSequence = evaluerQuatreEgaux();
				break;
			case SERIE_COURTE:
				estSequence = evaluerSerieCourte();
				break;
			case SERIE_LONGUE:
				estSequence = evaluerSerieLongue();
				break;
			case UNE_PAIRE:
				estSequence = evaluerUnePaire();
				break;
		}

		return estSequence;
	}

	/**
	 * Évalue si la main de dés équivaut à 4 égaux.
	 * 
	 * @return - true si la main contient quatre dés égaux
	 */
	private boolean evaluerQuatreEgaux()
	{
		byte[] compte = compterValeurDes();
		boolean estQuatreEgaux = false;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] == 4)
			{
				estQuatreEgaux = true;
			}
		}
		return estQuatreEgaux;
	}

	/**
	 * Évalue si la main de dés équivaut à une série courte soit 1,2,3,4 ;
	 * 2,3,4,5 ou 3,4,5,6
	 * 
	 * @return - true si la main contient une série courte
	 */
	private boolean evaluerSerieCourte()
	{
		byte[] compte = compterValeurDes();
		boolean estSerieQuatre = false;
		int suite = 0;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] > 0)
			{
				suite++;
			}
			else
			{
				suite = 0;
			}
			if (suite == 4)
			{
				estSerieQuatre = true;
			}
		}

		return estSerieQuatre;
	}

	/**
	 * Évalue si la main de dés équivaut à une série longue soit 1,2,3,4,5 ou
	 * 2,3,4,5,6
	 * 
	 * @return - true si la main contient une série longue
	 */
	private boolean evaluerSerieLongue()
	{
		byte[] compte = compterValeurDes();
		boolean estSerieCinq = false;
		int suite = 0;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] > 0)
			{
				suite++;
			}
			else
			{
				suite = 0;
			}
			if (suite == 5)
			{
				estSerieCinq = true;
			}
		}

		return estSerieCinq;
	}

	/**
	 * Évalue si la main de dés équivaut à une paire.
	 * 
	 * @return - true si la main contient une paire
	 */
	private boolean evaluerUnePaire()
	{
		byte[] compte = compterValeurDes();
		boolean estPair = false;
		for (int i = 0; i < compte.length; i++)
		{
			if (compte[i] == 2)
			{
				estPair = true;
			}
		}
		return estPair;
	}

	/**
	 * Retourne le nombre de dés dans la main.
	 * 
	 * @return - le nombre de dés dans la main
	 */
	public byte getNbrDes()
	{
		return (byte) mainDeDes.length;
	}

	/**
	 * Retourne la valeur visible du dé numéro "noDe" ou -1 si le numéro de dé
	 * n'est pas valide.
	 * 
	 * @param noDe
	 * @return - la valeur visible du dé demandé, ou -1 si le numéro de dé est
	 *         invalide
	 */
	public byte getValeurDeNo(byte noDe)
	{
		// hey nous avons trouvé ceci qui fait le travail en une ligne :D
		return (byte) (mainDeDes[Math
				.abs((validerNoDe(noDe) ? 1 : 0) * noDe - 1)].getFaceVisible()
				* (validerNoDe(noDe) ? 1 : 0)
				+ ((validerNoDe(noDe) ? 1 : 0) - 1));
	}

	/**
	 * Utilise toStringMainDeDes
	 * 
	 * @return la représentation graphique de la main de dés
	 */
	public String toString()
	{
		return toStringMainDeDes();
	}

	/**
	 * Retourne une chaîne de caractères qui représente la main de dés selon le
	 * format suivant: No. du dé : 1 2 3 4 5 Valeur : [4] [5] [1] [4] [3]
	 * 
	 * @return - le string de la main
	 */
	public String toStringMainDeDes()
	{
		return "No. du dé :  1     2     3     4    5\nValeur      : "
				+ mainDeDes[0] + "  " + mainDeDes[1] + "  " + mainDeDes[2]
				+ "  " + mainDeDes[3] + "  " + mainDeDes[4];
	}

	/**
	 * Valide si le "noDe" est bien entre 1 et le maximun de dés dans la main.
	 * 
	 * @param noDe - le nombre de dés à valider
	 * @return - vrai si la main de dés équivaut à la séquence demandée, sinon
	 *         faux
	 */
	private static boolean validerNoDe(byte noDe)
	{
		return noDe > 0 && noDe <= NBR_DE_DES;
	}

	public static void main(String[] args)
	{
		utilitaires.Output.afficherMessage(new MainDe5Des().toString());
	}
}
