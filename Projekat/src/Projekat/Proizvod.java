package Projekat;

public class Proizvod {
	private int id;
	private String naziv;
	private String opis;
	private double cijena;
	
	public Proizvod(int id, String naziv, String opis, double cijena) {
		this.id=id;
		this.naziv=naziv;
		this.opis=opis;
		this.cijena=cijena;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public Double getCijena() {
		return cijena;
	}
}