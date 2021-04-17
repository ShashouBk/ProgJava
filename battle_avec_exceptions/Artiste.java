package battle_avec_exceptions;
/*
 * Un artiste est modélisé par son nom et son âge. 
 * Il appartient à une catégorie en fonction de son âge : 
 * inf à 13 ans = cat 1
 * de 13 à 17 ans = cat 2
 * à partir de 18 ans = cat 3
 * Les âges acceptés vont de 1 à 130 ans.
 */
public class Artiste {

	private String nom;
	private int âge;
	
	public Artiste(String nom, int âge) throws BattleException {
		if (âge < 1 || âge > 130) throw new BattleException();
		
		this.nom = nom;
		this.âge = âge;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	/*
	 * Retourne la catégorie à laquelle appartient l'artiste.
	 */
	public int catégorie () {
		if (this.âge < 13)
			return 1;
		else if (this.âge < 18)
			return 2;
		else return 3;
	}
	
	public String toString () {
		return this.nom + " (" + this.âge + " ans)"; 
	}

}
