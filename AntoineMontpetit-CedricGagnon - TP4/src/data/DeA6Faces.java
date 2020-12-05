package data;

/**
 * Classe représentant un dé à jouer avec une face visible
 * 
 * @author Cedric Gagnon
 *
 * @version automne 2020
 * 
 */
public class DeA6Faces
{
	/**
	 * Maximum de face
	 */
	private static final byte FACE_MAX = 6;

	/**
	 * Minimum de face
	 */
	private static final Byte FACE_MIN = 1;

	/**
	 * La face qui est visible
	 */
	private byte faceVisible;

	/**
	 * Le nombre de face par default
	 */
	public static final byte NBR_FACES = 6;

	/**
	 * Initialise la face visible du dé en le brassant
	 */
	public DeA6Faces()
	{
		this((byte) -1);
	}

	/**
	 * Initialise la face visible du dé avec la valeur reçue en entrée si elle
	 * est valide sinon on brasse le dé
	 * 
	 * @param valeur - la valeur du dé
	 */
	public DeA6Faces(byte valeur)
	{
		if (validerFaceVisible(valeur))
			faceVisible = valeur;
		else brasser();
	}

	/**
	 * Retourne la valeur de la face visible
	 * 
	 * @return - la face visible
	 */
	public byte getFaceVisible()
	{
		return (faceVisible);
	}

	/**
	 * Assigne une valeur à la face visible si elle est valide
	 * 
	 * @param valeur - la face assigner
	 */
	private void setFaceVisible(byte valeur)
	{
		if (validerFaceVisible(valeur))
		{
			faceVisible = valeur;
		}
	}

	/**
	 * Valide la valeur de la face visible selon le nombre de faces
	 * 
	 * @param valeur - La valeur de la face a valider
	 * @return - true si la face est valide
	 */
	private boolean validerFaceVisible(byte valeur)
	{
		return (valeur <= NBR_FACES && valeur > 0);
	}

	/**
	 * Assigne à la face visible du dé une valeur aléatoire entre les limites
	 * permises
	 */
	public void brasser()
	{
		setFaceVisible(
				(byte) (Math.random() * (FACE_MAX - FACE_MIN + 1) + FACE_MIN));
	}

	/**
	 * Retourne vrai si 2 dés ont la même valeur pour leur face visible
	 * 
	 * @param obj - l'autre dé comparer à
	 * @return - true si les deux dée sont pareil
	 */
	public boolean equals(DeA6Faces obj)
	{
		return (faceVisible == obj.faceVisible);
	}

	/**
	 * Retourne la valeur de la face visible sous cette forme: [3]
	 * 
	 * @return - le string sous cette forme [0]
	 */
	public String toString()
	{
		return ("[" + faceVisible + "]");
	}

	/**
	 * Sert à tester nos méthodes
	 * 
	 * @param args - ?
	 */
	public static void main(String[] args)
	{
		DeA6Faces test = new DeA6Faces((byte) 6);
		System.out.println(test);
		/*
		 * int[] tally = {0,0,0,0,0,0}; for (int i = 0; i < 1000; i++) {
		 * test.brasser(); tally[test.getFaceVisible()-1]++; }
		 * System.out.println("["+tally[0]+", "+tally[1]+", "+tally[2]+", "
		 * +tally[3]+", "+tally[4]+", "+tally[5]+"]");
		 */
	}
}
