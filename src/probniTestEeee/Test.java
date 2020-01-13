package probniTestEeee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static Scanner scanner = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public static boolean isNumber(String string) {

		try {
			int broj = Integer.parseInt(string);
			if (broj > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Pogresan identifikator.");
		}
		return false;

	}

	public static boolean isMesec(String mesec) {

		try {
			int broj = Integer.parseInt(mesec);
			if (broj >= 1 && broj <= 12) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Pogresan identifikator.");

		}
		return false;

	}

	public static boolean isDatePlacanja(LocalDate datumPocetni, String datum) {

		LocalDate datumKrajnji = null;
		try {
			datumKrajnji = LocalDate.parse(datum, dtf);
			if (datumKrajnji.compareTo(datumPocetni) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Pogresan identifikator.");

			return false;
		}
	}

	public static boolean isDouble(String string) {
		try {
			double broj = Double.parseDouble(string);
			if (broj > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Pogresan identifikator.");

		}
		return false;
	}

	public static boolean isDate(String datum) {

		try {
			LocalDate.parse(datum, dtf);
			return true;
		} catch (Exception e) {
			System.out.println("Pogresan identifikator.");

			return false;
		}
	}

	public static boolean isDatePlacanja(Date danasnji, String datum) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		Date datumPlac = null;
		try {
			datumPlac = sdf.parse(datum);
			if (datumPlac.compareTo(danasnji) > 0) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isDuzinaParcele(String parcela) {

		if (parcela.length() == 4) {
			return true;
		}
		return false;

	}

	public static void unosDistribucije(DistribucijaEps distribucijaEps) { // 1
		System.out.print("Unesite naziv elektrodistribucije:");
		String naziv = scanner.nextLine();
		distribucijaEps.setNaziv(naziv);
		System.out.print("Unesite adresu elektrodistribucije:");
		String adresa = scanner.nextLine();
		distribucijaEps.setAdresa(adresa);
		System.out.print("Unesite telefon elektrodistribucije:");
		String telefon = scanner.nextLine();
		distribucijaEps.setTelefon(telefon);

		System.out.println("Podaci o elektrodistribucije su uspesno dodati.");

	}

	public static void unosRacuna(DistribucijaEps distribucijaEps) { // 2

		int id = 0;
		String idString = null;
		String nazivVlasnika = null;
		int potrosnjaNiza = 0;
		String potrosnjaNizaS = null;
		int potrosnjaVisa = 0;
		String potrosnjaVisaS = null;
		double cenaRacuna = 0.0;
		String cenaRacunaS = null;
		int mesecIzdavanja = 0;
		String mesecIzdavanjaS = null;
		LocalDate datumPlacanja = null;
		String datumPlacanjaS = null;

		do {
			System.out.print("Identifikacioni broj: ");
			idString = scanner.nextLine();
		} while (!isNumber(idString));
		id = Integer.parseInt(idString);
		System.out.print("Unesite naziv vlasnika: ");
		nazivVlasnika = scanner.nextLine();

		do {
			System.out.print("Potrosnja niza: ");
			potrosnjaNizaS = scanner.nextLine();
		} while (!isNumber(potrosnjaNizaS));
		potrosnjaNiza = Integer.parseInt(potrosnjaNizaS);

		do {
			System.out.print("Potrosnja visa: ");
			potrosnjaVisaS = scanner.nextLine();
		} while (!isNumber(potrosnjaVisaS));
		potrosnjaVisa = Integer.parseInt(potrosnjaVisaS);
		do {
			System.out.print("Cena racuna: ");
			cenaRacunaS = scanner.nextLine();
		} while (!isDouble(cenaRacunaS));
		cenaRacuna = Double.parseDouble(cenaRacunaS);
		do {
			System.out.print("Mesec izdavanja racuna: ");
			mesecIzdavanjaS = scanner.nextLine();
		} while (!isMesec(mesecIzdavanjaS));
		mesecIzdavanja = Integer.parseInt(mesecIzdavanjaS);
		do {
			System.out.print("Datum placanja: ");
			datumPlacanjaS = scanner.nextLine();
		} while (!isDatePlacanja(new Date(), datumPlacanjaS));
		datumPlacanja = LocalDate.parse(datumPlacanjaS, dtf);
		RacunEps racunEps = new RacunEps(id, nazivVlasnika, potrosnjaNiza, potrosnjaVisa, cenaRacuna, mesecIzdavanja,
				datumPlacanja);

		boolean provera = distribucijaEps.unosRacuna(racunEps);
		if (provera) {
			System.out.println("Racun je uspesno dodata.");
		} else {
			System.out.println("Racun nije uspesno dodata.");
		}

	}

	public static void izmenaRacuna(DistribucijaEps distribucijaEps) { // 4
		int id = 0;
		String idString = null;
		String nazivVlasnika = null;
		int potrosnjaNiza = 0;
		String potrosnjaNizaS = null;
		int potrosnjaVisa = 0;
		String potrosnjaVisaS = null;
		double cenaRacuna = 0.0;
		String cenaRacunaS = null;

		int mesecIzdavanja = 0;
		String mesecIzdavanjaS = null;
		LocalDate datumPlacanja = null;
		String datumPlacanjaS = null;

		do {
			System.out.print("Identifikacioni broj: ");
			idString = scanner.nextLine();
		} while (!isNumber(idString));
		id = Integer.parseInt(idString);
		System.out.print("Unesite naziv vlasnika: ");
		nazivVlasnika = scanner.nextLine();

		do {
			System.out.print("Potrosnja niza: ");
			potrosnjaNizaS = scanner.nextLine();
		} while (!isNumber(potrosnjaNizaS));
		potrosnjaNiza = Integer.parseInt(potrosnjaNizaS);

		do {
			System.out.print("Potrosnja visa: ");
			potrosnjaVisaS = scanner.nextLine();
		} while (!isNumber(potrosnjaVisaS));
		potrosnjaVisa = Integer.parseInt(potrosnjaVisaS);
		do {
			System.out.print("Cena racuna: ");
			cenaRacunaS = scanner.nextLine();
		} while (!isDouble(cenaRacunaS));
		cenaRacuna = Double.parseDouble(cenaRacunaS);
		do {
			System.out.print("Mesec izdavanja racuna: ");
			mesecIzdavanjaS = scanner.nextLine();
		} while (!isMesec(mesecIzdavanjaS));
		mesecIzdavanja = Integer.parseInt(mesecIzdavanjaS);
		do {
			System.out.print("Datum placanja: ");
			datumPlacanjaS = scanner.nextLine();
		} while (!isDatePlacanja(new Date(), datumPlacanjaS));
		datumPlacanja = LocalDate.parse(datumPlacanjaS, dtf);
		RacunEps racunEps = new RacunEps(id, nazivVlasnika, potrosnjaNiza, potrosnjaVisa, cenaRacuna, mesecIzdavanja,
				datumPlacanja);
		distribucijaEps.izmenaRacuna(racunEps);
	}

	public static void brisanjeRacuna(DistribucijaEps distribucijaEps) { // 5
		int id = 0;
		String idString = null;
		do {
			System.out.print("Identifikacioni broj: ");
			idString = scanner.nextLine();
		} while (!isNumber(idString));
		id = Integer.parseInt(idString);
		distribucijaEps.brisanjeRacuna(id);
	}

	public static void ispisRacunaMinMax(DistribucijaEps distribucijaEps) { // 6
		/* int minNiza, int maxNiza, int minVisa, int maxVisa */
		int minNiza = 0;
		String minNizaS = null;
		int maxNiza = 0;
		String maxNizaS = null;
		int minVisa = 0;
		String minVisaS = null;
		int maxVisa = 0;
		String maxVisaS = null;

		do {
			System.out.print("Unesite minimalnu nizu tarifu: ");
			minNizaS = scanner.nextLine();
		} while (!isNumber(minNizaS));
		minNiza = Integer.parseInt(minNizaS);

		do {
			System.out.print("Unesite maksimalnu nizu tarifu: ");
			maxNizaS = scanner.nextLine();
		} while (!isNumber(maxNizaS));
		maxNiza = Integer.parseInt(maxNizaS);
		do {
			System.out.print("Unesite minimalnu visu tarifu: ");
			minVisaS = scanner.nextLine();
		} while (!isNumber(minVisaS));
		minVisa = Integer.parseInt(minVisaS);
		do {
			System.out.print("Unesite maksimalnu visu tarifu: ");
			maxVisaS = scanner.nextLine();
		} while (!isNumber(maxVisaS));
		maxVisa = Integer.parseInt(maxVisaS);
		distribucijaEps.ispisRacunaMinMax(minNiza, maxNiza, minVisa, maxVisa);

	}

	public static void ispisProsPot(DistribucijaEps distribucijaEps) { // 7
		int mesec = 0;
		String mesecS = null;
		do {
			System.out.print("Mesec izdavanja racuna: ");
			mesecS = scanner.nextLine();
		} while (!isMesec(mesecS));
		mesec = Integer.parseInt(mesecS);
		distribucijaEps.ispisProsPot(mesec);
	}

	public static void ispisVecPros(DistribucijaEps distribucijaEps) { // 8
		int mesec = 0;
		String mesecS = null;
		do {
			System.out.print("Mesec izdavanja racuna: ");
			mesecS = scanner.nextLine();
		} while (!isMesec(mesecS));
		mesec = Integer.parseInt(mesecS);
		distribucijaEps.ispisVecPros(mesec);
	}

	public static void ispisNajRacun(DistribucijaEps distribucijaEps) { // 9
		LocalDate pocetak = null;
		String pocetakS = null;
		LocalDate kraj = null;
		String krajS = null;
		do {
			System.out.print("Datum pocetka: ");
			pocetakS = scanner.nextLine();
		} while (!isDate(pocetakS));
		pocetak = LocalDate.parse(pocetakS, dtf);
		do {
			System.out.print("Datum pocetka: ");
			krajS = scanner.nextLine();
		} while (!isDate(krajS));
		kraj = LocalDate.parse(krajS, dtf);
		distribucijaEps.ispisNajRacun(pocetak, kraj);
	}

	public static void main(String[] args) {
		DistribucijaEps distribucijaEps = new DistribucijaEps();
		distribucijaEps.load("racuni.txt");

		String answer = null;

		do {

			System.out.println("Meni:");
			System.out.println("1. Unos podataka o elektrodistribuciji");
			System.out.println("2. Unos racuna");
			System.out.println("3. Ispis svih racuna");
			System.out.println("4. Izmena racuna");
			System.out.println("5. Brisanje racuna");
			System.out.println("6. Ispis svih racuna u zadatom opsegu min i max tarife");
			System.out.println("7. Ispis prosecne potrosnje za zadati mesec");
			System.out.println("8. Ispis  racuna vece od proseka za zadati mesec");
			System.out.println("9. Ispis najskupljeg racuna koji je placen u zadatom peridu ");
			System.out.println("10. Ispis podataka o elektrodistribuciji");
			System.out.println("x. Izlaz");

			answer = scanner.nextLine();

			switch (answer) {
			case "1":
				unosDistribucije(distribucijaEps);
				break;
			case "2":
				unosRacuna(distribucijaEps);
				distribucijaEps.save("racuni.txt");
				break;
			case "3":
				distribucijaEps.ispisRacuna();
				break;
			case "4":
				izmenaRacuna(distribucijaEps);
				distribucijaEps.save("racuni.txt");

				break;
			case "5":
				brisanjeRacuna(distribucijaEps);
				distribucijaEps.save("racuni.txt");
				break;
			case "6":
				ispisRacunaMinMax(distribucijaEps);
				break;
			case "7":
				ispisProsPot(distribucijaEps);
				break;
			case "8":
				ispisVecPros(distribucijaEps);
				break;
			case "9":
				ispisNajRacun(distribucijaEps);
				break;
			case "10":
				System.out.println(distribucijaEps);
				break;
			case "x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
			}

		} while (!answer.equals("x"));

		// distribucijaEps.save("racuni.txt");
		scanner.close();

	}
}
