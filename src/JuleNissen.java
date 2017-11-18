import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JuleNissen {

	static List<GaveModtager> gaveKoebere;
	static List<GaveModtager> gaveModtagere;
	static List<String> resultat = new ArrayList<String>();

	public static void main(String[] args) {

		opstilNavne();
	}

	private static void opstilNavne() {

		gaveKoebere = new ArrayList<GaveModtager>();
		gaveKoebere.add( new GaveModtager("Lilian", 1));
		gaveKoebere.add( new GaveModtager("Alfred", 1));
		gaveKoebere.add( new GaveModtager("Lise", 2));
		gaveKoebere.add( new GaveModtager("Kirsten", 3));
		gaveKoebere.add( new GaveModtager("Steffen", 3));
		gaveKoebere.add( new GaveModtager("Sidsel", 4));
		gaveKoebere.add( new GaveModtager("Jesper", 4));

		gaveModtagere = new ArrayList<GaveModtager>();
		gaveModtagere.add( new GaveModtager("Lilian", 1));
		gaveModtagere.add( new GaveModtager("Alfred", 1));
		gaveModtagere.add( new GaveModtager("Lise", 2));
		gaveModtagere.add( new GaveModtager("Kirsten", 3));
		gaveModtagere.add( new GaveModtager("Steffen", 3));
		gaveModtagere.add( new GaveModtager("Sidsel", 4));
		gaveModtagere.add( new GaveModtager("Jesper", 4));

		traekLod();
	}

	private static void traekLod() {

		for(int i = 0; i < gaveKoebere.size(); i++) {
			findKombination(gaveKoebere.get(i));
		}
	}

	private static void findKombination(GaveModtager koeber) {

		if( gaveModtagere.size() > 1 ) {

			int randomNum = ThreadLocalRandom.current().nextInt(0, (gaveModtagere.size()-1));
			GaveModtager modtager = gaveModtagere.get(randomNum);

			while(koeber.group == modtager.group) {
				int nextRandom = randomNum = ThreadLocalRandom.current().nextInt(0, gaveModtagere.size());
				modtager = gaveModtagere.get(nextRandom);
			}

			resultat.add(koeber.navn + " køber til " + modtager.navn + ".");
			gaveModtagere.remove(randomNum);

		} else {

			if(koeber.group == gaveModtagere.get(0).group) {
				opstilNavne();
			} else {
				resultat.add(koeber.navn + " køber til " + gaveModtagere.get(0).navn + ".");
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
