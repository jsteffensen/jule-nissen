import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JuleNissen {

	static List<Person> gaveKoebere;
	static List<Person> gaveModtagere;
	static List<String> resultat = new ArrayList<String>();

	public static void main(String[] args) {

		opstilNavne();
		traekLod();
	}

	private static void opstilNavne() {

		gaveKoebere = new ArrayList<Person>();
		gaveKoebere.add( new Person("Lilian", 1));
		gaveKoebere.add( new Person("Alfred", 1));
		gaveKoebere.add( new Person("Lise", 2));
		gaveKoebere.add( new Person("Kirsten", 3));
		gaveKoebere.add( new Person("Jesper K", 3));
		gaveKoebere.add( new Person("Sidsel", 4));
		gaveKoebere.add( new Person("Jesper S", 4));

		gaveModtagere = new ArrayList<Person>();
		gaveModtagere.add( new Person("Lilian", 1));
		gaveModtagere.add( new Person("Alfred", 1));
		gaveModtagere.add( new Person("Lise", 2));
		gaveModtagere.add( new Person("Kirsten", 3));
		gaveModtagere.add( new Person("Jesper K", 3));
		gaveModtagere.add( new Person("Sidsel", 4));
		gaveModtagere.add( new Person("Jesper S", 4));

	}

	private static void traekLod() {

		for(int i = 0; i < gaveKoebere.size(); i++) {
			findKombination(gaveKoebere.get(i));
		}
	}

	private static void findKombination(Person koeber) {

		if( gaveModtagere.size() > 1 ) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, (gaveModtagere.size()-1));
			Person modtager = gaveModtagere.get(randomNum);

			while(koeber.group == modtager.group) {
				int nextRandom = randomNum = ThreadLocalRandom.current().nextInt(0, gaveModtagere.size());
				modtager = gaveModtagere.get(nextRandom);
			}

			resultat.add(koeber.navn + " k�ber til " + modtager.navn + ".");
			gaveModtagere.remove(randomNum);

		} else {

			if(koeber.group == gaveModtagere.get(0).group) {
				opstilNavne();
				traekLod();
			} else {
				resultat.add(koeber.navn + " k�ber til " + gaveModtagere.get(0).navn + ".");
				gaveModtagere.remove(0);

				printResultat();
			}
		}
	}

	private static void printResultat() {

		for(int i = 0; i < resultat.size(); i++) {
			System.out.println(resultat.get(i));
		}
	}

}
