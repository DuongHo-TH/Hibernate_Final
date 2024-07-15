package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "PHONG_BAN")
public class PhongBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int phongbanid;
	@Column(name = "TEN_PHONG_BAN")
	private String tenphongban;
	@OneToMany(mappedBy = "phongbanid", fetch = FetchType.EAGER)
	private List<NhanVien> listnv = new ArrayList<NhanVien>();
	public int getPhongbanid() {
		return phongbanid;
	}
	public void setPhongbanid(int phongbanid) {
		this.phongbanid = phongbanid;
	}
	public String getTenphongban() {
		return tenphongban;
	}
	public void setTenphongban(String tenphongban) {
		this.tenphongban = tenphongban;
	}
	public List<NhanVien> getListnv() {
		return listnv;
	}
	public void setListnv(List<NhanVien> listnv) {
		this.listnv = listnv;
	}
	public PhongBan(String tenphongban) {
		super();
		this.tenphongban = tenphongban;
	}
	public PhongBan() {
		super();
	}

}
