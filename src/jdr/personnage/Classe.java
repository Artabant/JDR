package jdr.personnage;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	
	private String nom;
	private List<String> listeAttaque = new ArrayList<>();
	
	public Classe() {
		
	}

	public Classe(String nom, List<String> listeAttaque) {
		super();
		this.nom = nom;
		this.listeAttaque = listeAttaque;
	}

	public List<String> getListeAttaque() {
		return listeAttaque;
	}

	public void setListeAttaque(List<String> listeAttaque) {
		this.listeAttaque = listeAttaque;
	}

}