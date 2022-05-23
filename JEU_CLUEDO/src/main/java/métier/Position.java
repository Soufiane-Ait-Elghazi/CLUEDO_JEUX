package métier;

public class Position {
	private int ligne;
	private int colonne;
	public Fonctions F = new Fonctions();

	public Position() {
	}

	public Position(int ligne, int colonne) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	@Override
	public String toString() {
		return "Position [ligne=" + ligne + ", colonne=" + colonne + "]";
	}

	// deplacer methodes

	// --------------------Down---------------------

	public Position Down(Plateau p, Jeu jeu) {
		
		int j = F.TourJeu(jeu);
		Position pos = new Position();
		int c = jeu.getJoueurs().get(j).getPositionActuelPion().getColonne();
		int li = jeu.getJoueurs().get(j).getPositionActuelPion().getLigne();
		pos.setColonne(c);
		pos.setLigne(li);
		Position newPosition = new Position();
		if (jeu.getJoueurs().get(j).getNbrDeDeplacement() > 0) {
			if ((p.getTableau()[pos.getLigne()+1][pos.getColonne()] == 0)|| (p.getTableau()[pos.getLigne()+1][pos.getColonne()] == 2)) {
				System.out.println("impossible de passer ici !!");
				return pos;
			} else if (p.getTableau()[pos.getLigne()+1][pos.getColonne()] == 1|| p.getTableau()[pos.getLigne()+1][pos.getColonne()] == 3) {
				jeu.getJoueurs().get(j).setNbrDeDeplacement(jeu.getJoueurs().get(j).getNbrDeDeplacement() - 1);
				int l = p.getTableau()[pos.getLigne()+1][pos.getColonne()];
				if (l == 1) {
					newPosition.setLigne(pos.getLigne()+1);
					newPosition.setColonne(pos.getColonne());
					p.getTableau()[pos.getLigne()+1][pos.getColonne()] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				} else {
					newPosition.setLigne(pos.getLigne()+2);
					newPosition.setColonne(pos.getColonne());
					p.getTableau()[pos.getLigne()+2][pos.getColonne()] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				}

			} else {
				Position  po = new Position(pos.getLigne()+1, pos.getColonne());
				//System.out.println("@@@@@  "+p.getTableau()[pos.getLigne()+1][pos.getColonne()]);
				int id_joueur = F.playerIndex(jeu, po);
				int h = p.getTableau()[pos.getLigne()][pos.getColonne()];
				p.getTableau()[pos.getLigne()][pos.getColonne()] = p.getTableau()[pos.getLigne()+1][pos.getColonne()];
				p.getTableau()[pos.getLigne()+1][pos.getColonne()] = h ;
				jeu.getJoueurs().get(id_joueur).setPositionActuelPion(pos);
				jeu.getJoueurs().get(j).setPositionActuelPion(po);
				return po;
			}
		} else {
			System.out.println("Votre deplacements est exprimer !!!");
			return pos;
		}

	}

	// -----------------Up-----------------------

	public Position Up(Plateau p, Jeu jeu) {
		
		int j = F.TourJeu(jeu);
		Position pos = new Position();
		int c = jeu.getJoueurs().get(j).getPositionActuelPion().getColonne();
		int li = jeu.getJoueurs().get(j).getPositionActuelPion().getLigne();
		pos.setColonne(c);
		pos.setLigne(li);
		Position newPosition = new Position();
		if (jeu.getJoueurs().get(j).getNbrDeDeplacement() > 0) {
			if ((p.getTableau()[pos.getLigne()-1][pos.getColonne()] == 0)|| (p.getTableau()[pos.getLigne()-1][pos.getColonne()] == 2)) {
				System.out.println("impossible de passer ici !!");
				return pos;
			} else if (p.getTableau()[pos.getLigne()-1][pos.getColonne()] == 1|| p.getTableau()[pos.getLigne()-1][pos.getColonne()] == 3) {
				jeu.getJoueurs().get(j).setNbrDeDeplacement(jeu.getJoueurs().get(j).getNbrDeDeplacement() - 1);
				int l = p.getTableau()[pos.getLigne()-1][pos.getColonne()];
				if (l == 1) {
					newPosition.setLigne(pos.getLigne()-1);
					newPosition.setColonne(pos.getColonne());
					p.getTableau()[pos.getLigne()-1][pos.getColonne()] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				} else {
					newPosition.setLigne(pos.getLigne()-2);
					newPosition.setColonne(pos.getColonne());
					p.getTableau()[pos.getLigne()-2][pos.getColonne()] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				}

			} else {
				Position  po = new Position(pos.getLigne()-1, pos.getColonne());
				int id_joueur = F.playerIndex(jeu, po);
				int h = p.getTableau()[pos.getLigne()][pos.getColonne()];
				p.getTableau()[pos.getLigne()][pos.getColonne()] = p.getTableau()[pos.getLigne()-1][pos.getColonne()];
				p.getTableau()[pos.getLigne()-1][pos.getColonne()] = h ;
				jeu.getJoueurs().get(id_joueur).setPositionActuelPion(pos);
				jeu.getJoueurs().get(j).setPositionActuelPion(po);
				return po;
			}
		} else {
			System.out.println("Votre deplacements est exprimer !!!");
			return pos;
		}

	}


	// ------------------Left------------------------

	public Position Left(Plateau p, Jeu jeu) {
		int j = F.TourJeu(jeu);
		Position pos = new Position();
		int c = jeu.getJoueurs().get(j).getPositionActuelPion().getColonne();
		int li = jeu.getJoueurs().get(j).getPositionActuelPion().getLigne();
		pos.setColonne(c);
		pos.setLigne(li);
		Position newPosition = new Position();
		if (jeu.getJoueurs().get(j).getNbrDeDeplacement() > 0) {
			if ((p.getTableau()[pos.getLigne()][pos.getColonne() - 1] == 0)|| (p.getTableau()[li][c - 1] == 2)) {
				System.out.println("impossible de passer ici !!");
				return pos;
			} else if ((p.getTableau()[pos.getLigne()][pos.getColonne() - 1] == 1)|| (p.getTableau()[pos.getLigne()][pos.getColonne() - 1] == 3)) {
				jeu.getJoueurs().get(j).setNbrDeDeplacement(jeu.getJoueurs().get(j).getNbrDeDeplacement() - 1);
				int l = p.getTableau()[pos.getLigne()][pos.getColonne() - 1];
				if (l == 1) {
					newPosition.setLigne(pos.getLigne());
					newPosition.setColonne(pos.getColonne() - 1);
					p.getTableau()[pos.getLigne()][pos.getColonne() - 1] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				} else {
					System.out.println("hayi da");
					newPosition.setLigne(pos.getLigne());
					newPosition.setColonne(pos.getColonne()-2);
					p.getTableau()[pos.getLigne()][pos.getColonne()-2] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				}

			} else {
				Position  po = new Position(pos.getLigne(), pos.getColonne()-1);
				int id_joueur = F.playerIndex(jeu, po);
				System.out.println("----- "+id_joueur);
				int h = p.getTableau()[pos.getLigne()][pos.getColonne()];
				p.getTableau()[pos.getLigne()][pos.getColonne()] = p.getTableau()[pos.getLigne()][pos.getColonne()-1];
				p.getTableau()[pos.getLigne()][pos.getColonne()-1] = h ;
				
				jeu.getJoueurs().get(id_joueur).setPositionActuelPion(pos);
				jeu.getJoueurs().get(j).setPositionActuelPion(po);
				return po;
			}
		} else {
			System.out.println("Votre deplacements est exprimer !!!");
			return pos;
		}

	}

	// ------------------Right--------------------

	public Position Right(Plateau p, Jeu jeu) {
		int j = F.TourJeu(jeu);
		Position pos = new Position();
		int c = jeu.getJoueurs().get(j).getPositionActuelPion().getColonne();
		int li = jeu.getJoueurs().get(j).getPositionActuelPion().getLigne();
		pos.setColonne(c);
		pos.setLigne(li);
		Position newPosition = new Position();
		if (jeu.getJoueurs().get(j).getNbrDeDeplacement() > 0) {
			if ((p.getTableau()[pos.getLigne()][pos.getColonne() + 1] == 0)|| (p.getTableau()[pos.getLigne()][pos.getColonne() + 1] == 2)) {
				System.out.println("impossible de passer ici !!");
				return pos;
			} else if (p.getTableau()[pos.getLigne()][pos.getColonne() + 1] == 1|| p.getTableau()[pos.getLigne()][pos.getColonne() + 1] == 3) {
				jeu.getJoueurs().get(j).setNbrDeDeplacement(jeu.getJoueurs().get(j).getNbrDeDeplacement() - 1);
				int l = p.getTableau()[pos.getLigne()][pos.getColonne() + 1];
				if (l == 1) {
					newPosition.setLigne(pos.getLigne());
					newPosition.setColonne(pos.getColonne() + 1);
					p.getTableau()[pos.getLigne()][pos.getColonne() + 1] = p.getTableau()[pos.getLigne()][pos
							.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				} else {
					newPosition.setLigne(pos.getLigne());
					newPosition.setColonne(pos.getColonne() + 2);
					p.getTableau()[pos.getLigne()][pos.getColonne() + 2] = p.getTableau()[pos.getLigne()][pos.getColonne()];
					p.getTableau()[pos.getLigne()][pos.getColonne()] = 1;
					jeu.getJoueurs().get(j).setPositionActuelPion(newPosition);
					return newPosition;
				}

			} else {
				Position  po = new Position(pos.getLigne(), pos.getColonne()+1);
				int id_joueur = F.playerIndex(jeu, po);
				System.out.println("----- "+id_joueur);
				int h = p.getTableau()[pos.getLigne()][pos.getColonne()];
				p.getTableau()[pos.getLigne()][pos.getColonne()] = p.getTableau()[pos.getLigne()][pos.getColonne()+1];
				p.getTableau()[pos.getLigne()][pos.getColonne()+1] = h ;
				
				jeu.getJoueurs().get(id_joueur).setPositionActuelPion(pos);
				jeu.getJoueurs().get(j).setPositionActuelPion(po);
				return po;
			}
		} else {
			System.out.println("Votre deplacements est exprimer !!!");
			return pos;
		}

	}

}
