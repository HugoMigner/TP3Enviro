package exercice1;

public class Utilisateur {
	
	private String nom;
	private String mdp;

	public Utilisateur() {
		
	}
	
	public Utilisateur(String nom, String mdp) {
		this.nom = nom;
		this.mdp = mdp;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getMdp() {
		return this.mdp;
	}
}
