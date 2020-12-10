package tests_prof_conforme;

public class UtilTest
{
	private String nomClasse;
	private int totalDesPoints = 0;
	private int cumulatifPoints = 0;
	private int nbrCasDeTests = 0;

	public UtilTest(String nomClasse)
	{
		super();
		this.nomClasse = nomClasse;
	}

	public String getNomClasse()
	{
		return this.nomClasse;
	}

	public int getTotalDesPoints()
	{
		return totalDesPoints;
	}

	public void setTotalDesPoints(int totalDesPoints)
	{
		this.totalDesPoints = totalDesPoints;
	}

	public int getCumulatifPoints()
	{
		return cumulatifPoints;
	}

	public void setCumulatifPoints(int cumulatifPoints)
	{
		this.cumulatifPoints = cumulatifPoints;
	}

	public int getNbrCasDeTests()
	{
		return nbrCasDeTests;
	}

	public void setNbrCasDeTests(int nbrCasDeTests)
	{
		this.nbrCasDeTests = nbrCasDeTests;
	}

	public void addTotal()
	{
		this.totalDesPoints++;
	}

	public void addTotal(int plus)
	{
		this.totalDesPoints += plus;
	}

	public void addCumul()
	{
		this.cumulatifPoints++;
	}

	public void addCumul(int plus)
	{
		this.cumulatifPoints += plus;
	}

	public void addCas()
	{
		this.nbrCasDeTests++;
	}

	public void addCas(int plus)
	{
		this.nbrCasDeTests += plus;
	}

	public void affStat()
	{
		System.out.println("\n" + this + "\n\n");
	}

	public String toString()
	{
		return this.getNomClasse() + ": Pour " + this.getNbrCasDeTests()
				+ " cas de tests vous avez : " + this.getCumulatifPoints() + "/"
				+ this.getTotalDesPoints();
	}

	public void affDebut()
	{
		System.out.println("Début : " + UtilTest.getMethodeName());
	}

	public void affFin()
	{
		System.out.println("Fin : " + UtilTest.getMethodeName());
	}

	/**
	 *
	 * @return Renvoie le nom de la fonction que l'on est en train d'executer
	 *         précédé par le package de la class de la fonction
	 */
	private static String getMethodeFullName()
	{
		Throwable t = new Throwable();
		t.fillInStackTrace();
		StackTraceElement e = t.getStackTrace()[2];
		String className = e.getClassName();
		String functionName = e.getMethodName();
		return className + "." + functionName;
	}

	/**
	 *
	 * @return Renvoie le nom de la fonction que l'on est en train d'executer
	 */
	private static String getMethodeName()
	{
		Throwable t = new Throwable();
		t.fillInStackTrace();
		StackTraceElement e = t.getStackTrace()[2];
		String functionName = e.getMethodName();
		return functionName;
	}

}
