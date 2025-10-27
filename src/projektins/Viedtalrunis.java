package projektins;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Viedtalrunis {
	
	public int GB;
	
public static int skaitlaParbaude(String zinojums, int min, int max) {
		
		int skaitlis;
		
		while(true) {
			String ievade = JOptionPane.showInputDialog(null, zinojums, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null) return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis<min || skaitlis>max) {
					JOptionPane.showMessageDialog(null, "Norādīts nederīgs intervāls", "Nepareizi dati", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis", "Nepareizi dati", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public int izmers() {
		this.GB = skaitlaParbaude("Kāds ir telefona izmērs?", 64, 1024);
		
		return GB;
	}
	
	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String[] darbibas = {"Novilkt aplikāciju", "Izdzēst aplikāciju",
				"Aplikāciju saraksts", "Izsaukt metodi",
				"Aizvērt programmu"};
		String[] aplikacijas = {"Spēle", "Saziņas lietotne"};
		// String[] atbilde = {"Jā", "Nē"};
		ArrayList<Object> lietotnes = new ArrayList<>();
		
		
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību",
					"Izvēle", JOptionPane.QUESTION_MESSAGE, null
					,darbibas, darbibas[0]);
			if(izvele == null) break;
			
			izvelesID = Arrays.asList(darbibas).indexOf(izvele);
			
			switch(izvelesID) {
			
			case 0:
				
				break;
			
			case 1:
				break;
			
			case 2:
				break;
			
			case 3:
				break;
			
			case 4:
				break;
			
				
			}
			
		}while(izvelesID != 5);
		
	}

}
