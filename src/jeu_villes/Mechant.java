package jeu_villes;

public class Mechant {
	
	//attributs
	private int id;
	private int degat;
	private int vie;
	
	//constructeur
	public Mechant(int id, int degat, int vie) {
		super();
		this.id = id;
		this.degat = degat;
		this.vie = vie;
	}
	
	//getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDegat() {
		return degat;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}

	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}

	
	
	
}
