package jdr.groupe;

import java.util.ArrayList;
import java.util.List;

import jdr.interfaces.Combattant;

public class Groupe implements Combattant {
	
	private List<Combattant> listeCombattant = new ArrayList<>();
	
	public void addCombattant(Combattant combattant) {
		this.listeCombattant.add(combattant);
	}
	
	public boolean estMort() {
		int nombreMort = 0;
		for (Combattant combattant : listeCombattant) {
			if (combattant.getPointDeVie() < 0) {
				nombreMort++;
			}
		}
		if (nombreMort == listeCombattant.size()) {
			return true;
		}
		return false;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDegats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPointDeVie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDegats(int degats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPointDeVie(int pointDeVie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attaquer(Combattant adversaire) {
		
		
	}

	@Override
	public void defendre(int degats) {
		// TODO Auto-generated method stub
		
	}


}
