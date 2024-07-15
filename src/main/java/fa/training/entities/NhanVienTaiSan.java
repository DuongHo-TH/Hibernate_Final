package fa.training.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHAN_VIEN_TAI_SAN")
public class NhanVienTaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nvid")
	private NhanVien nvid;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "taisanid")
	private TaiSan taisanid;
	@Column(name = "NGAY_MUON")
	private LocalDate ngaymuon;
	@Column(name = "NGAY_TRA")
	private LocalDate ngaytra;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NhanVien getNvid() {
		return nvid;
	}
	public void setNvid(NhanVien nvid) {
		this.nvid = nvid;
	}
	public TaiSan getTaisanid() {
		return taisanid;
	}
	public void setTaisanid(TaiSan taisanid) {
		this.taisanid = taisanid;
	}
	public LocalDate getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(LocalDate ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public LocalDate getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(LocalDate ngaytra) {
		this.ngaytra = ngaytra;
	}
	public NhanVienTaiSan(NhanVien nvid, TaiSan taisanid, LocalDate ngaymuon) {
		super();
		this.nvid = nvid;
		this.taisanid = taisanid;
		this.ngaymuon = ngaymuon;
	}
	public NhanVienTaiSan() {
		super();
	}
	@Override
	public String toString() {
		return " || Id : " + getId() + " || Nvid : " + getNvid() + " || Taisanid : " + getTaisanid()
				+ " || Ngaymuon : " + getNgaymuon() + " || Ngaytra : " + getNgaytra() + "||";
	}
	public void showinfornvts() {
		System.out.println( " || Id : " + getId() + " || Nvid : " + getNvid() + " || Taisanid : " + getTaisanid()
				+ " || Ngaymuon : " + getNgaymuon() + " || Ngaytra : " + getNgaytra() + "||");
	}
}
