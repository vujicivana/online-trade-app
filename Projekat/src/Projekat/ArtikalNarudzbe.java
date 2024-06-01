package Projekat;

public class ArtikalNarudzbe {
	private int narudzba_id;
	private int proizvod_id;
	private int kolicina;
	private double cijena_po_komadu;
	private int id;
	private Narudzba narudzba;
	
	public ArtikalNarudzbe(int narudzba_id, int proizvod_id, int kolicina, double cijena_po_komadu, int id) {
		this.narudzba_id=narudzba_id;
		this.proizvod_id=proizvod_id;
		this.kolicina=kolicina;
		this.cijena_po_komadu=cijena_po_komadu;
		this.id=id;
	}
	
	public ArtikalNarudzbe(int narudzba_id, int proizvod_id, int kolicina, double cijena_po_komadu, int id, Narudzba narudzba) {
		this.narudzba_id=narudzba_id;
		this.proizvod_id=proizvod_id;
		this.kolicina=kolicina;
		this.cijena_po_komadu=cijena_po_komadu;
		this.id=id;
		this.narudzba=narudzba;
	}
	
	public int getNarudzbaId() {
		return narudzba_id;
	}
	
	public int getProizvodId() {
		return proizvod_id;
	}
	
	public int getKolicina() {
		return kolicina;
	}
	
	public double getCijenaPoKomadu() {
		return cijena_po_komadu;
	}
	
	public int getId() {
		return id;
	}
	
	public Narudzba getNarudzba() {
		return narudzba;
	}
	
	public void setNarudzba(Narudzba narudzba) {
		this.narudzba=narudzba;
	}
}