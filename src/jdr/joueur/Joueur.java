package jdr.joueur;

import jdr.personnage.Personnage;

public class Joueur {
	
	private String nom;
	private String prenom;
	private Personnage personnage;
	
	public Joueur() {

	}
	
	public Joueur(String nom, String prenom, Personnage personnage) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.personnage = personnage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Personnage getPersonnage() {
		return personnage;
	}
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", personnage=" + personnage + "]";
	}
	

}
