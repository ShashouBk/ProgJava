package battle_avec_exceptions;

public class Main {

	public static void main(String[] args) {
		BattleDePerformances battle = new BattleDePerformances("Le grand concours montreuillois !");
		Menu menu = new Menu(battle);
		menu.lancerMenu();

	}

}
