package jeu_villes;

import java.util.Scanner;

public class Menu {
	
//	public static int menuMechant(int choix, Batiment batiment)
//	{
//		batiment.getMechant().get(choix);
//	}

	public static void menuDisplaySecteur(Secteur [] secteurs) {
		
			for (int j=0; j<3; j++) {
				for (int i=0; i<3; i++) {
					System.out.println(secteurs[j].getNom()+ " - " + secteurs[j].getVilles()[i].getNom() +" : " +secteurs[j].getVilles()[i].getEtat());
				}
				System.out.println();
			}		
	}
	
	public static void menuDisplayVille (Secteur [] secteurs) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choississez le secteur de la carte");
		System.out.println("1 - Secteur Ouest");
		System.out.println("2 - Secteur Sud");
		System.out.println("3 - Secteur NordEst");
		int secteurid = input.nextInt() - 1;
		for (int i=0;i<3;i++) {
			System.out.println(i+1 + " " +secteurs[secteurid].getVilles()[i].getNom());
		}
		System.out.println("Choississez une ville (1,2 ou 3)");
		int villeid = input.nextInt() - 1;
		secteurs[secteurid].getVilles()[villeid].displayVille(secteurs[secteurid].getVilles()[villeid]);
	}
	
	public static void menuAttaquerVille (Secteur [] secteurs) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choississez le secteur de la carte");
		System.out.println("1 - Secteur Ouest");
		System.out.println("2 - Secteur Sud");
		System.out.println("3 - Secteur NordEst");
		int secteurid = input.nextInt() - 1;
		for (int i=0;i<3;i++) {
			System.out.println(i+1 + " " +secteurs[secteurid].getVilles()[i].getNom());
		}
		System.out.println("Choississez une ville (1,2 ou 3)");
		int villeid = input.nextInt() - 1;
		secteurs[secteurid].attaquerVille(secteurs[secteurid].getVilles()[villeid]);
	}
	
	public static void calculPuissance(Secteur [] secteurs) {
		int puissance = 0;
		for (int j=0; j<3; j++) {
			for (int i=0; i<3; i++) {
				if (secteurs[j].getVilles()[i].getEtat().equals("Gagnée")) {
					puissance = puissance + secteurs[j].getVilles()[i].getBatiments().get(i).getStock();
				}
			}
		}
		System.out.println("La puissance est calculée à partir de vos stocks");
		System.out.println("Votre puissance actuelle est de : " + puissance);
	}
	
	public static void menuDisplayBatimentMechant (Secteur[] secteurs) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choississez le secteur de la carte");
		System.out.println("1 - Secteur Ouest");
		System.out.println("2 - Secteur Sud");
		System.out.println("3 - Secteur NordEst");
		int secteurid = input.nextInt() - 1;
		for (int i=0;i<3;i++) {
			System.out.println(i+1 + " " +secteurs[secteurid].getVilles()[i].getNom());
		}
		System.out.println("Choississez une ville (1,2 ou 3)");
		int villeid = input.nextInt() - 1;
		secteurs[secteurid].getVilles()[villeid].displayVille(secteurs[secteurid].getVilles()[villeid]);
		for (int i=0;i<3;i++) {
			System.out.println(i + " " +secteurs[secteurid].getVilles()[villeid].getBatiments().get(i).getNom() + ", " + secteurs[secteurid].getVilles()[villeid].getBatiments().get(i).getDescription());
		}
		System.out.println("Choississez un batiment pour voir les méchants présents (0, 1 ou 2)");
		int batimentid = input.nextInt();
		secteurs[secteurid].getVilles()[villeid].getBatiments().get(batimentid).displayBatiment(secteurs[secteurid].getVilles().clone()[villeid].getBatiments().get(batimentid));
	}
	
	public static boolean menuAttaquerBatimentMechant (Secteur[] secteurs) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choississez le secteur de la carte");
		System.out.println("1 - Secteur Ouest");
		System.out.println("2 - Secteur Sud");
		System.out.println("3 - Secteur NordEst");
		int secteurid = input.nextInt() - 1;
		for (int i=0;i<3;i++) {
			System.out.println(i+1 + " " +secteurs[secteurid].getVilles()[i].getNom());
		}
		System.out.println("Choississez une ville (1,2 ou 3)");
		int villeid = input.nextInt() - 1;
		secteurs[secteurid].getVilles()[villeid].displayVille(secteurs[secteurid].getVilles()[villeid]);
		for (int i=0;i<3;i++) {
			System.out.println(i + " " +secteurs[secteurid].getVilles()[villeid].getBatiments().get(i).getNom() + ", " + secteurs[secteurid].getVilles()[villeid].getBatiments().get(i).getDescription());
		}
		System.out.println("Choississez un batiment à attaquer (0, 1 ou 2)");
		int batimentid = input.nextInt();
		boolean gameover = secteurs[secteurid].getVilles()[villeid].getBatiments().get(batimentid).attaquerBatiment(secteurs[secteurid].getVilles().clone()[villeid].getBatiments().get(batimentid), getPuissance(secteurs));
		secteurs[secteurid].getVilles()[villeid].verifierVilleGagnee(secteurs[secteurid].getVilles()[villeid]);
		return gameover;
	}
	
	public static int getPuissance(Secteur [] secteurs) {
		int puissance = 0;
		for (int j=0; j<3; j++) {
			for (int i=0; i<3; i++) {
				if (secteurs[j].getVilles()[i].getEtat().equals("Gagnée")) {
					puissance = puissance + secteurs[j].getVilles()[i].getBatiments().get(i).getStock();
				}
			}
		}
		return puissance;
	}
	
	public static void menuAmeliorerBatiment(Secteur [] secteurs) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choississez le secteur de la carte");
		System.out.println("1 - Secteur Ouest");
		System.out.println("2 - Secteur Sud");
		System.out.println("3 - Secteur NordEst");
		int secteurid = input.nextInt() - 1;
		for (int i=0;i<3;i++) {
			System.out.println(i+1 + " " +secteurs[secteurid].getVilles()[i].getNom());
		}
		System.out.println("Choississez une ville (1,2 ou 3)");
		int villeid = input.nextInt() - 1;
		secteurs[secteurid].getVilles()[villeid].displayVille(secteurs[secteurid].getVilles()[villeid]);
		for (int i=0;i<3;i++) {
			System.out.println(i + " " +secteurs[secteurid].getVilles()[villeid].getBatiments().get(i).getNom() + ", " + secteurs[secteurid].getVilles()[villeid].getBatiments().get(i).getDescription());
		}
		System.out.println("Choississez un batiment à améliorer (0, 1 ou 2)");
		int batimentid = input.nextInt();
		secteurs[secteurid].getVilles()[villeid].ameliorerBatiment(secteurs[secteurid].getVilles()[villeid], batimentid);
	}
}
