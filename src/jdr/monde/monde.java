package jdr.monde;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import jdr.personnage.Monstres;
import jdr.personnage.Personnage;

public class Monde {
		
	/**
	 * Creation d'un personnage
	 * @return
	 */
	public static Personnage personnageFactory() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez choisir un nom : \n");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez entrer vos point de vie : \n");
		int pointDeVie = sc.nextInt();
		
		System.out.println("Veuillez entrer vos point de degat : \n");
		int degat = sc.nextInt();
		
		Personnage joueur = new Personnage(nom, pointDeVie, degat) ; 
		
		sc.close();
		
		return joueur;
		
	}
	
	
	
	/**
	 * Creation d'un monstre
	 * @return
	 */
	public static Monstres MonstreFactory()
	{
		
		Scanner sc = new Scanner(System.in);

		String nom = nomMonstre();
		
		System.out.println("Veuillez entrer vos point de vie : \n");
		int pointDeVie = sc.nextInt();
		
		System.out.println("Veuillez entrer vos point de degat : \n");
		int degat = sc.nextInt();
		
		Monstres monstre = new Monstres(nom, pointDeVie, degat) ; 
		
		sc.close();
		
		return monstre;
	}
	
	/**
	 * 
	 * @param joueur
	 */
	public static void afficherInformations(Personnage joueur, Monstres monstre) {
		System.out.println(joueur);
		System.out.println(monstre);
	}
	
	/**
	 * Genereation du nom du monstre
	 * @return nom
	 */
	public static String nomMonstre() {
		List<String> debutNom = new ArrayList<String>();
		debutNom.add("chat");
		debutNom.add("chien");
		debutNom.add("chaton");
		
		List<String> finNom = new ArrayList<String>();
		finNom.add("mechant");
		finNom.add("de feu");
		finNom.add("de la mort");
		
		int MaxDebutNom = debutNom.size();
		int nombreAleatoireListDebutNom = 0 + (int)(Math.random() * ((MaxDebutNom - 0) + 1));
		
		int MaxFinNom = finNom.size();
		int nombreAleatoireListFinNom = 0 + (int)(Math.random() * ((MaxFinNom - 0) + 1));
		
		String nom = debutNom.get(nombreAleatoireListDebutNom) +" "+ finNom.get(nombreAleatoireListFinNom);
		
		return nom;
	}

}
