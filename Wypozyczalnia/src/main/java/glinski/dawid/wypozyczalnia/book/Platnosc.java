package glinski.dawid.wypozyczalnia.book;

public class Platnosc {
	private String nr_rachunku;
	private String NIP;
	private String data;
	private double kwota;

	public String getNr_rachunku() {
		return nr_rachunku;
	}

	public void setNr_rachunku(String nr_rachunku) {
		this.nr_rachunku = nr_rachunku;
	}

	public String getNIP() {
		return NIP;
	}

	public void setNIP(String nIP) {
		NIP = nIP;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

}
