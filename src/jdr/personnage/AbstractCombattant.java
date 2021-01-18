package jdr.personnage;

public abstract class AbstractCombattant {
	
        public String nom;
        public int pointDeVie;
        public int degats;

        public AbstractCombattant(String nom, int pointDeVie, int degats) {
			
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

		
}


