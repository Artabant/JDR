package jdr.monde;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jdr.combat.BasicAttaque;
import jdr.personnage.Classe;
import jdr.personnage.Monstres;
import jdr.personnage.Personnage;

public class Monde {
	
	static List<String> debutNom = new ArrayList<>();
	static List<String> finNom = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Creation d'un personnage avec touts c'est attributs
	 * @return
	 */
	public static Personnage personnageFactory() {
		
		BasicAttaque attaque1 = new  BasicAttaque("boule de feu"," ",50.0,15);
		BasicAttaque attaque2 = new  BasicAttaque("Tornade"," ",75.0,10);
		BasicAttaque attaque3 = new  BasicAttaque("pic de glace"," ",25.0,30);
		String nomClasse= "mage";
		Classe classe1 = new Classe(nomClasse,List.of(attaque1,attaque2,attaque3));
		
		System.out.println("Veuillez choisir un nom : \n");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez entrer vos point de vie : \n");
		int pointDeVie = sc.nextInt();
	
		Personnage joueur = new Personnage(nom, pointDeVie,classe1) ; 
		
		return joueur;
		
	}
	
	/**
	 * Creation d'un monstre son nom est généré grace a la méthode nomMonstre() et demande a l'utilisateur c'est statistique
	 * @return
	 */
	public static Monstres MonstreFactory()
	{

		String nom = nomMonstre();
		
		System.out.println("Point de vie du monstre : \n");
		int pointDeVie = sc.nextInt();
		
		System.out.println("Point de degat du monstre : \n");
		int degats = sc.nextInt();
		
		Monstres monstre = new Monstres(nom, pointDeVie, degats) ; 
		
		
		
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
		
		/* ajouter des debut de nom des monstres dans la liste debutNom */
		debutNom.add("chat");
		debutNom.add("chien");
		debutNom.add("chaton");
		
		/* ajouter des fin de nom des monstres dans la liste finNom */
		finNom.add("mechant");
		finNom.add("de feu");
		finNom.add("de la mort");
		
		
		int MaxDebutNom = debutNom.size();
		int nombreAleatoireListDebutNom = new Random().nextInt(MaxDebutNom);
		
		int MaxFinNom = finNom.size();
		int nombreAleatoireListFinNom = new Random().nextInt(MaxFinNom);
		
		
		String nom = debutNom.get(nombreAleatoireListDebutNom) +" "+ finNom.get(nombreAleatoireListFinNom);
		
		return nom;
	}
	
	/**
	 * effectue un combat entre un personnage et un monstre puis determine un vainqueur
	 * @param personnage 
	 * @param monstre
	 * @return
	 */
	public static void combat(Personnage personnage, Monstres monstre) {
		
		for (int i = 1; i < 60; i++) {
			System.out.println("Tour "+i+" <----->");
			if (i % 2 == 0) {
				monstre.attaquer(personnage);
				/*personnage.pertePointDeVie(monstre.getDegats());
				System.out.println("le personnage a pris : "+ monstre.getDegats());*/
				if (personnage.getPointDeVie() < 0) {
					System.out.println("Le monstre a gagné");
					break;
				}
					
			}else{
				/*monstre.pertePointDeVie(personnage.getDegats());
				System.out.println("le monstre a pris : "+ personnage.getDegats());*/
				personnage.attaquer(monstre);
				if (monstre.getPointDeVie() < 0) {
					System.out.println("Le personnage a gagné");	
					break;
				}
				
			}
			sc.nextLine();
			
		}
		
		
		
	}

}
