package projektins;

public class Spele extends Lietotne{
	//Atribūti
	private String grafiki, tips;
	
	public Spele(String grafiki, String tips, String nosaukums, String izstradatajs, double versija, double izmers) {
		super(nosaukums, izstradatajs, versija, izmers);
		
		this.grafiki = grafiki;
		this.tips = tips;
	}
	
	public String noteiktGrafikus() {
		return grafiki;
	}
	
	public String noteiktTipu() {
		return tips;
	}
	
	public String izvadit() {
		return "Lietotne: " + noteiktNosaukumu()+
				"\nIzstrādātājs: " + noteiktIzstradataju()+
				"\nVersija: " + noteiktVersiju()+
				"\nIzmērs: " + noteiktIzmeru()+ " €" +
				"\nNovērtējums: " + noteiktNOV()+ " ★" +
				"\nLejupielāžu skaits: " + noteiktLP()+
				"\nGrafiku kvalitāte: " + noteiktGrafikus()+
				"\nSpēles tips" + noteiktTipu();
	}
	
}
