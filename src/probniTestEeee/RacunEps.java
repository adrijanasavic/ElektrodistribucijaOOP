package probniTestEeee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RacunEps {
	private int id;
	private String nazivVlasnika;
	private int potrosnjaNiza;
	private int potrosnjaVisa;
	private double cenaRacuna;
	private int mesecIzdavanja;
	private LocalDate datumPlacanja;
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public RacunEps() {
		super();
	}

	public RacunEps(int id, String nazivVlasnika, int potrosnjaNiza, int potrosnjaVisa, double cenaRacuna,
			int mesecIzdavanja, LocalDate datumPlacanja) {
		super();
		this.id = id;
		this.nazivVlasnika = nazivVlasnika;
		this.potrosnjaNiza = potrosnjaNiza;
		this.potrosnjaVisa = potrosnjaVisa;
		this.cenaRacuna = cenaRacuna;
		this.mesecIzdavanja = mesecIzdavanja;
		this.datumPlacanja = datumPlacanja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazivVlasnika() {
		return nazivVlasnika;
	}

	public void setNazivVlasnika(String nazivVlasnika) {
		this.nazivVlasnika = nazivVlasnika;
	}

	public int getPotrosnjaNiza() {
		return potrosnjaNiza;
	}

	public void setPotrosnjaNiza(int potrosnjaNiza) {
		this.potrosnjaNiza = potrosnjaNiza;
	}

	public int getPotrosnjaVisa() {
		return potrosnjaVisa;
	}

	public void setPotrosnjaVisa(int potrosnjaVisa) {
		this.potrosnjaVisa = potrosnjaVisa;
	}

	public double getCenaRacuna() {
		return cenaRacuna;
	}

	public void setCenaRacuna(double cenaRacuna) {
		this.cenaRacuna = cenaRacuna;
	}

	public int getMesecIzdavanja() {
		return mesecIzdavanja;
	}

	public void setMesecIzdavanja(int mesecIzdavanja) {
		this.mesecIzdavanja = mesecIzdavanja;
	}

	public LocalDate getDatumPlacanja() {
		return datumPlacanja;
	}

	public void setDatumPlacanja(LocalDate datumPlacanja) {
		this.datumPlacanja = datumPlacanja;
	}

	@Override
	public String toString() {
		return String.format("%10s %20s %15s %15s %10.2f %15s %15s", this.id, this.nazivVlasnika, this.potrosnjaNiza,
				this.potrosnjaVisa, this.cenaRacuna, this.mesecIzdavanja, dtf.format(this.datumPlacanja));
	}

}
