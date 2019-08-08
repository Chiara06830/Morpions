package programme;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenue dans ce jeux de morpions sur console !");
		System.out.println();
		
		//creation des joueurs
		System.out.println("Entrez nom du joueur 1");
		String nomj1 = sc.nextLine();
		Joueur j1 = new Joueur(nomj1, true);
		System.out.println("Entrez nom joueur 2");
		String nomj2 = sc.nextLine();
		Joueur j2 = new Joueur(nomj2, false);
		System.out.println();
		
		System.out.println("Le jeu peut maintenant commenc� !!");
		System.out.println();
		
		//jouer la partie
		boolean enJeu = true;
		while (enJeu == true) {
			System.out.println(plateau.affichage());
			System.out.println();
			
			System.out.println("Tour de " + j1.getNom());
			System.out.println();
			System.out.println("Entrez les coordonn�es de la case dans laquel vous voulez jouer (ex : A1)");
			String c = sc.nextLine();
			System.out.println(plateau.traduction(c));
			//plateau.mettrePion(plateau.traduction(c), j1);
			
			//si il y a victoire d'un des deux joueurs
			if (plateau.aGagne(j1)) {
				enJeu = false;
				System.out.println(j1.getNom() + " � gagn�");
			}
			if (plateau.aGagne(j2)) {
				enJeu = false;
				System.out.println(j2.getNom() + " � gagn�");
			}
		}
			
		sc.close();
	}
}
