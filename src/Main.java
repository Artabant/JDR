import java.util.Scanner;

import jdr.personnage.Personnage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	
	public Personnage personnageFactory() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir un nom");
		String nom = sc.nextLine();
		System.out.println("Veuillez entrer vos point de vie");
		int pointDeVie = sc.nextInt();
		System.out.println("Veuillez entrer vos point de degat");
		int degat = sc.nextInt();
		Personnage joueur = new Personnage(pointDeVie,degat,nom) ; 
		return joueur;
	}

}
