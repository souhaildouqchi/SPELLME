
public class Joueur {
	private String nom;
	private int max_score;
	private int nombre_co;

	public Joueur(int x) {
		this.nom = "joueur" + x;
		this.max_score = 0;
		this.nombre_co = 5;
	}

	public Joueur(String x) {
		this.nom = x;
		this.max_score = 0;
		this.nombre_co = 4;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMax_score() {
		return max_score;
	}

	public void setMax_score(int max_score) {
		this.max_score = max_score;
	}

	public int getNombre_co() {
		return nombre_co;
	}

	public void setNombre_co(int nombre_co) {
		this.nombre_co = nombre_co;
	}

	public void addscor(int x) {
		if (x > max_score)
			this.max_score = x;
	}

}