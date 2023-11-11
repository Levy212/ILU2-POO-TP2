package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desolee "+ nomVendeur+" mais il faut"
					+ " etre un habitant de notre village pour commencer ici\n");
		}
		else {
			System.out.println("Bonjour "+ nomVendeur+" ,je vais "
					+ "regarder si je peux vous trouver un etal\n");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Desolee "+ nomVendeur+
						" je n'ai plus d'etal disponible\n");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un etal pour vous !\n");
		System.out.println("Il me faudrait qlq renseignements .\n");
		System.out.println("Quel produit souhaitez vous vendre\n");
		String produit = scan.next();
		String question = "Combien souhaitez-vous vendre ?";
		int nbProduit = Clavier.entrerEntier(question);
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numEtal!=1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installe à l'etal n^"+numEtal+1);
		}
		
	}
}
