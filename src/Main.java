import java.util.Scanner;

import jdr.monde.monde;
import jdr.personnage.Personnage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage joueur = monde.personnageFactory();
		monde.afficherInformations(joueur);
	}
	
	
}
