import java.io.Serializable;

public class InfoPraktikum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String namaKoordinator;
	String topik;
	
	public InfoPraktikum() {
		
	}
	
	public InfoPraktikum(String namaKoordinator, String topik) {
		this.namaKoordinator = namaKoordinator;
		this.topik = topik;
	}

	public String getNamaKoordinator() {
		return namaKoordinator;
	}

	public void setNamaKoordinator(String namaKoordinator) {
		this.namaKoordinator = namaKoordinator;
	}

	public String getTopik() {
		return topik;
	}

	public void setTopik(String topik) {
		this.topik = topik;
	}
	
	
}
