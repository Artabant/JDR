package jdr.personnage;

import jdr.interfaces.Combattant;

public class Personnage extends AbstractCombattant{
	
	private Classe classe;
	
	public Personnage() {

	}
	
	public Personnage(String nom, int pointDeVie, int degats) {
		super(nom, pointDeVie, degats);
		this.nom = nom;
		this.pointDeVie = pointDeVie;
		this.degats = degats;
	}
	
	public Personnage(String nom, int pointDeVie, Classe classe) {
		super(nom, pointDeVie);
		this.nom = nom;
		this.pointDeVie = pointDeVie;
		this.classe = classe;
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
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Personnage [nom=" + this.nom + ", pointDeVie=" + this.pointDeVie + ", degat=" + this.degats + ", classe="+this.classe+"]";
	}
	
	@Override
	public void attaquer(Combattant adversaire) {	
		
		this.degats = this.classe.getAttaque().getDegats();
		System.out.println("["+this.nom+"] attaque : "+adversaire.getNom()+" avec "+this.classe.getAttaque().getNom()+" "+this.degats);
		adversaire.defendre(this.classe.getAttaque().LancerAttaque(this, adversaire));
		System.out.println("PV du monstre : "+adversaire.getPointDeVie());
	}

}