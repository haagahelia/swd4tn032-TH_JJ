package viikko4.metodit.jj;

public class MetodinPaluuarvo {

	public static void main(String[] args) {
		// metodin suorituksen jälkeen sen palauttama arvo voidaan ottaa talteen:
		int luku = palautetaanAinaKymppi();

		System.out.println("metodi palautti: " + luku);
	}

	public static int palautetaanAinaKymppi() {
		// return-käsky palauttaa sen jälkeen olevan arvon:
		return 10;
	}

}
