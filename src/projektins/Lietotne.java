package projektins;

import java.util.Random;

	public class Lietotne implements Comparable<Lietotne> {
	// ATRIBUTI
		private String nosaukums, izstradatajs;
		private double versija, cena, novertejums;
		private int lpSkaits;
	
	// KONSTRUKTORS
		public Lietotne(String nosaukums, String izstradatajs, double versija, double cena) {
		this.nosaukums = nosaukums;
		this.izstradatajs = izstradatajs;
		this.versija = versija;
		this.cena = cena;
		this.lpSkaits = izvadaLP(); // lejupielades
		this.novertejums = izvadaNOV();
	}

	// METODES
	public String noteiktNosaukumu() {
		return nosaukums;
	}
	
	public String noteiktIzstradataju() {
		return izstradatajs;
	}
	
	public double noteiktVersiju() {
		return versija;
	}
	
	public Double noteiktCenu() {
		return cena;
	}
	
	public int noteiktLP() {
		return lpSkaits;
	}
	
	public Double noteiktNOV() {
		return novertejums;
	}
	
	// generee ar random vertejumu (1.0 - 5.0)
	private double izvadaNOV() {
		Random rand = new Random();
		return Math.round((rand.nextDouble() * 4 + 1) * 10.0) / 10.0;
	}
	
	// generee ar random LP skaitu (1 - 1 000 000)
	private int izvadaLP() {
		Random rand = new Random();
		return rand.nextInt(1_000_000) + 1;
	}
	
	public String izvadit() {
		return "Lietotne: " + noteiktNosaukumu()+
				"\nIzstrādātājs: " + noteiktIzstradataju()+
				"\nVersija: " + noteiktVersiju()+
				"\nCena: " + noteiktCenu()+ " €" +
				"\nNovērtējums: " + noteiktNOV()+ " ★" +
				"\nLejupielāžu skaits: " + noteiktLP();
	}
	
	// atjaunina lietotni
	public void atjauninat(double jaunaVersija) {
		if (jaunaVersija > versija) {
			  versija = jaunaVersija;
		  }
	}
	
	// salidzinasana pec cenas
	@Override
	public int compareTo(Lietotne l) {
		return this.noteiktCenu().compareTo(l.noteiktCenu());
	}

}