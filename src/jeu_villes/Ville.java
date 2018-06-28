package jeu_villes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
//	public void attaquerBatiment(Batiment batiment, int puissance) {
//		int defense = batiment.getMechant().get(0).getVie();
//		if (puissance >= defense)
//		{
//			batiment.removeMechant(batiment.getMechant().get(0));
//			System.out.println("Vous avez tué le méchant n° " + batiment.getMechant().get(0).getId());
//		}
//		else if (puissance < defense)
//		{
//			batiment.getMechant().get(0).setVie(defense - puissance);
//			System.out.println("Vous avez touché le méchant n° " + batiment.getMechant().get(0).getId() + ", il lui resteune vie de " + batiment.getMechant().get(0).getVie());
//		}
//	}
}
