import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programme.*;

class testGeneraux {
	private Joueur jx;
	private Joueur jo;
	private Plateau p;
	
	@BeforeEach
	void initialisation() {
		jo = new Joueur ("o", true);
		jx = new Joueur ("x", false);
		p = new Plateau ();
	}
	
	@AfterEach
	void nettoyage() {
		jo = null;
		jx = null;
		p = null;
	}
	
	@Test
	void testMettrePion() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				Case c = new Case (i, j);
				p.mettrePion(c, jo);
				assertEquals("O", c.getPion());
			}
		}
	}
}
