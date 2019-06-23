package programme;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau();
		
		System.out.println(plateau.affichage());
		Case a1 = new Case (2, 0);
		plateau.mettrePion(a1, 1);
		System.out.println(plateau.affichage());
		Case b2 = new Case (1, 1);
		plateau.mettrePion(b2, 2);
		System.out.println(plateau.affichage());
	}

}
