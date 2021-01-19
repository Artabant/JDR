package jdr.personnage;

import jdr.interfaces.Combattant;

public abstract class AbstractCombattant implements Combattant{
	
        public String nom;
        public int pointDeVie;
        public int degats;
        
        public AbstractCombattant() {
			
		}

        public AbstractCombattant(String nom, int pointDeVie, int degats) {
			
		}
        
        public AbstractCombattant(String nom, int pointDeVie) {
    		
    	}
        
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public int getPointDeVie() {
			return pointDeVie;
		}

		public void setPointDeVie(int pointDeVie) {
			this.pointDeVie = pointDeVie;
		}

		public int getDegats() {
			return degats;
		}

		public void setDegats(int degats) {
			this.degats = degats;
		}
		
		@Override
		public String toString() {
			return "AbstractCombattant [nom=" + nom + ", pointDeVie=" + pointDeVie + ", degats=" + degats + "]";
		}
		
		public void attaquer(Combattant adversaire) {
			adversaire.defendre(this.getDegats());
			System.out.println("["+this.nom+"] a fait : "+this.getDegats()+" point de degats");
		}
		
		public void defendre(int degats) {
			this.pointDeVie = this.pointDeVie - degats;	
		}
}