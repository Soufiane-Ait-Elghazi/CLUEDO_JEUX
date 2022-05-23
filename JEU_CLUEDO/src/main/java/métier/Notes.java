package métier;

import java.util.HashMap;
import java.util.Map;

public class Notes {
	
	private HashMap<Carte, String> CartesEtats;

	public Notes() {
	}

	public Notes(HashMap<Carte, String> cartesEtats) {
		CartesEtats = cartesEtats;
	}

	public HashMap<Carte, String> getCartesEtats() {
		return CartesEtats;
	}

	public void setCartesEtats(HashMap<Carte, String> cartesEtats) {
		CartesEtats = cartesEtats;
	}

	public String toString() {
		
		HashMap<Carte, String> map = new HashMap<Carte, String>(this.CartesEtats);
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.toString()+"\n");
		}
		return "";
	}

	// cocher & decocher

}
