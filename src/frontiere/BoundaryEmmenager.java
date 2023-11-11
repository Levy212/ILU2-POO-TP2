package frontiere;

import controleur.ControlEmmenager;
import personnages.Gaulois;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois "+nomVisiteur+"\n");
					question = new StringBuilder();
					question.append("Quelle est votre force ?\n");
					int force = Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide "+ nomVisiteur);
		String question = "Quelle est votre force ?\n";
		int force  = Clavier.entrerEntier(question);
		int effetPotionMax;
		int effetPotionMin;
		do {
			question = "Quelle est la force de potion la plus "
					+"faible que vous produisez ?\n";
			effetPotionMin = Clavier.entrerEntier(question);
			question = "Quelle est la force de potion la plus "
					+"forte que vous produisez ?\n";
			effetPotionMax = Clavier.entrerEntier(question);
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le min et le max\n");
			}
			
		}while(effetPotionMax<effetPotionMin);
		controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
