package data;

/**
 * 
 * Classe repr�sentant une main de 5 d�s
 * 
 * @author Antoine Montpetit
 * @version automne 2020
 * 
 */
public class MainDe5Des
{

	/**
	 * main de d�s
	 */
	private DeA6Faces[] mainDeDes;

	/**
	 * Nombre de d�s total
	 */
	private static final byte NBR_DE_DES = 5;

	/**
	 * Cr�e le tableau de 5 d�s et ajoute des d�s dedans.
	 */
	public MainDe5Des()
	{
		this(new byte[NBR_DE_DES]);
	}

	/**
	 * Permet de construire une main de 5 d�s � partir d'un vecteur de 5 valeurs
	 * qui repr�sentent les faces visibles des 5 d�s. Utilise le constructeur de
	 * d� avec param�tre. Tr�s utile pour faire des tests de la pr�sente classe
	 * 
	 * @param tabFaceVsible - Un tableau de 5 valeurs, les faces visibles des
	 *            d�s.
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
	 * Brasse le d� dont le num�ro est "noDe", s'il est valide.
	 * 
	 * @param noDe - Index du d� � brasser
	 */
	public void brasserDeNo(byte noDe)
	{
		if (validerNoDe(noDe))
			mainDeDes[noDe - 1].brasser();
	}

	/**
	 * Brasse chaque d� indiqu� par son num�ro dans la cha�ne de caract�res
	 * re�ue. Exemple si on re�oit la cha�ne "235" on doit brasser les d�s
	 * num�ro 2, 3 et 5. Vous trouverez dans la classe Character une m�thode qui
	 * retourne la valeur num�rique d'un caract�re
	 * 
	 * @param infoDesABrasser - D�s � brasser
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
	 * Compte le nombre de d�s selon la valeur de la face visible. Compte le
	 * nombre de 1, de 2, de 3 et ainsi de suite selon la face visible de chaque
	 * d� de la main. Cette m�thode sera utile � toutes les m�thodes evaluer.
	 *
	 * Exemple pour la main de 5 d�s suivante:
	 * 
	 * No. du d� : 1 2 3 4 5 Valeur : [4] [5] [1] [4] [3]
	 * 
	 * Le tableau de sortie aurait les valeurs suivantes:
	 * 
	 * valeur du d� : 1 2 3 4 5 6 indice : 0 1 2 3 4 5 Nombre de fois: [1] [0]
	 * [1] [2] [1] [0] La main poss�de donc un 1, z�ro 2, un 3, deux 4, un 5 et
	 * z�ro 6
	 * 
	 * @return - un tableau de byte dont chaque �l�ment repr�sente le nombre de
	 *         d�s d'une certaine valeur.
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
	 * �value si la main de d�s �quivaut � 3 �gaux.
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
	 * �value si la main de d�s �quivaut � 5 �gaux.
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
	 * �value si la main de d�s �quivaut � 2 paires.
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
	 * �value si la main de d�s �quivaut � un brelan et une paire.
	 * 
	 * @return - true si la main contient un brelan et une paire
	 */
	private boolean evaluerFull()
	{
		return evaluerBrelan() && evaluerUnePaire();
	}

	/**
	 * �value la main de d�s selon la s�quence re�ue en param�tre. Se sert de
	 * toutes les autres m�thodes evaluer. L'ordre d'�valuation est important.
	 * 
	 * @param sequence - la s�quence � �valuer
	 * @return - true si la s�quence demand�e est contenue dans la main
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
	 * �value si la main de d�s �quivaut � 4 �gaux.
	 * 
	 * @return - true si la main contient quatre d�s �gaux
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
	 * �value si la main de d�s �quivaut � une s�rie courte soit 1,2,3,4 ;
	 * 2,3,4,5 ou 3,4,5,6
	 * 
	 * @return - true si la main contient une s�rie courte
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
	 * �value si la main de d�s �quivaut � une s�rie longue soit 1,2,3,4,5 ou
	 * 2,3,4,5,6
	 * 
	 * @return - true si la main contient une s�rie longue
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
	 * �value si la main de d�s �quivaut � une paire.
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
	 * Retourne le nombre de d�s dans la main.
	 * 
	 * @return - le nombre de d�s dans la main
	 */
	public byte getNbrDes()
	{
		return (byte) mainDeDes.length;
	}

	/**
	 * Retourne la valeur visible du d� num�ro "noDe" ou -1 si le num�ro de d�
	 * n'est pas valide.
	 * 
	 * @param noDe
	 * @return - la valeur visible du d� demand�, ou -1 si le num�ro de d� est
	 *         invalide
	 */
	public byte getValeurDeNo(byte noDe)
	{
		// hey nous avons trouv� ceci qui fait le travail en une ligne :D
		return (byte) (mainDeDes[Math
				.abs((validerNoDe(noDe) ? 1 : 0) * noDe - 1)].getFaceVisible()
				* (validerNoDe(noDe) ? 1 : 0)
				+ ((validerNoDe(noDe) ? 1 : 0) - 1));
	}

	/**
	 * Utilise toStringMainDeDes
	 * 
	 * @return la repr�sentation graphique de la main de d�s
	 */
	public String toString()
	{
		return toStringMainDeDes();
	}

	/**
	 * Retourne une cha�ne de caract�res qui repr�sente la main de d�s selon le
	 * format suivant: No. du d� : 1 2 3 4 5 Valeur : [4] [5] [1] [4] [3]
	 * 
	 * @return - le string de la main
	 */
	public String toStringMainDeDes()
	{
		return "No. du d� :  1     2     3     4    5\nValeur      : "
				+ mainDeDes[0] + "  " + mainDeDes[1] + "  " + mainDeDes[2]
				+ "  " + mainDeDes[3] + "  " + mainDeDes[4];
	}

	/**
	 * Valide si le "noDe" est bien entre 1 et le maximun de d�s dans la main.
	 * 
	 * @param noDe - le nombre de d�s � valider
	 * @return - vrai si la main de d�s �quivaut � la s�quence demand�e, sinon
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
