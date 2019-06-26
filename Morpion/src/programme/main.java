package programme;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau();
		Joueur j1 = new Joueur("j1", true);
		Joueur j2 = new Joueur("j2", false);
		
		System.out.println(plateau.affichage());
		Case a1 = new Case (1, 2);
		plateau.mettrePion(a1, j1);
		System.out.println(plateau.affichage());
		Case b2 = new Case (1, 1);
		plateau.mettrePion(b2, j2);
		System.out.println(plateau.affichage());
		System.out.println(plateau.aGagne(j2));
		Case a3 = new Case (0, 0);
		plateau.mettrePion(a3, j2);
		Case c1 = new Case (0,2);
		plateau.mettrePion(c1, j2);
		System.out.println(plateau.affichage());
		System.out.println(plateau.aGagne(j2));
		System.out.println(plateau.getA3().getPion());
	}
}
