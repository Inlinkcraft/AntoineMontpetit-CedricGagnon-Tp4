package data;

public class DeA6Faces
{
	private static byte FACE_MAX = 6;
	private static Byte FACE_MIN = 1;
	private byte faceVisible;
	static byte NBR_FACES = 6;

	public DeA6Faces()
	{
	}

	public DeA6Faces(byte valeur)
	{
	}

	public byte getFaceVisible()
	{
	}

	private void setFaceVisible(byte valeur)
	{
	}

	private boolean validerFaceVisible(byte valeur)
	{
	}

	public void brasser()
	{
		faceVisible=(byte)(Math.random()*(FACE_MAX-FACE_MIN+1)+FACE_MIN);
	}

	public boolean equals(DeA6Faces obj)
	{
		return(faceVisible==obj.faceVisible);
	}

	public String toString()
	{
		return("["+faceVisible+"]");
	}

	public static void main(String[] args)
	{
		DeA6Faces test = new DeA6Faces();
		/*for(int i=0;i<100;i++) {
			test.brasser();
			System.out.println(test.faceVisible);
		}*/
			
	}
}
