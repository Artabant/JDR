package jdr.personnage;

import jdr.interfaces.Combattant;

public class Personnage extends AbstractCombattant{


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
	public int getDegats() {
		return degats;
	}
	public void setDegats(int degat) {
		this.degats = degat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Personnage [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + ", degat=" + this.degats + "]";
	}
	
	@Override
	public void attaquer(Combattant adversaire) {
		adversaire.defendre(this.getDegats());
		System.out.println("[Personnage] Vous avez fait : "+this.getDegats()+" point de degats");
	}

	@Override
	public void defendre(int degats) {
		this.pointDeVie = this.pointDeVie - degats;	
	}
	

}
