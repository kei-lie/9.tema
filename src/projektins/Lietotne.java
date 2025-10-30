package projektins;

import java.util.Random;



	public class Lietotne implements Comparable<Lietotne> {
	// ATRIBUTI
		private String nosaukums, izstradatajs;
		private double izmers, novertejums;
		private int versija, lpSkaits;
	
	// KONSTRUKTORS
		public Lietotne(String nosaukums, String izstradatajs, int versija, int izmers) {
		this.nosaukums = nosaukums;
		this.izstradatajs = izstradatajs;
		this.versija = versija;
		this.izmers = izmers;
		this.lpSkaits = izvadaLP(); // lejupielades
		this.novertejums = izvadaNOV();
	}
		
	// METODES
	public Random rand = new Random();	//Lai nav jātaisa jauns random katru reizi
	
	public String noteiktNosaukumu() {
		return nosaukums;
	}
	
	public String noteiktIzstradataju() {
		return izstradatajs;
	}
	
	public double noteiktVersiju() {
		return versija;
	}
	
	public Double noteiktIzmeru() {
		return izmers;
	}
	
	public int noteiktLP() {
		return lpSkaits;
	}
	
	public Double noteiktNOV() {
		return novertejums;
	}
	
	// generee ar random novertejumu (1.0 - 5.0)
	private double izvadaNOV() {
		return Math.round((rand.nextDouble() * 4 + 1) * 10.0) / 10.0;
	}
	
	// generee ar random LP skaitu (1 - 1 000 000)
	private int izvadaLP() {
		return rand.nextInt(1_000_000) + 1;
	}
	
	public String izvadit() {
		return "Lietotne: " + noteiktNosaukumu()+
				"\nIzstrādātājs: " + noteiktIzstradataju()+
				"\nVersija: " + noteiktVersiju()+
				"\nIzmērs: " + noteiktIzmeru()+
				"\nNovērtējums: " + noteiktNOV()+ " ★" +
				"\nLejupielāžu skaits: " + noteiktLP();
	}
	
	// atjaunina lietotni
	public void atjauninat(int jaunaVersija) {
		if (jaunaVersija > versija) {
			  versija = jaunaVersija;
		  }
	}
	
	// sakārtošana pec izmēra
	@Override
	public int compareTo(Lietotne l) {
		return this.noteiktIzmeru().compareTo(l.noteiktIzmeru());
	}

}