import java.util.Scanner;

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
		Monde.generationClasse();
		Personnage joueur = Monde.personnageFactory();
		Monstres monstre = Monde.MonstreFactory();
		Monde.afficherInformations(joueur, monstre);
		Monde.combat(joueur, monstre);
	}
}
