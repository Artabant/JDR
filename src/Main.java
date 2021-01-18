import java.util.Scanner;

import jdr.monde.Monde;
import jdr.personnage.Personnage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage joueur = Monde.personnageFactory();
		Monde.afficherInformations(joueur);
	}
	
	
}
