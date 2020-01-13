package probniTestEeee;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DistribucijaEps {
	private String naziv;
	private String adresa;
	private String telefon;
	private String nesto;
	private ArrayList<RacunEps> lista;

	public DistribucijaEps() {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.lista = new ArrayList<>();
	}

	public DistribucijaEps(String naziv, String adresa, String telefon, ArrayList<RacunEps> lista) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.lista = new ArrayList<>();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public ArrayList<RacunEps> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RacunEps> lista) {
		this.lista = lista;
	}

	public boolean unosRacuna(RacunEps racun) { // 2 unos racuna
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getId() == racun.getId()) {
				return false;
			}
		}
		this.lista.add(racun);
		return true;
	}

	public void ispisRacuna() { // 3 ispis racuna

		System.out.printf("%10s %20s %15s %15s %10s %15s %15s \n", "Id", "Naziv vlasnika", "Potrosna niza",
				"Potrosna niza", "Cena racuna", "Mesec izdavanja", "Datum placanja");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.lista.size(); i++) {
			System.out.println(this.lista.get(i));
		}
	}

	public void izmenaRacuna(RacunEps racun) { // 4 izmena racuna
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getId() == racun.getId()) {
				this.lista.set(i, racun);
				System.out.println("Racun je uspesno izmenjena.");
				return;
			}
		}
		System.out.println("Racun nije pronadjena.");
	}

	public void brisanjeRacuna(int id) { // 5 brisanje racuna
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getId() == id) {
				this.lista.remove(i);
				System.out.println("Racun je uspesno obrisana.");
				return;
			}

		}
		System.out.println("Racun nije uspesno obrisana.");

	}

	public void ispisRacunaMinMax(int minNiza, int maxNiza, int minVisa, int maxVisa) { // 6
		System.out.printf("%10s %20s %15s %15s %10s %15s %15s \n", "Id", "Naziv vlasnika", "Potrosna niza",
				"Potrosna niza", "Cena racuna", "Mesec izdavanja", "Datum placanja");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getPotrosnjaNiza() >= minNiza && this.lista.get(i).getPotrosnjaNiza() <= maxNiza
					&& this.lista.get(i).getPotrosnjaVisa() >= minVisa
					&& this.lista.get(i).getPotrosnjaVisa() <= maxVisa) {

				System.out.println(this.lista.get(i));
			}

		}

	}

	public void ispisProsPot(int mesec) { // 7

		int ukupnaNiza = 0;
		int ukupnaVisa = 0;
		int ukupnoRacuna = 0;

		for (int i = 0; i < this.lista.size(); i++) {
			ukupnaNiza += this.lista.get(i).getPotrosnjaNiza();
			ukupnaVisa += this.lista.get(i).getPotrosnjaVisa();
			ukupnoRacuna++;

		}
		double proseNiza = ukupnaNiza / ukupnoRacuna;
		double prosekVisa = ukupnaVisa / ukupnoRacuna;
		System.out.println("Prosecna potrosnja u nizoj tarifi " + proseNiza);
		System.out.println("Prosecna potrosnja u visoj tarifi " + prosekVisa);

	}

	public void ispisVecPros(int mesec) { // 8 nauciti
		int ukupnaNizaVisa = 0;
		int brRacuna = 0;
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getMesecIzdavanja() == mesec) {
				ukupnaNizaVisa += this.lista.get(i).getCenaRacuna();
				brRacuna++;

			}
		}
		double prosek = ukupnaNizaVisa / brRacuna;
		System.out.printf("%10s %20s %15s %15s %10s %15s %15s \n", "Id", "Naziv vlasnika", "Potrosna niza",
				"Potrosna niza", "Cena racuna", "Mesec izdavanja", "Datum placanja");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getCenaRacuna() > prosek) {
				System.out.println(this.lista.get(i));

			}

		}
	}

	public void ispisNajRacun(LocalDate pocetak, LocalDate kraj) { // 9
		System.out.printf("%10s %20s %15s %15s %10s %15s %15s \n", "Id", "Naziv vlasnika", "Potrosna niza",
				"Potrosna niza", "Cena racuna", "Mesec izdavanja", "Datum placanja");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------");
		RacunEps maxRacun = null;
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getDatumPlacanja().compareTo(pocetak) >= 0
					&& this.lista.get(i).getDatumPlacanja().compareTo(kraj) <= 0) {
				if (maxRacun == null) {
					maxRacun = this.lista.get(i);

				} else {
					if (maxRacun.getCenaRacuna() < this.lista.get(i).getCenaRacuna()) {
						maxRacun = this.lista.get(i);

					}
				}
			}
		}
		if (maxRacun != null) {
			System.out.println(maxRacun);

		} else {
			System.out.println("Ne postoji racun u zadatom intervalu.");
		}

	}

	public void save(String path) {

		ArrayList<String> lines = new ArrayList<String>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		lines.add(this.naziv);
		lines.add(this.adresa);
		lines.add(this.telefon);

		for (int i = 0; i < this.lista.size(); i++) {

			RacunEps racun = this.lista.get(i);
			int id = racun.getId();
			String nazivVlasnika = racun.getNazivVlasnika();
			int potrosnjaNiza = racun.getPotrosnjaNiza();
			int potrosnjaVisa = racun.getPotrosnjaVisa();
			double cenaRacuna = racun.getCenaRacuna();
			int mesecIzdavanja = racun.getMesecIzdavanja();
			String datumPlacanja = dtf.format(racun.getDatumPlacanja());

			String line = id + ";" + nazivVlasnika + ";" + potrosnjaNiza + ";" + potrosnjaVisa + ";" + cenaRacuna + ";"
					+ mesecIzdavanja + ";" + datumPlacanja;
			lines.add(line);
		}
		try {
			Files.write(Paths.get(path), lines, Charset.defaultCharset(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (java.io.IOException e) {
			System.out.println("Desila se greska prilikom cuvanja podataka.");

		}
	}

	public void load(String path) {

		this.lista = new ArrayList<RacunEps>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
			this.naziv = lines.get(0);
			this.adresa = lines.get(1);
			this.telefon = lines.get(3);
			for (int i = 3; i < lines.size(); i++) {
				String[] niz = lines.get(i).split(";");

				int id = Integer.parseInt(niz[0]);
				String nazivVlasnika = niz[1];
				int potrosnjaNiza = Integer.parseInt(niz[2]);
				int potrosnjaVisa = Integer.parseInt(niz[3]);
				double cenaRacuna = Double.parseDouble(niz[4]);
				int mesecIzdavanja = Integer.parseInt(niz[5]);
				LocalDate datumPlacanja = LocalDate.parse(niz[6], dtf);
				RacunEps racun = new RacunEps(id, nazivVlasnika, potrosnjaNiza, potrosnjaVisa, cenaRacuna,
						mesecIzdavanja, datumPlacanja);
				this.lista.add(racun);

			}

		} catch (java.io.IOException e) {
			System.out.println("Desila se greska prilikom citanja fajla.");
		} catch (NumberFormatException e) {
			System.out.println("Desila se greska prilikom konverzije brojeva.");
		} catch (DateTimeParseException e) {
			System.out.println("Desila se greska prilikom konverzije datuma.");
		} catch (Exception e) {
			System.out.println("Desila se nepredvidjena greska.");

		}
	}

	public double ukupnaZarada() {
		double suma = 0.0;
		for (int i = 0; i < this.lista.size(); i++) {
			suma += this.lista.get(i).getCenaRacuna();
		}
		return suma;
	}

	@Override
	public String toString() {
		String temp = "";
		temp += "Naziv elektrodistribucije: " + this.naziv + "\n";
		temp += "Adresa elektrodistribucije: " + this.adresa + "\n";
		temp += "Telefon elektrodistribucije: " + this.telefon + "\n";
		temp += "Ukupna zarada: " + ukupnaZarada() + "\n";
		temp += "Ukupan broj racuna: " + this.lista.size() + "\n";

		return temp.trim();

	}

}
