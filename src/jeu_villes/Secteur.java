package jeu_villes;

public class Secteur {
	
	//attributs
	private int id;
	private String nom;
	private Ville [] villes;
	
	//constructeur
	public Secteur(int id, String nom, Ville villes[]) {
		super();
		this.id = id;
		this.nom = nom;
		this.villes = villes;
	}
	//constructeur
	public Secteur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		this.villes = new Ville [3];
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

	public Ville[] getVilles() {
		return villes;
	}
	public void setVilles(Ville[] villes) {
		this.villes = villes;
	}
	
	public void addVille(int index, Ville ville) {
		this.villes[index] = ville;
	}
	
	public void attaquerVille(Ville ville) {
		if (ville.getEtat().equals("Perdue")) {
			ville.setEtat("Attaquée");
			System.out.println("Vous avez attaqué " + ville.getNom());
		}
		else if (ville.getEtat().equals("Attaquée")) {
			ville.setEtat("Gagnée");
			System.out.println("Vous avez conquis " + ville.getNom());
		}
	}

}
