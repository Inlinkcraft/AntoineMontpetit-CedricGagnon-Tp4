package data;

public class DeA6Faces
{
	private static final byte FACE_MAX = 6;
	private static final Byte FACE_MIN = 1;
	private byte faceVisible;
	public static final byte NBR_FACES = 6;

	public DeA6Faces()
	{
		this((byte) -1);
	}

	public DeA6Faces(byte valeur)
	{
		if (validerFaceVisible(valeur))
			faceVisible = valeur;
		else
			brasser();
	}

	public byte getFaceVisible()
	{
		return (faceVisible);
	}

	private void setFaceVisible(byte valeur)
	{
		if (validerFaceVisible(valeur))
		{
			faceVisible = valeur;
		}
	}

	private boolean validerFaceVisible(byte valeur)
	{
		return (valeur <= NBR_FACES && valeur > 0);
	}

	public void brasser()
	{
		setFaceVisible(
				(byte) (Math.random() * (FACE_MAX - FACE_MIN + 1) + FACE_MIN));
	}

	public boolean equals(DeA6Faces obj)
	{
		return (faceVisible == obj.faceVisible);
	}

	public String toString()
	{
		return ("[" + faceVisible + "]");
	}

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
