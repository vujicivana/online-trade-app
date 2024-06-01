package Projekat;

import java.util.ArrayList;

public class Narudzba {
	private int id;
	private int kupac_id;
	private int trgovac_id;
	private String datum_narudzbe;
	private String datum_isporuke;
	private String napomena;
	private ArrayList<ArtikalNarudzbe> lista_artikala_narudzbe=new ArrayList<ArtikalNarudzbe>();
	
	public Narudzba(int id, int kupac_id, int trgovac_id, String datum_narudzbe, String datum_isporuke, String napomena) {
		this.id=id;
		this.kupac_id=kupac_id;
		this.trgovac_id=trgovac_id;
		this.datum_narudzbe=datum_narudzbe;
		this.datum_isporuke=datum_isporuke;
		this.napomena=napomena;
	}
	
	public Narudzba(int id, int kupac_id, int trgovac_id, String datum_narudzbe, String datum_isporuke, String napomena, ArrayList<ArtikalNarudzbe> lista_artikala_narudzbe) {
		this.id=id;
		this.kupac_id=kupac_id;
		this.trgovac_id=trgovac_id;
		this.datum_narudzbe=datum_narudzbe;
		this.datum_isporuke=datum_isporuke;
		this.napomena=napomena;
		this.lista_artikala_narudzbe=lista_artikala_narudzbe;
	}
	
	public int getId() {
		return id;
	}
	
	public int getKupacId() {
		return kupac_id;
	}

	public int getTrgovacId() {
		return trgovac_id;
	}
	
	public String getDatumNarudzbe() {
		return datum_narudzbe;
	}
	
	public String getDatumIsporuke() {
		return datum_isporuke;
	}
	
	public String getNapomena() {
		return napomena;
	}
	
	public ArrayList<ArtikalNarudzbe> getListaArtikalaNarudzbe() {
		return lista_artikala_narudzbe;
	}
}