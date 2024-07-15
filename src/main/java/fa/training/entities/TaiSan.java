package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "TAI_SAN")
public class TaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int taisanid;
	@Column(name = "TEN_TAI_SAN")
	private String tentaissan;
	@ManyToOne
	@JoinColumn(name = "loaitaisanid")
	private LoaiTaiSan loaitaisanid;
	@Column(name = "TRANG_THAI")
	private String trangthai;
	@OneToMany(mappedBy = "taisanid", fetch = FetchType.EAGER)
	private List<NhanVienTaiSan> listts = new ArrayList<NhanVienTaiSan>();
	public int getTaisanid() {
		return taisanid;
	}
	public void setTaisanid(int taisanid) {
		this.taisanid = taisanid;
	}
	public String getTentaissan() {
		return tentaissan;
	}
	public void setTentaissan(String tentaissan) {
		this.tentaissan = tentaissan;
	}
	public LoaiTaiSan getLoaitaisanid() {
		return loaitaisanid;
	}
	public void setLoaitaisanid(LoaiTaiSan loaitaisanid) {
		this.loaitaisanid = loaitaisanid;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public List<NhanVienTaiSan> getListts() {
		return listts;
	}
	public void setListts(List<NhanVienTaiSan> listts) {
		this.listts = listts;
	}
	public TaiSan(String tentaissan, LoaiTaiSan loaitaisanid, String trangthai) {
		super();
		this.tentaissan = tentaissan;
		this.loaitaisanid = loaitaisanid;
		this.trangthai = trangthai;
	}
	public TaiSan() {
		super();
	}
	@Override
	public String toString() {
		return "TaiSan [getTaisanid()=" + getTaisanid() + ", getTentaissan()=" + getTentaissan()
				+ ", getLoaitaisanid()=" + getLoaitaisanid() + ", getTrangthai()=" + getTrangthai() + "]";
	}
	public void showinfoTaisan() {
		System.out.println("|| Taisanid :" + getTaisanid() + " || Tentaissan()=" + getTentaissan()
				+ " || Loaitaisanid : " + getLoaitaisanid() + " || Trangthai : " + getTrangthai() + "]");
	}
}
