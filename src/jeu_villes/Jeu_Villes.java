package jeu_villes;

import java.util.Scanner;

public class Jeu_Villes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Secteur secteurs[] = genererMonde();
		
		demarrerPartie(secteurs);
		
		for (int i=1;i<21;i++) {
			System.out.println("tour " + i + "/20");
			boolean gameover = displayMenu(secteurs);
			if (gameover == true) break;
		}
		System.out.println("Votre score final est représenté par votre puissance");
		Menu.calculPuissance(secteurs);
					
	}

	public static Secteur[] genererMonde()
	{
		int nbSecteur = 3;
		
		Ressource nourriture = new Ressource(0, "Nourriture", "La nourriture c'est bien");
		Ressource carburant = new Ressource(1, "Carburant", "Le carburant ca pollue");
		Ressource munitions = new Ressource(2, "Munitions", "Les munitions c'est cool");
		
		Batiment entrepot1 = new Batiment("Entrepot", nourriture, "contient de la nourriture", 10, 200);
		Batiment station1 = new Batiment("Station", carburant, "contient du carburant", 10, 100);
		Batiment arsenal1 = new Batiment("Arsenal", munitions, "contient des munitions", 10, 150);
		
		Batiment entrepot2 = new Batiment("Entrepot", nourriture, "contient de la nourriture", 15, 200);
		Batiment station2 = new Batiment("Station", carburant, "contient du carburant", 15, 100);
		Batiment arsenal2 = new Batiment("Arsenal", munitions, "contient des munitions", 15, 150);
		
		Batiment entrepot3 = new Batiment("Entrepot", nourriture, "contient de la nourriture", 20, 200);
		Batiment station3 = new Batiment("Station", carburant, "contient du carburant", 20, 100);
		Batiment arsenal3 = new Batiment("Arsenal", munitions, "contient des munitions", 20, 150);
		
		Mechant m1 = new Mechant(5,10);
		Mechant m2 = new Mechant(10,20);
		Mechant m3 = new Mechant(15,15);
		Mechant m4 = new Mechant(15,25);
		Mechant m5 = new Mechant(20,35);
		Mechant m6 = new Mechant(25,50);
		Mechant m7 = new Mechant(30,55);
		Mechant m8 = new Mechant(45,70);
		Mechant m9 = new Mechant(80,100);
		
		entrepot1.addMechant(m1);
		entrepot2.addMechant(m2);
		entrepot3.addMechant(m5);
		
		station1.addMechant(m3);
		station2.addMechant(m4);
		station3.addMechant(m6);
		
		arsenal1.addMechant(m7);
		arsenal2.addMechant(m8);
		arsenal3.addMechant(m9);
		
		
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
				secteurs[j].getVilles()[i].construireBatiment(entrepot3);
				secteurs[j].getVilles()[i].construireBatiment(station3);
				secteurs[j].getVilles()[i].construireBatiment(arsenal3);
			}
			
		}
				
		return secteurs;
	}
	
	public static void demarrerPartie(Secteur [] secteurs) {
		int choix = 0;
		do {
		System.out.println("Avec quel secteur souhaitez-vous débuter ?");
		System.out.println("1 - Secteur Ouest (niveau facile)");
		System.out.println("2 - Secteur Sud (niveau intermediaire)");
		System.out.println("3 - Secteur NordEst (niveau difficile)");
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
	public static boolean displayMenu(Secteur [] secteurs) {
		boolean gameover;
		int choix = 0;
		System.out.println("Que souhaitez-vous faire ?");
		System.out.println("1 - Afficher secteurs");
		System.out.println("2 - Afficher ville");
		System.out.println("3 - Attaquer ville");
		System.out.println("4 - Calculer puissance");
		System.out.println("5 - Afficher batiments/méchants");
		System.out.println("6 - Ameliorer un batiment");
		Scanner input = new Scanner(System.in);
		choix = input.nextInt();
		if (choix == 1) {
			Menu.menuDisplaySecteur(secteurs);
		}
		else if (choix == 2) {
			Menu.menuDisplayVille(secteurs);
		}
		
		else if (choix == 3) {
			gameover = Menu.menuAttaquerBatimentMechant(secteurs);
			return gameover;
		}
		else if (choix == 4) {
			Menu.calculPuissance(secteurs);
		}
		else if (choix == 5) {
			Menu.menuDisplayBatimentMechant(secteurs);
		}
		else if (choix == 6) {
			Menu.menuAmeliorerBatiment(secteurs);
		}
		return gameover = false;
	}
}
