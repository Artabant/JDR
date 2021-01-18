package jdr.monde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import jdr.combat.BasicAttaque;
import jdr.interfaces.Attaque;
import jdr.personnage.Classe;
import jdr.personnage.Monstres;
import jdr.personnage.Personnage;

public class Monde {

	static List<String> debutNom = new ArrayList<>();
	static List<String> finNom = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Classe> listeClasse = new HashMap<String, Classe>();

	/**
	 * Creation d'un personnage avec touts c'est attributs
	 * @return
	 */
	public static Personnage personnageFactory() {

		sc.nextLine();

		System.out.println("Veuillez choisir un nom : ");
		String nom = sc.nextLine();
		
		System.out.println("Veuillez choisir une classe : ");
		System.out.println(listeClasse);
		String nomClasse = sc.nextLine();

		System.out.println("Veuillez entrer vos point de vie : \n");
		int pointDeVie = sc.nextInt();
		
		Classe classe = getClasse(nomClasse);

		Personnage joueur = new Personnage(nom, pointDeVie,classe) ; 

		return joueur;

	}

	/**
	 * Creation d'un monstre son nom est généré grace a la méthode nomMonstre() et demande a l'utilisateur c'est statistique
	 * @return
	 */
	public static Monstres MonstreFactory(){
		
		sc.nextLine();
		
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

		int tour = 1;
		boolean isTurn = true;

		while (personnage.getPointDeVie() > 0 && monstre.getPointDeVie() > 0) {
			System.out.println("------- TOUR " + tour + " -------");
			if (isTurn) {
				personnage.attaquer(monstre);
			} else {
				monstre.attaquer(personnage);
			}
			isTurn = !isTurn;
			tour++;
			sc.nextLine();
		}

		quiGagne(personnage, monstre);
	}

	/**
	* Méthode qui affiche le résultat du combat
	* @param personnage
	* @param monstre
	*/
	public static void quiGagne(Personnage personnage, Monstres monstre) {
		if (personnage.getPointDeVie() > 0) {
			System.out.println(personnage.getNom() + " a gagné !");
		} else {
			System.out.println(monstre.getNom() + " a gagné !");
		}
	}

	public static Classe getClasse(String nomClasse) {
		return listeClasse.get(nomClasse);
	}
	
	public static void generationClasse() {
		
		char continuerClasse = 'o';	
		
		while (continuerClasse == 'o') {
			
			sc.nextLine();
			
			System.out.println("nom de la classe :");
			String nomClasse = sc.nextLine();
			List<Attaque> listeAttaque = generationAttaque();
			Classe classe = new Classe(nomClasse,listeAttaque);
			
			listeClasse.put(nomClasse, classe);
			
			System.out.println("voulez vous ajouter une autre classe ? (o/n)");
			continuerClasse = sc.next().charAt(0);
			
		}

	}
	
	public static List<Attaque> generationAttaque() {
		
		char continuer = 'o';
		List<Attaque> listeAttaque = new ArrayList<>();
		
		while (continuer == 'o') {
			
			sc.nextLine();
			
			System.out.println("nom de l'attaque :");
			String nomAttaque = sc.nextLine();
			
			System.out.println("description :");
			String description = sc.nextLine();
			
			System.out.println("Chance de réussite :");
			double chanceToucher = sc.nextDouble();
			
			System.out.println("degats de l'attaque :");
			int degatsAttaque = sc.nextInt();
			
			BasicAttaque attaque = new  BasicAttaque(nomAttaque,description,chanceToucher,degatsAttaque);
			listeAttaque.add(attaque);
			
			System.out.println("voulez vous ajouter une autre attaque ? (o/n)");
			continuer = sc.next().charAt(0);
			
		}

		return listeAttaque;
	}
	

}
