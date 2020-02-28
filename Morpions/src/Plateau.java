import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Plateau {
	//ATTRIBUTS
	//initialisation case
	private Case A3 = new Case(0, 0);
	private Case A2 = new Case(1, 0);
	private Case A1 = new Case(2, 0);
	
	private Case B1 = new Case(2, 1);
	private Case B2 = new Case(1, 1);
	private Case B3 = new Case(0, 1);
	
	private Case C1 = new Case(2, 2);
	private Case C2 = new Case(1, 2);
	private Case C3 = new Case(0, 2);
	
	//initialisation plateau
	private Case [] [] plateau = 
		{
			{A3, B3, C3}, // | 0,0 | 0,1 | 0,2 |
			{A2, B2, C2}, // | 1,0 | 1,1 | 1,2 | 
			{A1, B1, C1}  // | 2,0 | 2,1 | 2,2 | 
		};
	
	private String [][] code = 
		{
			{"A3", "B3", "C3"},
			{"A2", "B2", "C2"},
			{"A1", "B1", "C1"}
		};
	
	//CONSTRUCTEUR
	public Plateau () {}
	
	//METHODES
	public String affichage() {
		String res = "\n" + "   -------------"+ "\n"; //haut de la grille
		String lettres = "     A   B   C ";
		int chiffres = 3;
		
		for (int i=0; i < 3; i++) { //pour chaque ligne 
			res += chiffres + " ";
			res += " | ";
			for (int j=0; j<3; j++) { //pour chaque colonne
				res += plateau[i][j].getPion();
				res += " | ";
			}
			res += "\n";
			res += "   -------------"; //ligne de s�prations
			res += "\n";
			chiffres --; 
		}
		res += lettres;
		
		return res;
	}
	
	public void mettrePion(Case c, Joueur jo) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (this.plateau[j][i].getX() == c.getX() && this.plateau[j][i].getY() == c.getY()) {
					if (jo.isCouleur())
						this.plateau[j][i] = new Case (i, j, "O");
					else this.plateau[j][i] = new Case (i, j, "X");
				}
			}
		}
	}
	
	public boolean aGagne(Joueur j) {
		String lettre;
		if (j.isCouleur()) { //joueur rond
			lettre = "O";
		}else lettre = "X";
			if (this.getA3().getPion().equals(lettre)) { //depuis haut gauche
				if (this.getB3().getPion().equals(lettre) && this.getC3().getPion().equals(lettre)) // 1ere ligne
					return true;
				else if (this.getA2().getPion().equals(lettre) && this.getA1().getPion().equals(lettre)) // 1ere colonne
					return true;
				else if (this.getB2().getPion().equals(lettre) && this.getC1().getPion().equals(lettre)) // diago gauche
					return true;
				else return false;
			}	
			
			if (this.getC3().getPion().equals(lettre)) { //depuis haut droite
				if (this.getB2().getPion().equals(lettre) && this.getA1().getPion().equals(lettre)) // diago droite
					return true;
				else if (this.getC2().getPion().equals(lettre) && this.getC1().getPion().equals(lettre)) // 3eme colonne
					return true;
				else return false;
			}
			
			if (this.getA1().getPion().equals(lettre)) { //depuis bas gauche
				if (this.getB1().getPion().equals(lettre) && this.getC1().getPion().equals(lettre)) //3eme ligne
					return true;
				else return false;
			}
			if (this.getB3().getPion().equals(lettre) && this.getB2().getPion().equals(lettre) && this.getB1().getPion().equals(lettre))// 2eme colonne
				return true;
			if (this.getA2().getPion().equals(lettre) && this.getB2().getPion().equals(lettre) && this.getC2().getPion().equals(lettre)) // 2eme ligne
				return false;
		return false;
	}
	
	public Case traduction (String s){
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (this.code[i][j].equals(s)) {
					return new Case (i, j);
				}
			}
		}
		return null;
	}
	
	public void jouer (Joueur j) {
		String c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Tour de " + j.getNom());
		System.out.println();
		do { //tant que la saisie n'est pas bonne
			System.out.println("Entrez les coordonnées de la case dans laquel vous voulez jouer (ex : A1)");
			c = sc.nextLine();
			Case trad = traduction(c);
			if (trad == null || trad.getPion().equals("O") || trad.getPion().equals("X")) { //si erreure de saisie
				System.err.println(("erreure de saisie"));
				System.out.println();
			}
		} while (this.traduction(c) == null);
		this.mettrePion(this.traduction(c), j);
	}

	public boolean partieFini(){
		int nbCaseVide = 0;
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if (this.getPlateau()[i][j].equals(" ")){
					nbCaseVide++;
				}
			}
		}

		if (nbCaseVide == 9)
			return true;
		else
			return false;
	}

	public void annulerCoup(Case c){
		this.getPlateau()[c.getY()][c.getX()] = new Case(c.getX(), c.getY(), " ") ;
	}
	
	//GETTERS AND SETTERS
	public Case getA3() {return A3;}
	public void setA3(Case a3) {A3 = a3;}
	public Case getA2() {return A2;}
	public void setA2(Case a2) {A2 = a2;}
	public Case getA1() {return A1;}
	public void setA1(Case a1) {A1 = a1;}
	public Case getB1() {return B1;}
	public void setB1(Case b1) {B1 = b1;}
	public Case getB2() {return B2;}
	public void setB2(Case b2) {B2 = b2;}
	public Case getB3() {return B3;}
	public void setB3(Case b3) {B3 = b3;}
	public Case getC1() {return C1;}
	public void setC1(Case c1) {C1 = c1;}
	public Case getC2() {return C2;}
	public void setC2(Case c2) {C2 = c2;}
	public Case getC3() {return C3;}
	public void setC3(Case c3) {C3 = c3;}

	public Case[][] getPlateau() {return plateau;}
	public void setPlateau(Case[][] plateau) {this.plateau = plateau;}
}
