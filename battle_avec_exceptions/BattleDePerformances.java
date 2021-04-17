package battle_avec_exceptions;
import java.util.ArrayList;

/*
 * Notre concours de performances...
 */
public class BattleDePerformances {

	private String nomBattle; // nom du concours
	private ArrayList<Performance> performances;
	
	public BattleDePerformances (String nomBattle) {
		this.nomBattle = nomBattle;
		this.performances = new ArrayList<Performance>();
	}

	public String getNomBattle() {
		return this.nomBattle;
	}
	
	public void ajouterPerformance (Performance perf) throws BattleException {
			if (this.trouverPerformance(perf.getTitre()) != null ) throw new BattleException();
			this.performances.add(perf);
	}
	
	public String listeDesPerformances () {
		return this.performances.toString();
	}
	
	/*
	 * Affecte une note à la performance dont le titre est reçu en paramètre. 
	 */
	public void affecterNote (String titrePerf, int note) throws BattleException {
		Performance perf = this.trouverPerformance(titrePerf);
		if (perf == null) throw new BattleException();
		perf.attribuerNote(note);
	}
	
	/*
	 *  Retourne un ArrayList qui contient les performances gagnantes
	 *  (il peut y en avoir plusieurs en cas d'ex-aequo).
	 */
	public ArrayList<Performance> performancesGagnantes (int catégorie) {
		ArrayList<Performance> perfGagnantes = new ArrayList<>();
		int noteMax = -1;
		for (Performance p : this.performances) {
			if (p.catégorie() == catégorie) {
				if (p.getNote() == noteMax)
					perfGagnantes.add(p);
				if (p.getNote() > noteMax) {
					noteMax = p.getNote();
					perfGagnantes.clear();
					perfGagnantes.add(p);
				}
			}
		}
		return perfGagnantes;
	}
	
	/*
	 * Recherche la performance qui porte le titre reçu en paramètre.
	 * Si ce titre n'existe pas dans la liste des performances, retourne null.
	 */
	private Performance trouverPerformance (String titre) {
		for (Performance p : this.performances)
			if (titre.equals(p.getTitre()))
				return p;
		return null;
	}
	
	
}
