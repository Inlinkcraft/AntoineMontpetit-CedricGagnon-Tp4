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
	 * main de dés
	 */
	private DeA6Faces[] mainDeDes;

	/**
	 * Nombre de dée total
	 */
	private static final byte NBR_DE_DES = 5;

	// CONSTRUCTOR //

	/**
	 * Crée le tableau de 5 dés et ajoute des dés dedans.
	 */
	public MainDe5Des() {
		this(new byte[NBR_DE_DES]);
	}

	/**
	 * Permet de construire une main de 5 dés à partir d'un vecteur de 5 valeurs qui
	 * représentent les faces visibles des 5 dés. Utilise le constructeur de dé avec
	 * paramètre. Très utile pour faire des tests de la présente classe
	 * 
	 * @param tabFaceVsible - un tableau de 5 valeurs, les faces visibles des dés.
	 */
	public MainDe5Des(byte[] tabFaceVsible) {

		mainDeDes = new DeA6Faces[tabFaceVsible.length];

		for (int i = 0; i < mainDeDes.length; i++) {
			mainDeDes[i] = new DeA6Faces(tabFaceVsible[i]);
		}

	}

	// METHOD

	/**
	 * Brasse le dé dont le numéro est "noDe", s'il est valide.
	 * 
	 * @param noDe - Index du dée à brassé
	 */
	public void brasserDeNo(byte noDe) {
		mainDeDes[noDe].brasser();
	}

	/**
	 * Brasse chaque dé indiqué par son numéro dans la chaîne de caractères reçue.
	 * Exemple si on reçoit la chaîne "235" on doit brasser les dés numéro 2, 3 et
	 * 5. Vous trouverez dans la classe Character une méthode qui retourne la valeur
	 * numérique d'un caractère
	 * 
	 * @param infoDesABrasser - Dés à brasser
	 */
	public void brasserMainDeDes(String infoDesABrasser) {
		for (int i = 0; i < infoDesABrasser.length(); i++) {
			brasserDeNo(Byte.parseByte(String.valueOf(infoDesABrasser.charAt(i))));
		}
	}
	
	/**
	 * Retourne la valeur visible du dé numéro "noDe" ou -1 si le numéro de dé n'est pas valide.
	 * 
	 * @param noDe
	 * @return
	 */
	public byte getValeurDeNo(byte noDe) {
		// hey nous avons généré ceci qui fait le travail en une ligne :D
		return (byte) (((noDe< mainDeDes.length && noDe >= 0) ? 1:0) * noDe+((noDe < mainDeDes.length && noDe >= 0) ? 1:0)-1);
	}
	
	
	
	/**
	 * Sert à tester nos méthodes
	 * @param args - ?
	 */
	public static void main(String[] args) {
		//hey ;P
	}
}
