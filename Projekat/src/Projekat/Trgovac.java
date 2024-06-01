package Projekat;

public class Trgovac {
	private int id;
	private String korisnicko_ime;
	private String ime;
	private String prezime;
	private String lozinka;
	private String pol;
	private String telefon;
	private String email;
	private int prodajno_mjesto_id;
	
	public Trgovac(int id, String korisnicko_ime, String ime, String prezime, String lozinka, String pol, String telefon, String email, int prodajno_mjesto_id) {
		this.id=id;
		this.korisnicko_ime=korisnicko_ime;
		this.ime=ime;
		this.prezime=prezime;
		this.lozinka=lozinka;
		this.pol=pol;
		this.telefon=telefon;
		this.email=email;
		this.prodajno_mjesto_id=prodajno_mjesto_id;
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
	
	public String getPol() {
		return pol;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getProdajnoMjestoId() {
		return prodajno_mjesto_id;
	}
}