import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jeux {
	private static int TAILLE = 3;
	private static int GAIN_MAX = 1000;
	private static int GAIN_NULL = 0;

	public List<Case> coupsPossible(Plateau p){
		List<Case> coups = new ArrayList<Case>();
		for (int i=0; i<TAILLE; i++){
			for (int j=0; j<TAILLE; j++){
				if (p.getPlateau()[i][j].equals(" ")){
					coups.add(new Case(i, j));
				}
			}
		}
		return coups;
	}

	private int negaMax(Plateau jeu, Joueur joueur, Joueur adv, Case meilleurCoup){
		if (jeu.aGagne(joueur))
			return GAIN_MAX;
		else if(jeu.aGagne(adv))
			return -GAIN_MAX;
		else if(jeu.partieFini())
			return GAIN_NULL;
		else{
			int meilleurGain = 10000;
			for (Case coup : this.coupsPossible(jeu)){
				jeu.mettrePion(coup, joueur);
				Case coupadv = coup;
				int gain = -negaMax(jeu, adv, joueur, coupadv);
				jeu.annulerCoup(coup);
				jeu.annulerCoup(coupadv);
				if (gain > meilleurGain){
					meilleurGain = gain;
					meilleurCoup = coup;
				}
			}
			return meilleurGain;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plateau plateau = new Plateau();
		BufferedReader flux = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			boolean partie = true;
			while (partie){ //tant qu'on veut jouer une partie
				System.out.println("Bienvenue dans ce jeux de morpions sur console !");
				System.out.println();
				
				//creation des joueurs
				System.out.println("Entrez nom du joueur O");
				Joueur j1 = new Joueur(flux.readLine(), true);
				if(j1.getNom().isEmpty()) {
					j1.setNom("j1");
				}

				System.out.println("Entrez nom joueur X");
				Joueur j2 = new Joueur(flux.readLine(), false);
				if(j2.getNom().isEmpty()) {
					j2.setNom("j2");
				}
				System.out.println();
				
				//lancement partie
				System.out.println("Le jeu peut maintenant commencé !!");
				System.out.println();
				
				//jouer la partie
				boolean enJeu = true;
				int nbTour = 0;
				while (enJeu == true) {
					if (nbTour == TAILLE*TAILLE)
						enJeu = false;
					System.out.println(plateau.affichage());
					System.out.println();
					
					//Joueur 1
					plateau.jouer(j1);
					nbTour++;
					//si il y a victoire du j1
					if (plateau.aGagne(j1)) {
						enJeu = false;
						System.out.println(j1.getNom() + " � gagn�");
					}
					
					System.out.println(plateau.affichage());
					System.out.println();
					
					//Joueur 2
					plateau.jouer(j2);
					nbTour++;
					//si il y a victoire du j2
					if (plateau.aGagne(j2)) {
						enJeu = false;
						System.out.println(j2.getNom() + " � gagn�");
					}
				}
				
				//rejouer une partie
				System.out.println();
				System.out.println("Voulez vous rejouez une partie ? o/n");
				String choix  = flux.readLine();
				while (choix.equals("o") == false && choix.equals("n") == false) {
					if (choix.equals("n")) {
						System.out.println("le jeux est termin�");
						partie = false;
					}
					System.err.println("erreure de saisie");
				}
			}
			
			System.out.println("Merci d'avoir jou� !");
			flux.close();
			
		}catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
