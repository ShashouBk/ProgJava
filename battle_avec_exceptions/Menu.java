package battle_avec_exceptions;

import java.util.Scanner;

public class Menu {

	private BattleDePerformances battle; // la battle qui est pilotée par ce menu

	public Menu(BattleDePerformances battle) {
		this.battle = battle;
	}
	
	/*
	 * Cette version a le défaut que, si un même artiste présente plusieurs performances, plusieurs objets Artiste sont créés. 
	 * Pour résoudre cela il faudrait ajouter une liste des artistes dans la casse BattleDePerformances.
	 * Nous ne l'avons pas fait pour ne pas compliquer ce programme qui est focalisé sur la question des exceptions...
	 */
	public void lancerMenu() {
		Scanner sc = new Scanner(System.in);
		
		int choixMenu;
		
		do {
			
			System.out.println();
			System.out.print("Battle de Performance : " + this.battle.getNomBattle() + "\n"
					+ "1 pour ajouter une performance\n"
					+ "2 pour lister les performances\n"
					+ "3 pour saisir une note de jury pour une performance\n"
					+ "0 pour quitter\n"
					+ "votre choix : ");
			
			try {
				choixMenu = Integer.parseInt(sc.nextLine());
			}
			catch (Exception e) {
				System.out.println("Je n'ai pas compris votre choix");
				choixMenu = -1;
			}
			
			switch (choixMenu) {
				case 1: 
					String nomArtiste;
					int âgeArtiste;
					String titrePerformance;
					System.out.print("Nom de l'artiste : ");
					nomArtiste = sc.nextLine();
					System.out.println("Age de l'artiste : ");
					try {
						âgeArtiste = Integer.parseInt(sc.nextLine());
					}
					catch (Exception e) {
						System.out.println("Je n'ai pas pu lire un nombre entier... retour au menu.");
						choixMenu = -1;
						break;
					}
					System.out.print("Titre de la performance : ");
					titrePerformance = sc.nextLine();
					try {
						battle.ajouterPerformance(new Performance(new Artiste(nomArtiste, âgeArtiste),titrePerformance));
					} catch (Exception e) {
						System.out.println("Je n'ai pas pu ajouter cette performance... retour au menu.");
						choixMenu = -1;
						break;
					}
					break;
				case 2:
					System.out.println(this.battle.listeDesPerformances());
					break;
				case 3:
					String titre;
					int note;
					System.out.print("Titre de la performance : ");
					titre = sc.nextLine();
					System.out.print("Note de la performance (entre 1 et 10) : ");
					try {
						note = Integer.parseInt(sc.nextLine());
					}
					catch (Exception e) {
						System.out.println("Je n'ai pas pu lire un nombre entier... retour au menu.");
						choixMenu = -1;
						break;
					}
					try {
						battle.affecterNote(titre, note);
					} catch (Exception e) {
						System.out.println("Je n'ai pas pu affecter cette note à cette performance... retour au menu.");
						choixMenu = -1;
						break;
					}
					break;
			}
			
		} while (choixMenu != 0);
		
		sc.close();
		System.out.println("A tchao !");
	}
	
}
