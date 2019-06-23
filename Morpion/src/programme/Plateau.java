package programme;

public class Plateau {
	//ATTRIBUTS
	//initialisation case
	private Case A3 = new Case(0, 0);
	private Case A2 = new Case(1, 0);
	private Case A1 = new Case(2, 0);
	
	private Case B1 = new Case(0, 1);
	private Case B2 = new Case(1, 1);
	private Case B3 = new Case(2, 1);
	
	private Case C1 = new Case(0, 2);
	private Case C2 = new Case(1, 2);
	private Case C3 = new Case(2, 2);
	
	//initialisation plateau
	private Case [] [] plateau = 
		{
			{A3, B3, C3},
			{A2, B2, C2},
			{A1, B1, C1}
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
			res += "   -------------"; //ligne de séprations
			res += "\n";
			chiffres --; 
		}
		res += lettres;
		
		return res;
	}
	
	public void mettrePion(Case c, int joueur) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (this.plateau[j][i].getX() == c.getX() && this.plateau[j][i].getY() == c.getY()) {
					if (joueur == 1)
						this.plateau[j][i].setPion("O");
					else this.plateau[j][i].setPion("X");
				}
			}
		}
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
