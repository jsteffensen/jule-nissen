import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JuleNissen {

	static List<Person> gaveKoebere = new ArrayList<Person>();
	static List<Person> gaveModtagere  = new ArrayList<Person>();
	
	static LinkedHashMap<Person, List<Person>> resultat = new LinkedHashMap<Person, List<Person>>();
	
	static HashMap<String, String> aar1;
	static HashMap<String, String> aar2;
	static HashMap<String, String> aar3;
	static HashMap<String, String> aar4;
	static HashMap<String, String> aar5;


	static boolean erUmuligLoesning;
	static boolean erTidligereLoesning;

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		
		erUmuligLoesning = false;
		erTidligereLoesning = false;
		
		opstilTidligereAar();
		
		opstilNavne();

	}

	private static void opstilNavne() {

		gaveKoebere.clear();
		gaveKoebere.add( new Person("Lilian", 1));
		gaveKoebere.add( new Person("Alfred", 1));
		gaveKoebere.add( new Person("Lise", 2));
		gaveKoebere.add( new Person("Kirsten", 3));
		gaveKoebere.add( new Person("Jesper K", 3));
		gaveKoebere.add( new Person("Sidsel", 4));
		gaveKoebere.add( new Person("Jesper S", 4));

		// lav de samme modtagere, som der findes i købere
		gaveModtagere.clear();
		gaveKoebere.forEach(p -> {
			String navn = p.navn;
			int group = p.group;
			gaveModtagere.add(new Person(navn, group));
		});
		
		// lav mulige udfald
		resultat.clear();
		gaveKoebere.forEach(koeber -> {
			
			// opstil mulige modtagere, som ikke er i familie med køber, og ikke er i de fire tidligere år
			List<Person> muligeModtagere = new ArrayList<Person>();
			
			gaveModtagere.forEach(modtager-> {
				boolean erISammeFamilie = erISammeFamilie(koeber, modtager);
				boolean erITidligereAar = erITidligereAar(koeber, modtager);
				
				if(!erISammeFamilie && !erITidligereAar) {
					muligeModtagere.add(modtager);
				}
			});			
			
			// indsæt køber og tilhørende mulige modtagere
			resultat.put(koeber, muligeModtagere);
		});
		
		
		printMuligheder();

	}
	
	private static void opstilTidligereAar() {
		
		aar1 = new HashMap<String, String>(); // 2020
		aar1.put("Lilian", "Lise");
		aar1.put("Alfred", "Jesper S");
		aar1.put("Lise", "Alfred");
		aar1.put("Kirsten", "Sidsel");
		aar1.put("Jesper K", "Lilian");
		aar1.put("Sidsel", "Jesper K");
		aar1.put("Jesper S", "Kirsten");

		aar2 = new HashMap<String, String>(); // 2019
		aar2.put("Lilian", "Kirsten");
		aar2.put("Alfred", "Sidsel");
		aar2.put("Lise", "Jesper S");
		aar2.put("Kirsten", "Alfred");
		aar2.put("Jesper K", "Lise");
		aar2.put("Sidsel", "Lilian");
		aar2.put("Jesper S", "Jesper K");
		
		aar3 = new HashMap<String, String>(); // 2018
		aar3.put("Lilian", "Jesper K");
		aar3.put("Alfred", "Sidsel");
		aar3.put("Lise", "Lilian");
		aar3.put("Kirsten", "Lise");
		aar3.put("Jesper K", "Jesper S");
		aar3.put("Sidsel", "Kirsten");
		aar3.put("Jesper S", "Alfred");
		
		aar4 = new HashMap<String, String>(); // 2017
		aar4.put("Lilian", "Sidsel");
		aar4.put("Alfred", "Lise");
		aar4.put("Lise", "Kirsten");
		aar4.put("Kirsten", "Lilian");
		aar4.put("Jesper K", "Jesper S");
		aar4.put("Sidsel", "Alfred");
		aar4.put("Jesper S", "Jesper K");
		

	}
	
	private static boolean erISammeFamilie(Person koeber, Person modtager) {
		
		return koeber.group == modtager.group;
		
	}
	
	private static boolean erITidligereAar(Person koeber, Person modtager) {
		
		boolean erIAar1 = aar1.get(koeber.navn).contentEquals(modtager.navn);
		boolean erIAar2 = aar2.get(koeber.navn).contentEquals(modtager.navn);
		boolean erIAar3 = aar3.get(koeber.navn).contentEquals(modtager.navn);
		boolean erIAar4 = aar4.get(koeber.navn).contentEquals(modtager.navn);
		
		return erIAar1 || erIAar2 || erIAar3 || erIAar4;
		
	}
	
	private static void printMuligheder() {
		
		resultat.forEach((k, v)-> {
			System.out.print(k.navn + " -> ");
			v.forEach(m-> {
				System.out.print(m.navn + " ");
			});
			System.out.println("\n");
		});
	}

}
