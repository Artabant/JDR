package jdr.groupe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jdr.interfaces.Combattant;
import jdr.personnage.AbstractCombattant;
import jdr.personnage.Monstres;
import jdr.personnage.Personnage;

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
	
	public List<Combattant> getListeCombattant() {
		return listeCombattant;
	}

	public void setListeCombattant(List<Combattant> listeCombattant) {
		this.listeCombattant = listeCombattant;
	}

	public void attaquerGroupe(Groupe adversaires) {
		
		Combattant adversaire = adversaires.defence();
		
		int maxGroupe2 = this.listeCombattant.size();
		int nombreAleatoireGroupe2 = new Random().nextInt(maxGroupe2);		
		Combattant attaquant = adversaires.listeCombattant.get(nombreAleatoireGroupe2);
		
		if(attaquant instanceof Personnage) {
			
			attaquant.attaquer(adversaires);
		}else {
			
			attaquant.attaquer(adversaires);
		}
	}

	public Combattant defence() {
		
		int maxGroupe1 = this.listeCombattant.size();
		int nombreAleatoireGroupe1= new Random().nextInt(maxGroupe1);
		Combattant adversaire = this.listeCombattant.get(nombreAleatoireGroupe1);
		
		return adversaire;
		
	}

	@Override
	public void attaquer(Combattant adversaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defendre(int degats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Groupe [listeCombattant=" + listeCombattant + "]";
	}

	


}