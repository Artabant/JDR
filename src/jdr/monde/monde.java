package jdr.monde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import jdr.combat.BasicAttaque;
import jdr.groupe.Groupe;
import jdr.interfaces.Attaque;
import jdr.interfaces.Combattant;
import jdr.personnage.Classe;
import jdr.personnage.Monstres;
import jdr.personnage.Personnage;

public class Monde {

	static List<String> debutNomMonstre = new ArrayList<>();
	static List<String> finNomMonstre = new ArrayList<>();
	static List<String> debutNomPersonnage = new ArrayList<>();
	static List<String> finNomPersonnage = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Classe> listeClasse = new HashMap<String, Classe>();
	static Random random = new Random();

	/**
	 * Creation d'un personnage avec touts c'est attributs
	 * @return
	 */
	public static Personnage personnageFactory() {

		System.out.println("Veuillez choisir un nom : ");
		String nom = sc.next();

		System.out.println("Veuillez choisir une classe : ");
		for(String i : listeClasse.keySet()) {
			System.out.println(i);
		}
		//System.out.println(listeClasse);
		String nomClasse = sc.next();

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
	public static void afficherInformations(Groupe personnages, Groupe monstres) {
		System.out.println(personnages);
		System.out.println("\n"+monstres);
	}


	/**
	 * Genereation du nom du monstre
	 * @return nom
	 */
	public static String nomMonstre() {

		/* ajouter des debut de nom des monstres dans la liste debutNom */
		debutNomMonstre.add("chat");
		debutNomMonstre.add("chien");
		debutNomMonstre.add("chaton");

		/* ajouter des fin de nom des personnage dans la liste finNom */
		finNomMonstre.add("mechant");
		finNomMonstre.add("de feu");
		finNomMonstre.add("de la mort");


		int MaxDebutNom = debutNomMonstre.size();
		int nombreAleatoireListDebutNom = new Random().nextInt(MaxDebutNom);

		int MaxFinNom = finNomMonstre.size();
		int nombreAleatoireListFinNom = new Random().nextInt(MaxFinNom);


		String nom = debutNomMonstre.get(nombreAleatoireListDebutNom) +" "+ finNomMonstre.get(nombreAleatoireListFinNom);

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

		return  listeClasse.get(nomClasse);
	}
	
	/**
	 * creer une classe manuellement
	 */
	public static void generationClasse() {

		char continuerClasse = 'o';	

		while (continuerClasse == 'o') {

			System.out.println("nom de la classe :");
			String nomClasse = sc.next();
			List<Attaque> listeAttaque = generationAttaque();
			Classe classe = new Classe(nomClasse,listeAttaque);

			listeClasse.put(nomClasse, classe);

			System.out.println("voulez vous ajouter une autre classe ? (o/n)");
			continuerClasse = sc.next().charAt(0);

		}

	}

	/**
	 * Permet de créer une attaque manuellement
	 * @return
	 */
	public static List<Attaque> generationAttaque() {

		char continuer = 'o';
		List<Attaque> listeAttaque = new ArrayList<>();
		BasicAttaque attaque = new  BasicAttaque();

		while (continuer == 'o') {

			System.out.println("nom de l'attaque :");
			String nomAttaque = sc.next();
			attaque.setNom(nomAttaque);

			System.out.println("description :");
			String description = sc.next();
			attaque.setDescription(description);

			System.out.println("Chance de réussite :");
			double chanceToucher = sc.nextDouble();
			attaque.setChanceToucher(chanceToucher);

			System.out.println("degats de l'attaque :");
			int degatsAttaque = sc.nextInt();
			attaque.setDegats(degatsAttaque);

			listeAttaque.add(attaque);

			System.out.println("voulez vous ajouter une autre attaque ? (o/n)");
			continuer = sc.next().charAt(0);

		}

		return listeAttaque;
	}
	 
	/**
	 * Creation d'une base de données de classe
	 */
	public static void creationClasse() {

		List<Attaque> listeAttaque1 = new ArrayList<>();
		BasicAttaque attaque1 = new  BasicAttaque("boule de feu","lance une boule de feu",100.0,40);
		BasicAttaque attaque2 = new  BasicAttaque("tornade","lance une tornade",100.0,55);
		BasicAttaque attaque3 = new  BasicAttaque("lance de glace","creer une lance de glace",100.0,50);

		listeAttaque1.add(attaque1);
		listeAttaque1.add(attaque2);
		listeAttaque1.add(attaque3);

		Classe classe1 = new Classe("mage",listeAttaque1);
		listeClasse.put("mage", classe1);

		List<Attaque> listeAttaque2 = new ArrayList<>();
		BasicAttaque attaque4 = new  BasicAttaque("coup boubou","donne un coup de bouclier",100.0,30);
		BasicAttaque attaque5 = new  BasicAttaque("coup d'épée","donne un coup d'épée",100.0,60);
		BasicAttaque attaque6 = new  BasicAttaque("lancer de bouclier","lancer votre bouclier",100.0,50);

		listeAttaque2.add(attaque4);
		listeAttaque2.add(attaque5);
		listeAttaque2.add(attaque6);

		Classe classe2 = new Classe("chevalier",listeAttaque2);
		listeClasse.put("chevalier", classe2);

		List<Attaque> listeAttaque3 = new ArrayList<>();
		BasicAttaque attaque7 = new  BasicAttaque("coup sournois","donne un coup de dague dans le dos",100.0,70);
		BasicAttaque attaque8 = new  BasicAttaque("lancer dague","lancer votre dague",100.0,60);
		BasicAttaque attaque9 = new  BasicAttaque("poison","lance du poison sur votre adversaire",100.0,30);

		listeAttaque3.add(attaque7);
		listeAttaque3.add(attaque8);
		listeAttaque3.add(attaque9);

		Classe classe3 = new Classe("assasin",listeAttaque3);
		listeClasse.put("assasin", classe3);
	}
	
	/**
	 * Generation d'un groupe de monstre aléatoire
	 * @param nombreMonstre 
	 * @return
	 */
	public static Groupe creationGroupeMonstre(int nombreMonstre) {

		Groupe groupeMonstre = new Groupe();
		List<Combattant> listeMonstre = new ArrayList<>();
		int maxPvMonstre = 10;
		int maxDegatMonstre = 50;

		for (int i = 0; i < nombreMonstre; i++) {
			
			Monstres monstre = new Monstres() ; 
			int pvMonstre = new Random().nextInt(maxPvMonstre);
			int degatMonstre = new Random().nextInt(maxDegatMonstre);

			String nomMonstre = nomMonstre();
			monstre.setNom(nomMonstre);
			monstre.setPointDeVie(pvMonstre);
			monstre.setDegats(0);

			listeMonstre.add(monstre);

		}
		groupeMonstre.setListeCombattant(listeMonstre);

		return groupeMonstre;

	}
	
	/**
	 * Generation d'un groupe de personnage
	 * @param nombrePersonnage
	 * @return
	 */
	public static Groupe creationGroupePersonnage(int nombrePersonnage) {

		Groupe groupePersonnage = new Groupe();
		List<Combattant> listePersonnage = new ArrayList<>();
		int maxPvPersonnage = 200;

		for (int i = 0; i < nombrePersonnage; i++) {
			
			Personnage personnage = new Personnage() ; 
			int pvPersonnage = random.nextInt(maxPvPersonnage);
			String nom = nomPersonnage();
			personnage.setNom(nom);
			personnage.setPointDeVie(pvPersonnage);
			personnage.setDegats(0);
			
			if(nom.substring(0,1).equals("m")) {
				personnage.setClasse(listeClasse.get("mage"));
			}else if(nom.substring(0,1).equals("c")) {
				personnage.setClasse(listeClasse.get("chevalier"));
			}else {
				personnage.setClasse(listeClasse.get("assasin"));
			}
			listePersonnage.add(personnage);
		}
		groupePersonnage.setListeCombattant(listePersonnage);
		return groupePersonnage;
	}

	/**
	 * Creation des nom de personnage aléatoire
	 * @return
	 */
	public static String nomPersonnage() {

		/* ajouter des debut de nom des personnage dans la liste debutNom */
		debutNomPersonnage.add("mage");
		debutNomPersonnage.add("chevalier");
		debutNomPersonnage.add("assasin");

		/* ajouter des fin de nom des personnage dans la liste finNom */
		finNomPersonnage.add("Jean");
		finNomPersonnage.add("Pierre");
		finNomPersonnage.add("Paul");
		finNomPersonnage.add("Lucie");
		finNomPersonnage.add("Marie");


		int MaxDebutNom = debutNomPersonnage.size();
		int nombreAleatoireListDebutNom = random.nextInt(MaxDebutNom);

		int MaxFinNom = finNomPersonnage.size();
		int nombreAleatoireListFinNom = random.nextInt(MaxFinNom);

		String nom = debutNomPersonnage.get(nombreAleatoireListDebutNom) +" "+ finNomPersonnage.get(nombreAleatoireListFinNom);

		return nom;

	}
	
	/**
	 * Menu de navigation de l'application
	 * @param personnages
	 * @param monstres
	 */
	public static void genese(Groupe personnages , Groupe monstres) {
		System.out.println("---*---Bonjoue---*---");
		System.out.println("Choisir une option : ");
		System.out.println("1 : Lancer un combat 1v1");
		System.out.println("2 : Lancer un combat de groupe");
		System.out.println("3 : One vs World Hardcore Edition");
		System.out.println("4 : Informations du monde");
		System.out.println("Votre choix : ");
		int choix = sc.nextInt();

		switch (choix) {
		case 1 :
			combat1v1(personnages,monstres);
			break;
		case 2 :
			combatGroupe(personnages,monstres);
			break;
		case 3 :
			combatSolo(personnages,monstres);
			break;
		case 4 :
			information(personnages,monstres);
			break;
		}
	}
	
	/**
	 * permet de faire un combat contre un monstre en selectionnant un personnage et un monstre
	 * @param personnages
	 * @param monstres
	 */
	public static void combat1v1(Groupe personnages , Groupe monstres) {

		System.out.println("Selectionner votre personnage : ");
		for (int i = 0; i < personnages.getListeCombattant().size(); i++ ) {
			System.out.println(i+" : "+personnages.getListeCombattant().get(i));
		}
		System.out.println("Votre choix de personnage : ");
		int personnageId = sc.nextInt();

		System.out.println("Selectionner le monstre : ");
		for (int y = 0; y < personnages.getListeCombattant().size(); y++ ) {
			System.out.println(y+" : "+monstres.getListeCombattant().get(y));
		}
		System.out.println("Votre choix de monstre : ");
		int monstreId = sc.nextInt();

		Personnage personnage = (Personnage) personnages.getListeCombattant().get(personnageId);
		Monstres monstre = (Monstres) monstres.getListeCombattant().get(monstreId);

		combat(personnage,monstre);


	}
	public static void combatGroupe(Groupe personnages , Groupe monstres) {
		
		boolean tour = true;
		while(personnages.estMort() == false || monstres.estMort() == false) {
			if (tour) {
				monstres.attaquerGroupe(personnages);
			}else {
				personnages.attaquerGroupe(monstres);
			}
			tour = !tour;
		}
		if(personnages.estMort() == true) {
			System.out.println("les monstre on gagné");
		}else if (monstres.estMort() == true) {
			System.out.println("les personnges on gagné");
		}
	}
	public static void combatSolo(Groupe personnages , Groupe monstres) {
		
	}
	public static void information(Groupe personnages , Groupe monstres) {
		System.out.println(personnages);
	}
}