package jdr.personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jdr.combat.BasicAttaque;
import jdr.interfaces.Attaque;

public class Classe {
	
	private String nom;
	private List<Attaque> listeAttaque = new ArrayList<>();
	
	public Classe() {
		
	}

	public Classe(String nom, List<Attaque> listeAttaque) {
		super();
		this.nom = nom;
		this.listeAttaque = listeAttaque;
	}

	public List<Attaque> getListeAttaque() {
		return listeAttaque;
	}

	public void setListeAttaque(List<Attaque> listeAttaque) {
		this.listeAttaque = listeAttaque;
	}
	
	public Attaque getAttaque() {
		int max = this.listeAttaque.size();
		int nbAleatoire = new Random().nextInt(max);
		Attaque attaque = listeAttaque.get(nbAleatoire);
		return attaque;
	}

	@Override
	public String toString() {
		return "Classe [nom=" + nom + ", listeAttaque=" + listeAttaque + "]";
	}
	
	

}