package fa.trainer.Hibernate_Final;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.dao.QlDao;
import fa.training.entities.LoaiTaiSan;
import fa.training.entities.NhanVien;
import fa.training.entities.NhanVienTaiSan;
import fa.training.entities.PhongBan;
import fa.training.entities.TaiSan;

public class App {
	public static void main(String[] args) {
		QlDao qldao = new QlDao();
		LoaiTaiSan loai1 = new LoaiTaiSan("TB CNTT");
		LoaiTaiSan loai2 = new LoaiTaiSan("TB VanPhong");
		LoaiTaiSan loai3 = new LoaiTaiSan("TB NoiThat");
		List<LoaiTaiSan> listloai = new ArrayList<LoaiTaiSan>();
		listloai.add(loai3);
		listloai.add(loai2);
		listloai.add(loai1);

		PhongBan phong1 = new PhongBan("Phong KeToan");
		PhongBan phong2 = new PhongBan("Phong HanhChinh");
		PhongBan phong3 = new PhongBan("Phong PhatTrien");
		List<PhongBan> listphong = new ArrayList<PhongBan>();
		listphong.add(phong3);
		listphong.add(phong2);
		listphong.add(phong1);

		TaiSan ts1 = new TaiSan("Model Wifi", loai1, "San Sang");
		TaiSan ts2 = new TaiSan("LapTop", loai1, "Khong San Sang");

		TaiSan ts3 = new TaiSan("May Fax", loai2, "Khong San Sang");
		TaiSan ts4 = new TaiSan("May In", loai2, "San Sang");

		TaiSan ts5 = new TaiSan("Ban", loai3, "San Sang");
		TaiSan ts6 = new TaiSan("Ghe", loai3, "Khong San Sang");
		List<TaiSan> listtaisan = new ArrayList<TaiSan>();
		listtaisan.add(ts1);
		listtaisan.add(ts2);
		listtaisan.add(ts3);
		listtaisan.add(ts4);
		listtaisan.add(ts5);
		listtaisan.add(ts6);

		NhanVien nv1 = new NhanVien("Duong", phong1);
		NhanVien nv2 = new NhanVien("Dung", phong1);
		NhanVien nv3 = new NhanVien("Hoang", phong2);
		NhanVien nv4 = new NhanVien("Xinh", phong2);
		NhanVien nv5 = new NhanVien("Manh", phong3);
		NhanVien nv6 = new NhanVien("Huy", phong3);
		List<NhanVien> listnv = new ArrayList<NhanVien>();
		listnv.add(nv6);
		listnv.add(nv5);
		listnv.add(nv4);
		listnv.add(nv3);
		listnv.add(nv2);
		listnv.add(nv1);

		NhanVienTaiSan nvts1 = new NhanVienTaiSan(nv6, ts6, LocalDate.of(2024, 04, 06));
		NhanVienTaiSan nvts2 = new NhanVienTaiSan(nv6, ts5, LocalDate.of(2024, 04, 06));
		NhanVienTaiSan nvts3 = new NhanVienTaiSan(nv4, ts4, LocalDate.of(2024, 04, 06));
		NhanVienTaiSan nvts4 = new NhanVienTaiSan(nv4, ts3, LocalDate.of(2024, 04, 06));
		List<NhanVienTaiSan> listnvts = new ArrayList<NhanVienTaiSan>();
		listnvts.add(nvts4);
		listnvts.add(nvts3);
		listnvts.add(nvts2);
		listnvts.add(nvts1);

		qldao.insertPhongBan(listphong);
		qldao.insertLoaiTaiSan(listloai);
		qldao.insertNhanVien(listnv);
		qldao.insertTaiSan(listtaisan);
		qldao.insertNhanVienTaiSan(listnvts);
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			System.out.println("=====================Menu=======================");
			System.out.println("1, Hiển Thị Các Loại Tài Sản Có Thể Mượn");
			System.out.println("2, Nhân Viên Mượn Thiết Bị");
			System.out.println("3, Hiển Thị Thiết Bị Chưa Được Trả");

			key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1: {
				qldao.showinfotaisan(qldao.findTaiSan());
				break;
			}case 2: {
				qldao.muontaisan(sc);
				break;
			}
			case 3: {
				qldao.showNhanVienTaiSan(sc);
				break;
			}
			default:
				break;
			}

		} while (true);

	}
}
