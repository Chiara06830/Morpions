package programme;

import java.io.*;

public class main {

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
				System.out.println("Entrez nom du joueur 1");
				Joueur j1 = new Joueur(flux.readLine(), true);
				if(j1.getNom().isEmpty()) {
					j1.setNom("j1");
				}

				System.out.println("Entrez nom joueur 2");
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
					if (nbTour == 9)
						enJeu = false;
					System.out.println(plateau.affichage());
					System.out.println();
					
					//Joueur 1
					plateau.jouer(j1);
					nbTour++;
					//si il y a victoire du j1
					if (plateau.aGagne(j1)) {
						enJeu = false;
						System.out.println(j1.getNom() + " à gagné");
					}
					
					System.out.println(plateau.affichage());
					System.out.println();
					
					//Joueur 2
					plateau.jouer(j2);
					nbTour++;
					//si il y a victoire du j2
					if (plateau.aGagne(j2)) {
						enJeu = false;
						System.out.println(j2.getNom() + " à gagné");
					}
				}
				
				//rejouer une partie
				System.out.println();
				System.out.println("Voulez vous rejouez une partie ? o/n");
				String choix  = flux.readLine();
				while (choix.equals("o") == false && choix.equals("n") == false) {
					if (choix.equals("n")) {
						System.out.println("le jeux est terminé");
						partie = false;
					}
					System.err.println("erreure de saisie");
				}
			}
			
			System.out.println("Merci d'avoir joué !");
			flux.close();
			
		}catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
