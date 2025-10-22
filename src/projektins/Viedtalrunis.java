package projektins;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Viedtalrunis {
	
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

	public static int izmers(int GB) {
		GB = skaitlaParbaude("Kāds ir telefona izmērs?", 64, 1024);
		
		return GB;
	}
	
	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String[] darbibas = {"Novilkt aplikāciju", "Izdzēst aplikāciju",
				"Aplikāciju saraksts", "Kārtot pēc cenas", "Izsaukt metodi",
				"Aizvērt programmu"};
		String[] veidi = {"Velosipēds", "Kalnu velosipēds", "Bērnu velosipēds"};
		String[] atbilde = {"Jā", "Nē"};
		ArrayList<Object> riteni = new ArrayList<>();
		
		
	}

}
