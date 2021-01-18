package jdr.combat;

import java.util.Random;

import jdr.interfaces.Attaque;
import jdr.interfaces.Combattant;

public class BasicAttaque implements Attaque{
	
	private String nom;
	private String description;
	private double chanceToucher;
	private int degats;

	public BasicAttaque(String nom, String description, double chanceToucher, int degats) {
		super();
		this.nom = nom;
		this.description = description;
		this.chanceToucher = chanceToucher;
		this.degats = degats;
	}

	@Override
	public int LancerAttaque(Combattant lanceur, Combattant cible) {
		int nbAleatoire = new Random().nextInt(100);
		if (nbAleatoire < chanceToucher) {
			return lanceur.getDegats();
		}
		
		return 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getChanceToucher() {
		return chanceToucher;
	}

	public void setChanceToucher(double chanceToucher) {
		this.chanceToucher = chanceToucher;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}


	

}
