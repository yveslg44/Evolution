package jeu_villes;

import java.util.Scanner;

public class Jeu_Villes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Secteur secteurs[] = genererMonde();
		
		demarrerPartie(secteurs);
		
		for (int i=0;i<21;i++) {
			displayMenu(secteurs);
		}
					
	}

	public static Secteur[] genererMonde()
	{
		int nbSecteur = 3;
		
		Ressource nourriture = new Ressource(0, "Nourriture", "La nourriture c'est bien");
		Ressource carburant = new Ressource(1, "Carburant", "Le carburant ca pollue");
		Ressource munitions = new Ressource(2, "Munitions", "Les munitions c'est cool");
		
		Batiment entrepot = new Batiment(0, "Entrepot", nourriture, "contient de la nourriture", 10, 200);
		Batiment station = new Batiment(1, "Station", carburant, "contient du carburant", 10, 100);
		Batiment arsenal = new Batiment(2, "Arsenal", munitions, "contient des munitions", 10, 150);
		
		Mechant averell = new Mechant(0,5,10);
		Mechant william = new Mechant(1,10,20);
		Mechant jack = new Mechant(2,15,15);
		Mechant joe = new Mechant(3,15,25);
		
		entrepot.addMechant(averell);
		entrepot.addMechant(william);
		entrepot.addMechant(jack);
		
		station.addMechant(averell);
		station.addMechant(william);
		station.addMechant(joe);
		
		arsenal.addMechant(jack);
		arsenal.addMechant(william);
		arsenal.addMechant(joe);
		
		
		Secteur [] secteurs = new Secteur [nbSecteur]; 
		
		secteurs [0] = new Secteur (0, "Secteur Ouest");
		secteurs [0].addVille(0, new Ville (0, "Rennes", "Perdue"));
		secteurs [0].addVille(1, new Ville (1, "Nantes", "Perdue"));
		secteurs [0].addVille(2, new Ville (2, "Bordeaux", "Perdue"));
		
		secteurs [1] = new Secteur (1, "Secteur Sud");
		secteurs [1].addVille(0, new Ville (0, "Toulouse", "Perdue"));
		secteurs [1].addVille(1, new Ville (1, "Nice", "Perdue"));
		secteurs [1].addVille(2, new Ville (2, "Marseille", "Perdue"));
		
		secteurs [2] = new Secteur (2, "Secteur NordEst");
		secteurs [2].addVille(0, new Ville (0, "Paris", "Perdue"));
		secteurs [2].addVille(1, new Ville (1, "Lille", "Perdue"));
		secteurs [2].addVille(2, new Ville (2, "Strasbourg", "Perdue"));
		
		for (int j=0; j<3; j++) {
			for (int i=0; i<3; i++) {
				secteurs[j].getVilles()[i].construireBatiment(entrepot);
				secteurs[j].getVilles()[i].construireBatiment(station);
				secteurs[j].getVilles()[i].construireBatiment(arsenal);
			}
		}
				
		return secteurs;
	}
	
	public static void demarrerPartie(Secteur [] secteurs) {
		int choix = 0;
		do {
		System.out.println("Avec quel secteur souhaitez-vous débuter ?");
		System.out.println("1 - Secteur Ouest");
		System.out.println("2 - Secteur Sud");
		System.out.println("3 - Secteur NordEst");
		Scanner input = new Scanner(System.in);
		choix = input.nextInt();
		} while (choix != 1 && choix !=2 && choix !=3); 
		if (choix == 1) {
			System.out.println("vous avez choisi le secteur Ouest");
			for (int i=0; i<3; i++) {
				secteurs[0].getVilles()[i].setEtat("Gagnée");
				
			}
		}
			
		if (choix == 2) {
			System.out.println("vous avez choisi le secteur Sud");
			for (int i=0; i<3; i++) {
				secteurs[1].getVilles()[i].setEtat("Gagnée");
				
			}
		}
		if (choix == 3) {
			System.out.println("vous avez choisi le secteur NordEst");
			for (int i=0; i<3; i++) {
				secteurs[2].getVilles()[i].setEtat("Gagnée");
				
			}
		}	
	}
	public static void displayMenu(Secteur [] secteurs) {
		int choix = 0;
		System.out.println("Que souhaitez-vous faire ?");
		System.out.println("1 - Afficher secteurs");
		System.out.println("2 - Afficher ville");
		System.out.println("3 - Attaquer ville");
		System.out.println("4 - Calculer puissance");
		System.out.println("5 - Afficher batiments/méchants");
		Scanner input = new Scanner(System.in);
		choix = input.nextInt();
		if (choix == 1) {
			Menu.menuDisplaySecteur(secteurs);
		}
		else if (choix == 2) {
			Menu.menuDisplayVille(secteurs);
		}
		
		else if (choix == 3) {
			Menu.menuAttaquerBatimentMechant(secteurs);
		}
		else if (choix == 4) {
			Menu.calculPuissance(secteurs);
		}
		else if (choix == 5) {
			Menu.menuDisplayBatimentMechant(secteurs);
		}
		
	}
}
