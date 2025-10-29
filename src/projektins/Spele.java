package projektins;

public class Spele extends Lietotne{
	//Atribūti
	private String[] grafiki= {"Augsti", "Vidēji", "Zemi", "Ļoti zemi"};
	
	public Spele(String grafiki, String nosaukums, String izstradatajs, double versija, double izmers) {
		super(nosaukums, izstradatajs, versija, izmers);
		
		grafiki = kvalitate();
	}
	
	public String kvalitate() {
		return grafiki[rand.nextInt(4)];
	}
	
}
