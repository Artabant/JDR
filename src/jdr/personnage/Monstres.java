package jdr.personnage;

public class Monstres extends AbstractCombattant {

	public Monstres(String nom, int pointDeVie, int degats) {
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
	public int getDegats() {
		return degats;
	}
	public void setDegats(int degats) {
		this.degats = degats;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Monstre [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + ", degat=" + this.degats + "]";
	}
	
	public void pertePointDeVie(int pointDeDegatsEnemi) {
		this.pointDeVie = this.pointDeVie - pointDeDegatsEnemi;
	}
	
	
}
