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
@Table(name = "LOAI_TAI_SAN")
public class LoaiTaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int loaitaisanid;
	@Column(name = "LOAI_TAI_SAN")
	private String loaitaisan;
	@OneToMany(mappedBy = "loaitaisanid", fetch = FetchType.EAGER)
	private List<TaiSan> list = new ArrayList<TaiSan>();
	public int getLoaitaisanid() {
		return loaitaisanid;
	}
	public void setLoaitaisanid(int loaitaisanid) {
		this.loaitaisanid = loaitaisanid;
	}
	public String getLoaitaisan() {
		return loaitaisan;
	}
	public void setLoaitaisan(String loaitaisan) {
		this.loaitaisan = loaitaisan;
	}
	public List<TaiSan> getList() {
		return list;
	}
	public void setList(List<TaiSan> list) {
		this.list = list;
	}
	public LoaiTaiSan(String loaitaisan) {
		super();
		this.loaitaisan = loaitaisan;
	}
	public LoaiTaiSan() {
		super();
	}
	@Override
	public String toString() {
		return "LoaiTaiSan [getLoaitaisanid()=" + getLoaitaisanid() + ", getLoaitaisan()=" + getLoaitaisan() + "]";
	}
	public void showinfoloaits() {
		System.out.println("Loaitaisanid : " + getLoaitaisanid() + " || Loaitaisan : " + getLoaitaisan() );
	}
}
