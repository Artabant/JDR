package jdr.combat;

import jdr.interfaces.Attaque;
import jdr.interfaces.Combattant;

public class BasicAttaque implements Attaque{
	
	private String nom;
	private String description;
	private double chanceToucher;
	private int degats;

	@Override
	public int LancerAttaque(Combattant lanceur, Combattant cible) {
		// TODO Auto-generated method stub
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
