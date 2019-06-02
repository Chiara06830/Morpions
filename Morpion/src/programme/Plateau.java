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
	public String toString() {
		
	}
}
