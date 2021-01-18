package jdr.personnage;

public abstract class AbstractCombattant {
	
        public String nom;
        public int pointDeVie;
        public int degats;

        public AbstractCombattant(String nom, int pointDeVie, int degats) {
			
		}
        
		@Override
		public String toString() {
			return "AbstractCombattant [nom=" + nom + ", pointDeVie=" + pointDeVie + ", degats=" + degats + "]";
		}

		
}


