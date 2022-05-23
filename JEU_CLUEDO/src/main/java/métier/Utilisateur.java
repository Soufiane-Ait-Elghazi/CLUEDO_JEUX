package métier;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.*;
@Entity
@Table(name = "Utilisateurs")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private int idUser;
	@Column(name="userName",unique=true)
	private String userName;
	private String passWord;
	private String emailAdresse;
	private String niveau;
	private int score;
	
	// constructeur
	
	public Utilisateur(String userName, String passWord, String emailAdresse, String niveau, int score) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.emailAdresse = emailAdresse;
		this.niveau = this.niveauDepart();
		this.score = score;
	}
	
	// getters and setters
	
	public Utilisateur() {
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String niveauDepart() {
		return "débutant";
	}
	
	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", userName=" + userName + ", passWord=" + passWord + ", emailAdresse="
				+ emailAdresse + ", niveau=" + niveau + ", score=" + score + "]\n";
	}
	
	

}
