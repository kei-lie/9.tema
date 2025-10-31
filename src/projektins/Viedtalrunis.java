package projektins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	
	static int aplikacijasIzvele(ArrayList<Object> lietotnes) {
		String[] rSaraksts = new String[lietotnes.size()];
		
		for(int i = 0; i < rSaraksts.length; i++) {
			rSaraksts[i] = (((Lietotne)lietotnes.get(i)).noteiktNosaukumu())+" "
					+(((Lietotne)lietotnes.get(i)).noteiktVersiju());
		}
		
		String izveletais = (String)JOptionPane.showInputDialog(null, "Izvēlies aplikāciju", "Izvēle", JOptionPane.QUESTION_MESSAGE, 
				null, rSaraksts, rSaraksts[0]);
		
		return Arrays.asList(rSaraksts).indexOf(izveletais);
		
	}
	
	
	public static void main(String[] args) {
		Random rand = new Random();	//Lai nav jātaisa jauns random katru reizi
		String izvele;
		int izvelesID;
		String[] atbilde = {"Jā", "Nē"};
		String[] darbibas = {"Novilkt aplikāciju", "Dzēst aplikāciju","Aplikāciju saraksts",
				"Uzspēlēt spēli", "Nosūtīt ziņu",
				"Aizvērt programmu"};
		String[] aplikacijas = {"Spēle", "Saziņas lietotne"};
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
					String[] Kval = {"Augsta", "Viduvēja", "Zema", "Ļoti zema"};
					String[] Tips = {"RPG", "Šausmu", "Cīņu", "Simulators"};
					
					String g = Kval[rand.nextInt(4)];
					String t = (String)JOptionPane.showInputDialog(null, "Kāds ir spēles tips?",
							"Informācija", JOptionPane.QUESTION_MESSAGE, null,Tips, Tips[0]);
					
					String n = virknesParbaude("Kāds ir spēles nosaukums?", "Genshin Impact");
					String izs = virknesParbaude("Kas ir spēles izstrādātājs?", "Hoyoverse");
					int v = skaitlaParbaude("Lietotnes versija?", 1, 10);
					int izm = skaitlaParbaude("Lietotnes izmērs?", 1, 50);
					if(izm > GB) {JOptionPane.showMessageDialog(null, "Nepietiek atmiņas! Dabū jaunu telefonu.", "Kļūda", 
							JOptionPane.ERROR_MESSAGE);
					}else {
					GB -= izm;
					lietotnes.add(new Spele(g, t, n, izs, v, izm));
					}
					break;
				
				case "Saziņas lietotne":
					
					String atb = (String)JOptionPane.showInputDialog(null, "Vai atļaut piekļuvi kamerai?",
							"Izvēle", JOptionPane.QUESTION_MESSAGE, null,
							atbilde, atbilde[0]);
					if(atb == null) break;
					
					boolean a;
					if(atb == "Jā") {
						a = true;
					}else a = false;
					
					String atbil = (String)JOptionPane.showInputDialog(null, "Vai atļaut piekļuvi kontaktiem?",
							"Izvēle", JOptionPane.QUESTION_MESSAGE, null,
							atbilde, atbilde[0]);
					if(atbil == null) break;
					
					boolean b;
					if(atbil == "Jā") {
						b = true;
					}else b = false;
					
					String nos = virknesParbaude("Kāds ir lietotnes nosaukums?", "WhatsApp");
					String izstr = virknesParbaude("Kas ir lietotnes izstrādātājs?", "Meta");
					int vers = skaitlaParbaude("Lietotnes versija?", 1, 10);
					int izmers = skaitlaParbaude("Lietotnes izmērs?", 1, 50);
					GB -= izmers;
					
					lietotnes.add(new SazinasLietotne(a, b, nos, izstr, vers, izmers));
					
					break;
				}
				break;
				
			case 1:
				if(lietotnes.size() > 0) { 
					int app = aplikacijasIzvele(lietotnes);
					
					lietotnes.remove(app);
					JOptionPane.showMessageDialog(null, "Veiksmīgi izdzēsta aplikācija",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Nav lietotņu ko dzēst",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				break;
				
			case 2:
				
				if(lietotnes.size() > 0) { 
					String str = "Aplikāciju skaits: " + lietotnes.size()+
							"\n_________________________________\n";
					for(int i=0; i<lietotnes.size(); i++) {
						str += ((Lietotne)lietotnes.get(i)).izvadit()+
							"\n_________________________________\n";
					}
					
					JTextArea ta = new JTextArea (str, 10, 40);
					ta.setEditable(false);
					JScrollPane sp = new JScrollPane(ta);
					sp.setVerticalScrollBarPolicy(
							ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					JOptionPane.showMessageDialog(null, sp, "Aplikāciju saraksts",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Nav novilkta neviena aplikācija.",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				break;
			
			case 3:
				// UZSPĒLĒT SPĒLI
				ArrayList<Spele> speles = new ArrayList<>();
				for (Object o : lietotnes) {
					if (o instanceof Spele) speles.add((Spele)o);
				}

				if (speles.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav novilkta neviena aplikācija.", "Informācija", JOptionPane.INFORMATION_MESSAGE);
					break;
				}

				String[] spelesNos = new String[speles.size()];
				for (int i = 0; i < speles.size(); i++) {
					spelesNos[i] = speles.get(i).noteiktNosaukumu();
				}

				String speleIzv = (String)JOptionPane.showInputDialog(null, "Izvēlies spēli, kuru spēlēt:",
						"Spēles izvēle", JOptionPane.QUESTION_MESSAGE, null, spelesNos, spelesNos[0]);
				if (speleIzv == null) break;
				
				boolean uzv = rand.nextBoolean();

				if (uzv)
					JOptionPane.showMessageDialog(null, "Tu uzvarēji spēlē " + speleIzv + "!");
				else
					JOptionPane.showMessageDialog(null, "Tu zaudēji spēlē " + speleIzv + ".. :(");
				break;

			case 4:
				// NOSŪTĪT ZIŅU
				if (lietotnes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav novilkta neviena aplikācija.", "Informācija", JOptionPane.INFORMATION_MESSAGE);
					break;
				}

				String[] nosaukumi = new String[lietotnes.size()];
				for (int i = 0; i < lietotnes.size(); i++) {
					nosaukumi[i] = ((Lietotne)lietotnes.get(i)).noteiktNosaukumu();
				}

				String app = (String)JOptionPane.showInputDialog(null, "Izvēlies lietotni, ar kuru sūtīt ziņu:",
						"Ziņas sūtīšana", JOptionPane.QUESTION_MESSAGE, null, nosaukumi, nosaukumi[0]);
				if (app == null) break;

				String kam = virknesParbaude("Kam sūtīt ziņu?", "Sofija");
				if (kam == null) break;
				String zina = virknesParbaude("Kādu ziņu sūtīsi?", "ejam uz hesiti");
				if (zina == null) break;

				JOptionPane.showMessageDialog(null, "Ar lietotni \"" + app + "\" tika nosūtīta ziņa:\nAdresāts: " + kam + "\nZiņa: " + zina);
				break;

			case 5:
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Apturēta",
						JOptionPane.PLAIN_MESSAGE);
				break;
			}
			
			
		} while(izvelesID != 5);
		
	}
}
