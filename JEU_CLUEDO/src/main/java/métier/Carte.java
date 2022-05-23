package métier;

public class Carte {
	private int idCarte;
	private String nomCarte;
	
	public Carte() {}
	public Carte(int idCarte, String nomCarte) {
		this.idCarte = idCarte;
		this.nomCarte = nomCarte;
	}
	public int getIdCarte() {
		return idCarte;
	}
	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}
	public String getNomCarte() {
		return nomCarte;
	}
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}
	@Override
	public String toString() {
		return "Carte [idCarte=" + idCarte + ", nomCarte=" + nomCarte + "]";
	}
	

}
