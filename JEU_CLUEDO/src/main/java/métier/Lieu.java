package métier;

import java.util.ArrayList;

public class Lieu {
	private String nomLieu;
	private int nombrePortes ;
	ArrayList<Position> portesPositions;
	ArrayList<Position> lieuPositions ;
	
	
	public Lieu() {}
	
	public Lieu(String nomLieu, int nombrePortes, ArrayList<Position> portesPositions,
			ArrayList<Position> lieuPositions) {
		super();
		this.nomLieu = nomLieu;
		this.nombrePortes = nombrePortes;
		this.portesPositions = portesPositions;
		this.lieuPositions = lieuPositions;
	}



	public String getNomLieu() {
		return nomLieu;
	}

	public void setNomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}

	public int getNombrePortes() {
		return nombrePortes;
	}
	public void setNombrePortes(int nombrePortes) {
		this.nombrePortes = nombrePortes;
	}
	public ArrayList<Position> getPortesPositions() {
		return portesPositions;
	}
	public void setPortesPositions(ArrayList<Position> portesPositions) {
		this.portesPositions = portesPositions;
	}
	public ArrayList<Position> getLieuPositions() {
		return lieuPositions;
	}
	public void setLieuPositions(ArrayList<Position> lieuPositions) {
		this.lieuPositions = lieuPositions;
	}

	@Override
	public String toString() {
		return "Lieu [nomLieu=" + nomLieu + ", nombrePortes=" + nombrePortes + ", portesPositions=" + portesPositions
				+ ", lieuPositions=" + lieuPositions + "]";
	}
	
	
	

}
