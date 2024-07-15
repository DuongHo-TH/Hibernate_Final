package fa.training.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.trainer.Hibernate_Final.HibernateUtils;
import fa.training.entities.LoaiTaiSan;
import fa.training.entities.NhanVien;
import fa.training.entities.NhanVienTaiSan;
import fa.training.entities.PhongBan;
import fa.training.entities.TaiSan;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;




public class QlDao {

	public void insertPhongBan(List<PhongBan> mv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			for (PhongBan employee : mv) {
				sessi.persist(employee);
			}
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public void insertLoaiTaiSan(List<LoaiTaiSan> mv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			for (LoaiTaiSan employee : mv) {
				sessi.persist(employee);
			}
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public void insertTaiSan(List<TaiSan> mv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			for (TaiSan employee : mv) {
				sessi.persist(employee);
			}
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public void insertNhanVien(List<NhanVien> mv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			for (NhanVien employee : mv) {
				sessi.persist(employee);
			}
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public void insertNhanVienTaiSan(List<NhanVienTaiSan> mv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			for (NhanVienTaiSan employee : mv) {
				sessi.persist(employee);
			}
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public void insertNhanVienTaiSan(NhanVienTaiSan mv) {
		Transaction tran = null;
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			tran = sessi.beginTransaction();
			
				sessi.persist(mv);
			
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	
	public List<TaiSan> findTaiSan() {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<TaiSan> cr = cb.createQuery(TaiSan.class);
			Root<TaiSan> root = cr.from(TaiSan.class);
			cr.select(root);
			cr.where(cb.equal(root.get("trangthai"), "San Sang"));
			List<TaiSan> listcandi = sessi.createQuery(cr).getResultList();
			
			return listcandi;
//			for (TaiSan candidate : listcandi) {
//				candidate.showinfoTaisan();
//				
//			}
		
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public List<TaiSan> findLoaiTaiSan() {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			CriteriaBuilder cb = sessi.getCriteriaBuilder();
			CriteriaQuery<TaiSan> cr = cb.createQuery(TaiSan.class);
			Root<TaiSan> root = cr.from(TaiSan.class);
			cr.select(root);
			Join<TaiSan,LoaiTaiSan> interJoin = root.join("loaitaisanid", JoinType.INNER);
			cr.where(cb.notEqual(interJoin.get("loaitaisan"), "TB CNTT"),cb.equal(root.get("trangthai"), "San Sang"));
			 List<TaiSan> listts = sessi.createQuery(cr).getResultList();
			 
			return listts;
//			for (TaiSan candidate : listcandi) {
//				candidate.showinfoTaisan();
//				
//			}
		
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
	}
	public NhanVien findNhanVien(int id) {
		Session sessi = null;
		try {
			sessi = HibernateUtils.getSession().openSession();
			NhanVien Candidate = sessi.find(NhanVien.class, id);
			return Candidate;
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
		
	}
	public void updateTaisan(int id) {
		Session sessi = null;
		Transaction tran = null;
		
		try {
			sessi = HibernateUtils.getSession().openSession();
			TaiSan Candidate = sessi.find(TaiSan.class, id);
			Candidate.setTrangthai("Khong San Sang");
			sessi.merge(Candidate);
			tran = sessi.beginTransaction();
			tran.commit();
		} finally {
			if (sessi != null) {
				sessi.close();
			}
		}
		
	}
	public void muontaisan(Scanner sc) {
		System.out.println("Nhập ID Nhân Viên");
		int idnv = Integer.parseInt(sc.nextLine());
		 NhanVien nv =  findNhanVien(idnv);
		if(nv.getPhongban().getTenphongban().equals("Phong PhatTrien")) {
			List<TaiSan> listtsss = findTaiSan();
			if(listtsss.isEmpty()) {
			System.out.println("Hiện Tại Không Có Tài Sản Nào Có Thể Mượn");
			}else {
				for (TaiSan element : listtsss) {
					element.showinfoTaisan();
				}
				System.out.println("Nhập Tài Sản Cần Mượn");
				int i = Integer.parseInt(sc.nextLine());
				TaiSan ts = listtsss.get(i-1);
				NhanVienTaiSan nvts = new NhanVienTaiSan(nv, ts, LocalDate.now());
				insertNhanVienTaiSan(nvts);
				updateTaisan(ts.getTaisanid());
				
			}
		}else {
			List<TaiSan> listtsss = findLoaiTaiSan();
			if(listtsss.isEmpty()) {
				System.out.println("Hiện Tại Không Có Tài Sản Nào Có Thể Mượn");
				}else {
					for (TaiSan element : listtsss) {
						element.showinfoTaisan();
					}
					System.out.println("Nhập Tài Sản Cần Mượn");
					int i = Integer.parseInt(sc.nextLine());
					TaiSan ts = listtsss.get(i-1);
					NhanVienTaiSan nvts = new NhanVienTaiSan(nv, ts, LocalDate.now());
					insertNhanVienTaiSan(nvts);
					updateTaisan(ts.getTaisanid());
					
				}
		}
	}
	public void showNhanVienTaiSan(Scanner sc) {
	Session sessi = null;
	Transaction tran = null;
	try {
		 sessi = HibernateUtils.getSession().openSession();
		CriteriaBuilder cb = sessi.getCriteriaBuilder();
		CriteriaQuery<NhanVienTaiSan> cr = cb.createQuery(NhanVienTaiSan.class);
		Root<NhanVienTaiSan> root = cr.from(NhanVienTaiSan.class);
		cr.select(root);
		cr.where(cb.isNull(root.get("ngaytra") ));
		 List<NhanVienTaiSan> listloai = sessi.createQuery(cr).getResultList();
		 for (NhanVienTaiSan taiSan : listloai) {
			 taiSan.showinfornvts();
		}   
			System.out.println("Chọn Thiết Bị Cần Trả");
			int i = Integer.parseInt(sc.nextLine());
			NhanVienTaiSan thietbi = listloai.get(i-1);
			TaiSan tsid = thietbi.getTaisanid();
			System.out.println("Nhập Ngày Trả Thiết Bị");
//			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			thietbi.setNgaytra(LocalDate.now());
			tsid.setTrangthai("San Sang");
			sessi.merge(thietbi);
			sessi.merge(tsid);
			tran = sessi.beginTransaction();
			tran.commit();
	
	} finally {
		if (sessi != null) {
			sessi.close();
		}
	}
	}
	public void showinfotaisan(List<TaiSan> as){
		for (TaiSan taiSan : as) {
			taiSan.showinfoTaisan();
			taiSan.getLoaitaisanid().showinfoloaits();
		}
	}
}
