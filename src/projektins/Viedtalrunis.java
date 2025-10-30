package projektins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Viedtalrunis {
	
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null) return null;
			
			virkne = virkne.trim();
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
	
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
	
	static int ritenaIzvele(ArrayList<Object> lietotnes) {
		String[] rSaraksts = new String[lietotnes.size()];
		
		for(int i = 0; i < rSaraksts.length; i++) {
			rSaraksts[i] = (((Lietotne)lietotnes.get(i)).noteiktIzstradataju())+" "
					+(((Lietotne)lietotnes.get(i)).noteiktIzmeru())+" EUR";
		}
		
		String izveletais = (String)JOptionPane.showInputDialog(null, "", "", JOptionPane.QUESTION_MESSAGE, 
				null, rSaraksts, rSaraksts[0]);
		
		return Arrays.asList(rSaraksts).indexOf(izveletais);
		
	}
	
	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String[] atbilde = {"Jā", "Nē"};
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
					
					String n = virknesParbaude("Kāds ir spēles nosaukums?", "Genshin Impact");
					String izs = virknesParbaude("Kas ir spēles izstrādātājs?", "Hoyoverse");
					int v = skaitlaParbaude("Lietotnes versija?", 1, 10);
					int izm = skaitlaParbaude("Lietotnes izmērs?", 1, 50);
					GB -= izm;
					
					lietotnes.add(new Spele(g, t, n, izs, v, izm));
					
					break;
				
				case "Saziņas lietotne":
					
					boolean a, b;
					izvele = (String)JOptionPane.showInputDialog(null, "Vai atļaut piekļuvi kamerai?",
							"Izvēle", JOptionPane.QUESTION_MESSAGE, null,
							atbilde, atbilde[0]);
					if(izvele == null) break;
					
					if(izvele == "Jā")
						a = true;
					else a = false;
					
					izvele = (String)JOptionPane.showInputDialog(null, "Vai atļaut piekļuvi kontaktiem?",
							"Izvēle", JOptionPane.QUESTION_MESSAGE, null,
							atbilde, atbilde[0]);
					if(izvele == null) break;
					
					if(izvele == "Jā")
						b = true;
					else b = false;
					
					String nos = virknesParbaude("Kāds ir spēles nosaukums?", "WhatsApp");
					String izstr = virknesParbaude("Kas ir spēles izstrādātājs?", "Meta");
					int vers = skaitlaParbaude("Lietotnes versija?", 1, 10);
					int izmers = skaitlaParbaude("Lietotnes izmērs?", 1, 50);
					GB -= izmers;
					
					lietotnes.add(new SazinasLietotne(a, b, nos, izstr, vers, izmers));
					
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
