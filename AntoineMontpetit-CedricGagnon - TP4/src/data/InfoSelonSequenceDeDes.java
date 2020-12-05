package data;

/**
 * Classe de services sur une séquence de dés
 * 
 * @author Antoine
 *
 * @version automne 2020
 */
public class InfoSelonSequenceDeDes
{

	/**
	 * Retourne le pointage selon la séquence de dés reçue
	 * 
	 * @param sequence - type de sequence a get le pointage
	 * @return - le pointage
	 */
	public static int pointage(SequenceDeDes sequence)
	{
		int pointage = 0;
		if (sequence != null)
		{
			switch (sequence)
			{
				case BRELAN:
					pointage = 40;
					break;
				case CINQ_EGAUX:
					pointage = 100;
					break;
				case DEUX_PAIRES:
					pointage = 20;
					break;
				case FULL:
					pointage = 60;
					break;
				case QUATRE_EGAUX:
					pointage = 70;
					break;
				case SERIE_COURTE:
					pointage = 30;
					break;
				case SERIE_LONGUE:
					pointage = 50;
					break;
				case UNE_PAIRE:
					pointage = 10;
					break;
			}
		}

		return pointage;
	}

	/**
	 * Retourne un message selon la séquence de dés reçue.
	 * 
	 * @param sequence - type de sequence a get le message
	 * @return - le message
	 */
	public static String message(SequenceDeDes sequence)
	{
		String message = "Vous n'avez rien";
		if (sequence != null)
		{
			switch (sequence)
			{
				case BRELAN:
					message = "Vous avez trois dés pareils";
					break;
				case CINQ_EGAUX:
					message = "Vous avez cinq dés pareils";
					break;
				case DEUX_PAIRES:
					message = "Vous avez deux paires";
					break;
				case FULL:
					message = "Vous avez un brelan plus une paire";
					break;
				case QUATRE_EGAUX:
					message = "Vous avez quatre dés pareils";
					break;
				case SERIE_COURTE:
					message = "Vous avez une série courte";
					break;
				case SERIE_LONGUE:
					message = "Vous avez une série longue";
					break;
				case UNE_PAIRE:
					message = "Vous avez une paire";
					break;
			}
		}

		return message;
	}
}
