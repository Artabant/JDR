import java.util.Scanner;

import jdr.groupe.Groupe;
import jdr.monde.Monde;
import jdr.personnage.Monstres;
import jdr.personnage.Personnage;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Personnage joueur = Monde.personnageFactory();
		//Monstres monstre = Monde.MonstreFactory();
		//Monde.afficherInformations(joueur, monstre);
		//Monde.combat(joueur, monstre);
		
		Monde.creationClasse();
		Groupe personnages = Monde.creationGroupePersonnage(4);
		Groupe monstres = Monde.creationGroupeMonstre(4);
		Monde.genese(personnages, monstres);

		
	}
}