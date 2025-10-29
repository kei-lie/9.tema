package projektins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
	
	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String[] darbibas = {"Novilkt aplikāciju", "Izdzēst aplikāciju",
				"Aplikāciju saraksts", "Izsaukt metodi",
				"Aizvērt programmu"};
		String[] aplikacijas = {"Spēle", "Saziņas lietotne"};
		// String[] atbilde = {"Jā", "Nē"};
		ArrayList<Object> lietotnes = new ArrayList<>();
		
		int GB;
		do {
			GB = skaitlaParbaude("Kāds ir telefona izmērs?", 64, 1024);
		}while(GB == -1);
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību",
					"Izvēle", JOptionPane.QUESTION_MESSAGE, null,
					darbibas, darbibas[0]);
			if(izvele == null) break;
			
			izvelesID = Arrays.asList(darbibas).indexOf(izvele);
			
			switch(izvelesID) {
			
			case 0:
				izvele = (String) JOptionPane.showInputDialog(null, "Kādu aplikāciju novilkt?",
						"Izvēle", JOptionPane.QUESTION_MESSAGE, null,
						aplikacijas, aplikacijas[0]);
				if (izvele == null)break;
				
				switch(izvele) {
				
				case "Spēle":
					Random rand = new Random();
					String[] Kval = {"Augsta", "Viduvēja", "Zema", "Ļoti zema"};
					String[] Tips = {"Cīņu", "Šausmu", "RPG", "Simulators"};
					
					String g = Kval[rand.nextInt(4)];
					String t = (String)JOptionPane.showInputDialog(null, "Kāds ir spēles tips?",
							"Informācija", JOptionPane.QUESTION_MESSAGE, null,Tips, Tips[0]);
					
					break;
				
				case "Saziņas lietotne":
					break;
				
				}
				
				break;
			
			case 1:
				
				break;
			
			case 2:
				
				break;
			
			case 3:
				
				break;
			
			case 4:
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Apturēta",
						JOptionPane.PLAIN_MESSAGE);
				break;
			
				
			}
			
		}while(izvelesID != 4);
		
	}

}
