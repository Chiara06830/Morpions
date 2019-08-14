package programme;

public class Joueur {
	//ATTRIBUTS 
	private String nom;
	private boolean couleur; //true = O, false = X
	
	//CONSTRUCTEURS 
	public Joueur (String nom, boolean couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}
	
	//GETTERS AND SETTERS
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public boolean isCouleur() {return couleur;}
	public void setCouleur(boolean couleur) {this.couleur = couleur;}
}
