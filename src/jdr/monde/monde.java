package jdr.monde;

import java.util.Scanner;

import jdr.personnage.Personnage;

public class monde {
	
		public static Personnage personnageFactory() {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez choisir un nom");
			String nom = sc.nextLine();
			System.out.println("Veuillez entrer vos point de vie");
			int pointDeVie = sc.nextInt();
			System.out.println("Veuillez entrer vos point de degat");
			int degat = sc.nextInt();
			Personnage joueur = new Personnage(pointDeVie,degat,nom) ; 
			sc.close();
			return joueur;
		
		}
		
		public static void afficherInformations(Personnage joueur) {
			System.out.println(joueur);
		}

}
