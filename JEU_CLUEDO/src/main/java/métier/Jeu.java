package métier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Jeu {
	
	private ArrayList<Carte> cartesJeu = new ArrayList<Carte>();// toutes les cartes
	private ArrayList<Carte> cartesEnveloppe;// 3 cartes, une pour chaque type!
	private ArrayList<Carte> cartesRestes = new ArrayList<Carte>();
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	

	public Jeu() {
	}

	public Jeu(ArrayList<Carte> cartesJeu, ArrayList<Carte> cartesEnveloppe, ArrayList<Carte> cartesRestes,
			ArrayList<Joueur> joueurs) {
		super();
		this.cartesJeu = cartesJeu;
		this.cartesEnveloppe = cartesEnveloppe;
		this.cartesRestes = cartesRestes;
		this.joueurs = joueurs;
		
	}

	public ArrayList<Carte> getCartesJeu() {
		return cartesJeu;
	}

	public void setCartesJeu(ArrayList<Carte> cartesJeu) {
		this.cartesJeu = cartesJeu;
	}

	public ArrayList<Carte> getCartesEnveloppe() {
		return cartesEnveloppe;
	}

	public void setCartesEnveloppe(ArrayList<Carte> cartesEnveloppe) {
		this.cartesEnveloppe = cartesEnveloppe;
	}

	public ArrayList<Carte> getCartesRestes() {
		return cartesRestes;
	}

	public void setCartesRestes(ArrayList<Carte> cartesRestes) {
		this.cartesRestes = cartesRestes;
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}


	@Override
	public String toString() {
		return "Jeu [cartesJeu=" + cartesJeu + "\n\n cartesEnveloppe=" + cartesEnveloppe + "\n\n cartesRestes="
				+ cartesRestes + "\n\n joueurs=" + joueurs + "]";
	}
	
	Fonctions Fo = new Fonctions();

	// methods
	Fonctions F = new Fonctions();
	public void remplirEnveloppe() {

		// Random r = new Random();
		ArrayList<Carte> AllCartes = new ArrayList<Carte>();
		ArrayList<Carte> cartesAajouter = new ArrayList<Carte>();
		AllCartes = this.getCartesJeu();
		int a = (int) (Math.random() * (5) + 10);
		int b = (int) (Math.random() * (8) + 1);
		int c = (int) (Math.random() * (6) + 15);
		cartesAajouter.add(AllCartes.get(b));
		cartesAajouter.add(AllCartes.get(a));
		cartesAajouter.add(AllCartes.get(c));
		this.setCartesEnveloppe(cartesAajouter);
		int id = this.cartesEnveloppe.get(0).getIdCarte();
		

	}

	public int gererCartes(int nbrJoueurs) {
		return 18 % nbrJoueurs;
	}

	public void distribuerCartes(int nbrjoueurs) {
		
		remplirEnveloppe();
		ArrayList<Carte> cartesSansEnvo = new ArrayList<Carte>();
		cartesSansEnvo.addAll(this.cartesJeu);
		cartesSansEnvo.removeAll(this.getCartesEnveloppe());
		int a = gererCartes(nbrjoueurs);
		Fonctions F = new Fonctions();
		for (int j = 0; j < nbrjoueurs; j++) {
			// System.out.println(cartesJeu.size());
			joueurs.add(new Joueur(j + 1, "nom " + j, null, null, null, F.setPosDepart(j),F.setPosDepart(j), "echec", false, false, null,null,0));
			this.getJoueurs().get(0).setTourJoueur(true);
			Notes notes = new Notes();
			HashMap<Carte, String> notesJoueur = new HashMap<Carte, String>();
			for (int n = 0; n < cartesJeu.size(); n++) {
				notesJoueur.put(cartesJeu.get(n), "Faux");
			}
			notes.setCartesEtats(notesJoueur);
			joueurs.get(j).setNotesJoueur(notes);
		}
		if (a == 0) {

			if (nbrjoueurs == 6) {
				Random r;
				int i;
				int c = 0;
				for (int j = 0; j < 6; j++) {

					ArrayList<Carte> cartesJouer = new ArrayList<Carte>();

					for (i = 0; i < 3; i++) {
						r = new Random();
						c = r.nextInt(cartesSansEnvo.size());
						cartesJouer.add(cartesSansEnvo.get(c));
						joueurs.get(j).getNotesJoueur().setCartesEtats(
								F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesSansEnvo.get(c)));
						cartesSansEnvo.remove(cartesSansEnvo.get(c));
						this.joueurs.get(j).setCartesJoueur(cartesJouer);
					}
				}
			} else if (nbrjoueurs == 3) {
				Random r;
				int i;
				int c = 0;
				for (int j = 0; j < 3; j++) {

					ArrayList<Carte> cartesJouer = new ArrayList<Carte>();

					for (i = 0; i < 6; i++) {
						r = new Random();
						c = r.nextInt(cartesSansEnvo.size());
						cartesJouer.add(cartesSansEnvo.get(c));
						joueurs.get(j).getNotesJoueur().setCartesEtats(
								F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesSansEnvo.get(c)));
						cartesSansEnvo.remove(cartesSansEnvo.get(c));
						this.joueurs.get(j).setCartesJoueur(cartesJouer);
						this.cartesRestes = cartesSansEnvo;
					}
				}
			} else if (nbrjoueurs == 2) {
				Random r;
				int i;
				int c = 0;
				for (int j = 0; j < 2; j++) {

					ArrayList<Carte> cartesJouer = new ArrayList<Carte>();

					for (i = 0; i < 9; i++) {
						r = new Random();
						c = r.nextInt(cartesSansEnvo.size());
						cartesJouer.add(cartesSansEnvo.get(c));
						joueurs.get(j).getNotesJoueur().setCartesEtats(
								F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesSansEnvo.get(c)));
						cartesSansEnvo.remove(cartesSansEnvo.get(c));
						this.joueurs.get(j).setCartesJoueur(cartesJouer);

					}

				}

			}

		} else if (a == 2) {
			Random r;
			int i;
			int c = 0;
			for (int j = 0; j < 4; j++) {

				ArrayList<Carte> cartesJouer = new ArrayList<Carte>();

				for (i = 0; i < 4; i++) {
					r = new Random();
					c = r.nextInt(cartesSansEnvo.size());
					cartesJouer.add(cartesSansEnvo.get(c));
					joueurs.get(j).getNotesJoueur().setCartesEtats(
							F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesSansEnvo.get(c)));
					cartesSansEnvo.remove(cartesSansEnvo.get(c));
					this.joueurs.get(j).setCartesJoueur(cartesJouer);
					this.setCartesRestes(cartesSansEnvo);

				}

			}
			for (int j = 0; j < 4; j++) {
				for (int t = 0; t < 2; t++) {
					joueurs.get(j).getNotesJoueur().setCartesEtats(
					F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesRestes.get(t)));
				}
			}

		} else if (a == 3) {
			Random r;
			int i;
			int c = 0;
			for (int j = 0; j < 5; j++) {

				ArrayList<Carte> cartesJouer = new ArrayList<Carte>();

				for (i = 0; i < 3; i++) {
					r = new Random();
					c = r.nextInt(cartesSansEnvo.size());
					cartesJouer.add(cartesSansEnvo.get(c));
					joueurs.get(j).getNotesJoueur().setCartesEtats(
					F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesSansEnvo.get(c)));
					cartesSansEnvo.remove(cartesSansEnvo.get(c));
					this.joueurs.get(j).setCartesJoueur(cartesJouer);
					this.setCartesRestes(cartesSansEnvo);
				}
			}
			for (int j = 0; j < 5; j++) {
				for (int t = 0; t < 3; t++) {
					joueurs.get(j).getNotesJoueur().setCartesEtats(
					F.coucher(joueurs.get(j).getNotesJoueur().getCartesEtats(), cartesRestes.get(t)));
				}
			}
		}
	}

	public ArrayList<Carte> afficherHypothese(int indice) {
		return this.joueurs.get(indice).getHypotheseJoueur();
	}

	public Boolean comparer(ArrayList<Carte> hypotheseFinale) {
		int i=0;
		for(Carte ca : this.getCartesEnveloppe()) 
			for(Carte car : hypotheseFinale) {
			if(F.ComparCartes(car, ca))
				i++;
		}
		if(i==3) {
		this.getJoueurs().get(F.TourJeu(this)).setEtatJeu("Succes");
		this.getJoueurs().get(F.TourJeu(this)).setScore(this.getJoueurs().get(F.TourJeu(this)).getScore()+100);
		return true;
		}
		else
		return false;
	}

	public String afficherResultat(int indice) {
		return this.getJoueurs().get(indice).getEtatJeu();
	}

}
