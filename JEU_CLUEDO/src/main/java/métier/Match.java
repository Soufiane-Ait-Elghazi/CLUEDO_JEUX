package métier;

import java.util.Date;

public class Match {
	private int idMatch;
	private Jeu jeu ;
	private String EtatMatch;
	private Date dateMatch ;
	
	public Match() {}
	
	public Match(int idMatch, Jeu jeu, String etatMatch, Date dateMatch) {
		super();
		this.idMatch = idMatch;
		this.jeu = jeu;
		EtatMatch = etatMatch;
		this.dateMatch = dateMatch;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public String getEtatMatch() {
		return EtatMatch;
	}

	public void setEtatMatch(String etatMatch) {
		EtatMatch = etatMatch;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	@Override
	public String toString() {
		return "Match [jeu=" + jeu + ", EtatMatch=" + EtatMatch + ", dateMatch=" + dateMatch + "]";
	}
	//methods
	public void souvgarder(){	
		
	}
	public Match ReprondreMath(int idMatch) {
		return null;
	}
	

}
