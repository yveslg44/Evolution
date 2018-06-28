package jeu_villes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Batiment {
	
	//attributs
	private int compteur = 0;
	private int id;
	private String nom;
	private Ressource ressource;
	private String description;
	private List<Mechant> mechants;
	private int Stock;
	private int Vie;
	
	//constructeur
	public Batiment(String nom, Ressource ressource, String description, Mechant mechants, int stock,
			int vie) {
		super();
		compteur++;
		this.id = compteur;
		this.nom = nom;
		this.ressource = ressource;
		this.description = description;
		this.mechants.add(mechants);
		this.Stock = stock;
		this.Vie = vie;
	}

	//constructeur
		public Batiment(String nom, Ressource ressource, String description, int stock,
				int vie) {
			super();
			this.id = id;
			this.nom = nom;
			this.ressource = ressource;
			this.description = description;
			this.mechants = new ArrayList<Mechant>();
			this.Stock = stock;
			this.Vie = vie;
		}
	
	//getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ressource getRessource() {
		return ressource;
	}
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Mechant> getMechant() {
		return mechants;
	}
	public void setMechant(List<Mechant> mechants) {
		this.mechants = mechants;
	}

	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		this.Stock = stock;
	}

	public int getVie() {
		return Vie;
	}
	public void setVie(int vie) {
		this.Vie = vie;
	}
	
//	public void addRessource(Ressource ressource)
//	{
//		this.ressource = ressource;
//	}
//
	
	public void addMechant(Mechant mechant)
	{
		this.mechants.add(mechant);
	}
	
	public void displayBatiment(Batiment batiment) {
		System.out.println("Nom : " + batiment.getNom());
		Iterator it = batiment.getMechant().iterator();
		while (it.hasNext())
		{
			Mechant mechant = (Mechant) it.next();
			System.out.println("mechant n° " + mechant.getId() + " - degat : " + mechant.getDegat() + " - vie : " + mechant.getVie());
		}
				
	}
	
	public void removeMechant(Mechant mechant)
	{
		this.mechants.remove(mechant);
	}
	
	public boolean attaquerBatiment(Batiment batiment, int puissance) {
		boolean gameover = false;
		Scanner input = new Scanner (System.in);
		String reponse = " ";
		int vieJoueur = puissance;
		do {		
		if (batiment.mechants.size() == 0) {
			System.out.println("Le batiment est vide, il est à vous");
		}
		else {
			int defense = batiment.getMechant().get(0).getVie();
			if (puissance >= defense)
			{
				System.out.println("Vous avez tué le méchant niveau " + batiment.getMechant().get(0).getId());
				batiment.removeMechant(batiment.getMechant().get(0));
				if (batiment.mechants.size() == 0) {
					System.out.println("Le batiment est vide, il est à present à vous");
					continue;
				}
			}
			else if (puissance < defense)
			{
				batiment.getMechant().get(0).setVie(defense - puissance);
				System.out.println("Vous avez touché le méchant niveau " + batiment.getMechant().get(0).getId() + ", il lui reste une vie de " + batiment.getMechant().get(0).getVie());
				System.out.println("Le méchant riposte !");
				vieJoueur = vieJoueur - batiment.getMechant().get(0).getDegat();
				System.out.println("Il vous a infligé des degats de " + batiment.getMechant().get(0).getDegat() + ", votre vie restante est de " + vieJoueur);
				if (vieJoueur <= 0) {
					System.out.println("GAME OVER !");
					return gameover = true;
				}
					
			}			
		}
		System.out.println("Voulez-vous continuer à attaquer ou fuir ? (a/f)");
		reponse = input.nextLine();
		} while (reponse.equals("a") && batiment.mechants.size() != 0 && vieJoueur >= 0);
		return gameover = false;
	}
	
	public void verifierToutBatimentVide()
	{
		
	}
}
