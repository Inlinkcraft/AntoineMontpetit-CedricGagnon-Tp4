package data;

/**
 * 
 * @author Antoine Montpetit
 * @version automne 2020
 * 
 */
public class MainDe5Des {

	// VARS //

	/**
	 * main de d�s
	 */
	private DeA6Faces[] mainDeDes;

	/**
	 * Nombre de d�e total
	 */
	private static final byte NBR_DE_DES = 5;

	// CONSTRUCTOR //

	/**
	 * Cr�e le tableau de 5 d�s et ajoute des d�s dedans.
	 */
	public MainDe5Des() {
		this(new byte[NBR_DE_DES]);
	}

	/**
	 * Permet de construire une main de 5 d�s � partir d'un vecteur de 5 valeurs qui
	 * repr�sentent les faces visibles des 5 d�s. Utilise le constructeur de d� avec
	 * param�tre. Tr�s utile pour faire des tests de la pr�sente classe
	 * 
	 * @param tabFaceVsible - un tableau de 5 valeurs, les faces visibles des d�s.
	 */
	public MainDe5Des(byte[] tabFaceVsible) {

		mainDeDes = new DeA6Faces[tabFaceVsible.length];

		for (int i = 0; i < mainDeDes.length; i++) {
			mainDeDes[i] = new DeA6Faces(tabFaceVsible[i]);
		}

	}

	// METHOD

	/**
	 * Brasse le d� dont le num�ro est "noDe", s'il est valide.
	 * 
	 * @param noDe - Index du d�e � brass�
	 */
	public void brasserDeNo(byte noDe) {
		mainDeDes[noDe].brasser();
	}

	/**
	 * Brasse chaque d� indiqu� par son num�ro dans la cha�ne de caract�res re�ue.
	 * Exemple si on re�oit la cha�ne "235" on doit brasser les d�s num�ro 2, 3 et
	 * 5. Vous trouverez dans la classe Character une m�thode qui retourne la valeur
	 * num�rique d'un caract�re
	 * 
	 * @param infoDesABrasser - D�s � brasser
	 */
	public void brasserMainDeDes(String infoDesABrasser) {
		for (int i = 0; i < infoDesABrasser.length(); i++) {
			brasserDeNo(Byte.parseByte(String.valueOf(infoDesABrasser.charAt(i))));
		}
	}
	
	/**
	 * Retourne la valeur visible du d� num�ro "noDe" ou -1 si le num�ro de d� n'est pas valide.
	 * 
	 * @param noDe
	 * @return
	 */
	public byte getValeurDeNo(byte noDe) {
		// hey nous avons g�n�r� ceci qui fait le travail en une ligne :D
		return (byte) (((noDe< mainDeDes.length && noDe >= 0) ? 1:0) * noDe+((noDe < mainDeDes.length && noDe >= 0) ? 1:0)-1);
	}
	
	
	
	/**
	 * Sert � tester nos m�thodes
	 * @param args - ?
	 */
	public static void main(String[] args) {
		//hey ;P
	}
}
