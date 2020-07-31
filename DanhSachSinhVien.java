import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Tạo ra để quản lý danh sách nhiều sinh viên
 * Người tạo: CyberLearn
 * Ngày tạo: 15/4/2020
 * Version: 1.0
 * */
public class DanhSachSinhVien {

	// 1. Attributes / Data members/ Fields
	private ArrayList<SinhVien> listSV;// = new ArrayList<SinhVien>();
	// 2. Get, set methods

	/**
	 * @return the listSV
	 */
	public ArrayList<SinhVien> getListSV() {
		return listSV;
	}

	/**
	 * @param listSV the listSV to set
	 */
	public void setListSV(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}

	// 3. Constructors method
	public DanhSachSinhVien() {
		thietLapDefault();
	}

	// Hàm này dùng để khởi động các list và các giá trị mặc định cho lớp
	private void thietLapDefault() {
		this.listSV = new ArrayList<SinhVien>();

	}

	// 4. Input, output methods
	public void nhap(Scanner scan) {
		for (SinhVien sv : this.listSV) {
			sv.nhap(scan);
		}
	}

	public void themSinhVien(SinhVien sv) {
		this.listSV.add(sv);
	}

	public void xuat() {
		for (SinhVien sv : this.listSV) {
			sv.xuat();
		}
	}

	// 5. Business methods
	public void tinhDTB() {
		for (SinhVien sv : this.listSV) {
			sv.tinhDTB();
		}
	}

	public void xepLoai() {
		for (SinhVien sv : this.listSV) {
			sv.xepLoai();
		}
	}

	public ArrayList<SinhVien> timDSSVCoDTBCaoNhat() {
		/*
		 * Bước 1: Tạo biến svMax và gán sinh viên đầu tiên trong danh sách giả định là
		 * sinh viên có ĐTB cao nhất cho svMax Bước 2: Duyệt danh sách sinh viên Bước 3:
		 * So sánh ĐTB của sinh viên đang duyệt (svCurrent) với svMax, nếu
		 * svCurrent.getDTB > svMax.getDTB Bước 4: Gán lại svMax = svCurrent Bước 5: Tìm
		 * thấy được sinh viên có ĐTB lớn nhất thật sự trong danh sách // Duyệt lại danh
		 * sách và tìm tất cả SV có ĐTB bằng với ĐTB của svMax và cho vào danh sách trả
		 * về Bước 6: Duyệt lại danh sách Bước 7: So sánh svCurrent với svMax, nếu
		 * svCurrent.getDTB == svMax.getDTB Bước 8: Thêm vào danh sách trả về Bước 9:
		 * Trả về danh sách sinh viên có ĐTB cao nhất
		 * 
		 */
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		if (this.listSV.size() > 0) {
			SinhVien svMax = this.listSV.get(0); //
			for (SinhVien svCurrent : this.listSV) {
				if (svCurrent.getDiemTB() > svMax.getDiemTB()) {
					svMax = svCurrent;
				}
			}

			// Đã tìm thấy svmax
			for (SinhVien svCurrent : this.listSV) {
				if (svCurrent.getDiemTB() == svMax.getDiemTB()) {
					list.add(svCurrent);
				}
			}
		}

		return list;

	}
	
	public ArrayList<SinhVien> timDSSVCoDTBCaoNhatToiUu() {
		/*
		 * Bước 1: Tạo biến svMax và gán sinh viên đầu tiên trong danh sách giả định là
		 * sinh viên có ĐTB cao nhất cho svMax Bước 2: Duyệt danh sách sinh viên Bước 3:
		 * So sánh ĐTB của sinh viên đang duyệt (svCurrent) với svMax, nếu
		 * svCurrent.getDTB > svMax.getDTB Bước 4: Gán lại svMax = svCurrent Bước 5: Tìm
		 * thấy được sinh viên có ĐTB lớn nhất thật sự trong danh sách // Duyệt lại danh
		 * sách và tìm tất cả SV có ĐTB bằng với ĐTB của svMax và cho vào danh sách trả
		 * về Bước 6: Duyệt lại danh sách Bước 7: So sánh svCurrent với svMax, nếu
		 * svCurrent.getDTB == svMax.getDTB Bước 8: Thêm vào danh sách trả về Bước 9:
		 * Trả về danh sách sinh viên có ĐTB cao nhất
		 * 
		 */
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		if (this.listSV.size() > 0) {
			SinhVien svMax = this.listSV.get(0); //
			int viTriMaxDauTien = 0;
			for (int i = 0; i < this.listSV.size(); i++) {
				SinhVien svCurrent = this.listSV.get(i);
				if (svCurrent.getDiemTB() > svMax.getDiemTB()) {
					svMax = svCurrent;
					viTriMaxDauTien = i;
				}
			}
			//Thêm svMax vào list
			list.add(svMax);
			// Đã tìm thấy svmax
			for (int i = viTriMaxDauTien +1 ; i< this.listSV.size(); i++) {
				SinhVien svCurrent = this.listSV.get(i);
				if (svCurrent.getDiemTB() == svMax.getDiemTB()) {
					list.add(svCurrent);
				}
			}
		}
		return list;
	}

	/*
	 * */
	public ArrayList<SinhVien> lietKeDSSVYeu(){
		ArrayList<SinhVien> listYeu = new ArrayList<SinhVien>();
		for(SinhVien sv: this.listSV) {
			if(sv.getDiemTB() <5) {
				listYeu.add(sv);
			}
		}
		return listYeu;
	}
	
	public ArrayList<SinhVien> timSVTheoTen(String ten){
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		for(SinhVien sv: this.listSV) {
			if(sv.getTenSV().equalsIgnoreCase(ten)) {
				list.add(sv);
			}
		}
		return list;
	}
	
	public SinhVien timSVTheoMa(int ma) {
		SinhVien sv = null; // chua tim thay
		for(SinhVien sv1 : this.listSV) {
			if(sv1.getMaSV() == ma) {
				sv = sv1; //Da tim thay 
				break; // thoat khoi vong lap
			}
		}
		return sv;
	}
	
	public boolean xoaSVTheoMa(int ma) {
		boolean deleted = false; //chua xoa
		for(SinhVien sv: this.listSV) {
			if(sv.getMaSV() == ma) {
				this.listSV.remove(sv);
				deleted = true; //xoa thanh cong
				break;
				
			}
		}
		return deleted;
	}
}
