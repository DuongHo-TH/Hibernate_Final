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
@Table(name = "NHAN_VIEN")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int nvid;
	@Column(name = "TEN_NV")
	private String tennv;
	@ManyToOne
	@JoinColumn(name = "phongbanid")
	private PhongBan phongbanid;
	@OneToMany(mappedBy = "nvid", fetch = FetchType.EAGER)
	private List<NhanVienTaiSan> listts = new ArrayList<NhanVienTaiSan>();
	public int getNvid() {
		return nvid;
	}
	public void setNvid(int nvid) {
		this.nvid = nvid;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public PhongBan getPhongban() {
		return phongbanid;
	}
	public void setPhongban(PhongBan phongban) {
		this.phongbanid = phongban;
	}
	public List<NhanVienTaiSan> getListts() {
		return listts;
	}
	public void setListts(List<NhanVienTaiSan> listts) {
		this.listts = listts;
	}
	public NhanVien(String tennv, PhongBan phongban) {
		super();
		this.tennv = tennv;
		this.phongbanid = phongban;
	}
	public NhanVien() {
		super();
	}
	@Override
	public String toString() {
		return "NhanVien [getNvid()=" + getNvid() + ", getTennv()=" + getTennv() + "]";
	}
	
	public void showinfonhanvien() {
		System.out.println(" || Nvid : " + getNvid() + " || Tennv : " + getTennv());
	}
}
