package Projekat;

public class Kupac {
	private int id;
	private String korisnicko_ime;
	private String ime;
	private String prezime;
	private String lozinka;
	private String telefon;
	private String adresa;
	private String grad;
	private String drzava;
	private String postanski_broj;
	private String pol;
	private String email;
	
	public Kupac(int id, String korisnicko_ime, String ime, String prezime, String lozinka, String telefon, String adresa, String grad, String drzava, String postanski_broj, String pol, String email) {
		this.id=id;
		this.korisnicko_ime=korisnicko_ime;
		this.ime=ime;
		this.prezime=prezime;
		this.lozinka=lozinka;
		this.telefon=telefon;
		this.adresa=adresa;
		this.grad=grad;
		this.drzava=drzava;
		this.postanski_broj=postanski_broj;
		this.pol=pol;
		this.email=email;
	}
	
	public int getId() {
		return id;
	}
	
	public String getKorisnickoIme() {
		return korisnicko_ime;
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public String getGrad() {
		return grad;
	}
	
	public String getDrzava() {
		return drzava;
	}
	
	public String getPostanskiBroj() {
		return postanski_broj;
	}
	
	public String getPol() {
		return pol;
	}
	
	public String getEmail() {
		return email;
	}
}