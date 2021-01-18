package jdr.interfaces;

public interface Attaque {
	
	public int LancerAttaque(Combattant lanceur, Combattant cible);
	// Getters et Setters
    public String getNom();
    public String getDescription();
    public double getChanceToucher();
    public void setNom(String nom);
    public void setDescription(String description);
    // Chance de toucher doit être compris entre 0 et 100 obligatoirement
    public void setChanceToucher(double chanceToucher); 

}