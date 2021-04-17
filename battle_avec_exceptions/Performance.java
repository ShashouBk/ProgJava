package battle_avec_exceptions;
/*
 * Dans le cadre du concours que nos organisons, 
 * une performance est réalisée par un artiste et a un titre.
 * Le jury lui attribue une note.
 */
public class Performance {
	
	private Artiste artiste;
	private String titre; // titre de la performance de l'artiste
	private int note; // la note donnée par le jury, entre 1 et 10, -1 signifie "non encore évalué"
	
	public Performance(Artiste a, String t) {
		this.artiste = a;
		this.titre = t;
		this.note = -1;
	}

	public Performance(Artiste a, String t, int n) throws BattleException {
		if (n < 1 || n > 10) throw new BattleException(); 
		
		this.artiste = a;
		this.titre = t;
		this.note = n;
	}
	
	public int getNote() {
		return this.note;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public void attribuerNote (int n) throws BattleException {
		if (n < 1 || n > 10) throw new BattleException(); 
		
		this.note = n;
	}
	
	/*
	 * La catégorie de la performance est définie par la catégorie de l'artiste qui la réalise.
	 */
	public int catégorie() {
		return this.artiste.catégorie();
	}
	
	public String toString () {
		String s = this.titre + " de l'artiste " + this.artiste.toString();
		if (this.note == -1)
			s += " n'a pas été évalué";
		else
			s+= " a obtenu la note : " + this.note;
		return s;
	}
	
}
