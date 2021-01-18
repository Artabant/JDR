package jdr.personnage;

public class Personnage extends AbstractCombattant{

	private int pointDeVie;
	private int degat;
	private String nom;
	
	public Personnage(String nom, int pointDeVie, int degats) {
		super(nom, pointDeVie, degats);
		this.nom = nom;
		this.pointDeVie = pointDeVie;
		this.degats = degats;
	}
	
	public int getPointDeVie() {
		return pointDeVie;
	}
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}
	public int getDegat() {
		return degat;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Personnage [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + ", degat=" + this.degat + "]";
	}
	
	

}
