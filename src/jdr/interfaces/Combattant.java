package jdr.interfaces;

public interface Combattant {
	
	public String getNom();
    public int getDegats();
    public int getPointDeVie();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setPointDeVie(int pointDeVie);
    public void attaquer(Combattant adversaire);
    public void defendre(int degats);

}