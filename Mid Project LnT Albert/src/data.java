
public class data {
	private String kode;
	private String nama;
	private String jenis;
	private String kerja;
	private int gaji;
	public data() {
		// TODO Auto-generated constructor stub
		
	}
	public data(String kode, String nama, String jenis, String kerja, int gaji) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.jenis = jenis;
		this.kerja = kerja;
		this.gaji = gaji;
	}
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getKerja() {
		return kerja;
	}
	public void setKerja(String kerja) {
		this.kerja = kerja;
	}
	public int getGaji() {
		return gaji;
	}
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
}
