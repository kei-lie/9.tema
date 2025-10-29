package projektins;

public class SazinasLietotne extends Lietotne{
	//Atribūti
		private boolean kamera, kontakti;
		
		public SazinasLietotne(boolean kamera, boolean kontakti, String nosaukums, String izstradatajs, double versija, double izmers) {
			super(nosaukums, izstradatajs, versija, izmers);
			
		}
		
		public boolean Kam() {
			return kamera;
		}
		
		public boolean Kont() {
			return kontakti;
		}
		
		public String izvadit() {
			return "Lietotne: " + noteiktNosaukumu()+
					"\nIzstrādātājs: " + noteiktIzstradataju()+
					"\nVersija: " + noteiktVersiju()+
					"\nIzmērs: " + noteiktIzmeru()+ " €" +
					"\nNovērtējums: " + noteiktNOV()+ " ★" +
					"\nLejupielāžu skaits: " + noteiktLP()+
					"\nAtļauta kamera? " + Kam()+
					"\nAtļauti kontakti? " + Kont();
		}
		
	}
