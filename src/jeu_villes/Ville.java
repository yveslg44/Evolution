package jeu_villes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ville {
	
	//attributs
	private int id;
	private String nom;
	private List<Batiment> batiments;
	private String etat;
	
	//constructeur
	public Ville(int id, String nom, Batiment batiments, String etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.batiments.add(batiments);
		this.etat = etat;
	}
	
	//constructeur
		public Ville(int id, String nom, String etat) {
			super();
			this.id = id;
			this.nom = nom;
			this.batiments = new ArrayList<Batiment>();
			this.etat = etat;
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

	public List<Batiment> getBatiments() {
		return batiments;
	}
	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}

	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public void construireBatiment(Batiment batiment)
	{
		this.batiments.add(batiment);
	}
	
	public void detruireBatiment(Batiment batiment)
	{
		this.batiments.remove(batiment);
	}
	
	public void ameliorerBatiment(Batiment batiment1, Batiment batiment2)
	{
		this.batiments.remove(batiment1);
		this.batiments.add(batiment2);
	}
	
//	public void addBatiment(int index, Batiment batiment) {
//		this.batiments.add(batiment);
//	}
	
	public void displayVille(Ville ville) {
		System.out.println("Nom : " + ville.getNom());
		System.out.println("Etat : " + ville.getEtat());
		Iterator it = ville.getBatiments().iterator();
		while (it.hasNext())
		{
			Batiment batiment = (Batiment) it.next();
			System.out.println(batiment.getNom() + " - stock : " + batiment.getStock() + " - vie : " + batiment.getVie());
		}
				
	}
	

	public void verifierVilleGagnee(Ville ville) {
		if (ville.getBatiments().get(0).getMechant().size() == 0 
			&& ville.getBatiments().get(1).getMechant().size() == 0
			&& ville.getBatiments().get(2).getMechant().size() == 0) 
		{
			System.out.println("Tous les batiments de la ville sont libérés !");
			System.out.println("Vous avez conquis " + ville.getNom() + " !!!");
			ville.setEtat("Gagnée");
		}
	}
	
	public void ameliorerBatiment(Ville ville, int choixBat) {
		if (!ville.getEtat().equals("Gagnée")) {
			System.out.println("Cette ville n'a pas été conquise !");
		}
		else {
			Random r = new Random();
			int valeur = 2 + r.nextInt(10 - 2);
			ville.getBatiments().get(choixBat).setStock(ville.getBatiments().get(choixBat).getStock() + valeur);
			System.out.println("Vous avez augmenté la capacité de ce batiment de " + valeur);
			System.out.println("Le stock est à présent de " + ville.getBatiments().get(choixBat).getStock());
		}
	}
}
