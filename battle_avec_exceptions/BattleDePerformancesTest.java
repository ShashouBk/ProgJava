package battle_avec_exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BattleDePerformancesTest {

	@Test
	void testperformancesGagnantes() {

		BattleDePerformances battle = new BattleDePerformances("La baston !");
		Performance a,b,c,d,e,f;
		try {
			a = new Performance(new Artiste("A", 11), "aa", 8);
			b = new Performance(new Artiste("B", 11), "bb", 6);
			c = new Performance(new Artiste("C", 11), "cc", 3);
			d = new Performance(new Artiste("D", 11), "dd", 7);
			e = new Performance(new Artiste("E", 11), "ee", 8);
			f = new Performance(new Artiste("F", 11), "ff", 8);
			battle.ajouterPerformance(a);
			battle.ajouterPerformance(b);
			battle.ajouterPerformance(c);
			battle.ajouterPerformance(d);
			battle.ajouterPerformance(e);
			battle.ajouterPerformance(f);
		} catch (BattleException except) {
			fail("Problème de création des objets nécessaires au test.");
			return;
		}
		
		Performance[] résultat = {a,e,f};
		
		assertArrayEquals(résultat, battle.performancesGagnantes(1).toArray());
		
		
	}

}
