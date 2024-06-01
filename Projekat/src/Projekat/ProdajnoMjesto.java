package Projekat;

public class ProdajnoMjesto {
	private int id;
	private String grad;
	private String drzava;
	private String adresa;
	private String telefon;
	
	public ProdajnoMjesto(int id, String grad, String drzava, String adresa, String telefon) {
		this.id=id;
		this.grad=grad;
		this.drzava=drzava;
		this.adresa=adresa;
		this.telefon=telefon;
	}
	
	public int getId() {
		return id;
	}
	
	public String getGrad() {
		return grad;
	}
	
	public String getDrzava() {
		return drzava;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public String getTelefon() {
		return telefon;
	}
}