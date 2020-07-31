import java.util.ArrayList;

/*
 * Mục đích: Quản lý toàn bộ nghiệp vụ cho Trường học
 * Người tạo: CyberLearn
 * Ngày tạo: 20/4/2020
 * Version: 1.0
 * */
public class TruongHoc {

	// 1. Attributes
	private DanhSachSinhVien dssvToanTruong;
	// 2. Get, set methods

	/**
	 * @return the dssvToanTruong
	 */
	public DanhSachSinhVien getDssvToanTruong() {
		return dssvToanTruong;
	}

	/**
	 * @param dssvToanTruong the dssvToanTruong to set
	 */
	public void setDssvToanTruong(DanhSachSinhVien dssvToanTruong) {
		this.dssvToanTruong = dssvToanTruong;
	}

	// 3. Constructors
	public TruongHoc() {
		this.dssvToanTruong = new DanhSachSinhVien();
	}

	// 4. Input, output
	public void nhap() {
		SinhVien sv = new SinhVien("Lan", 1, 9.2f, 9, 9);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Hùng", 2, 4.2f, 4, 5.3f);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Lan", 3, 7.2f, 4, 9);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Yến", 4, 3.2f, 4, 4);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Toàn", 5, 9.2f, 10, 10);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Hữu", 6, 7.2f, 7, 6);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Lý", 7, 3.2f, 3, 3);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Trung", 8, 9.2f, 10, 10);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Quyền", 9, 7.2f, 7, 8);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Linh", 10, 5.2f, 5, 6);
		this.dssvToanTruong.themSinhVien(sv);

	}

	public void xuat() {
		this.dssvToanTruong.xuat();

	}

	// 5. Business methods
	public void themSinhVien(SinhVien sv) {
		this.dssvToanTruong.themSinhVien(sv);
	}

	public void tinhDTB() {
		this.dssvToanTruong.tinhDTB();
	}

	public void xepLoai() {
		this.dssvToanTruong.xepLoai();
	}

	public ArrayList<SinhVien> timDSSVCoDTBCaoNhat() {
		return this.dssvToanTruong.timDSSVCoDTBCaoNhatToiUu();
	}

	public ArrayList<SinhVien> lietKeDSSVYeu() {
		return this.dssvToanTruong.lietKeDSSVYeu();
	}

	public void xuatHelper(ArrayList<SinhVien> list) {

		for (SinhVien sv : list) {
			sv.xuat();

		}
	}

	public ArrayList<SinhVien> timSVTheoTen(String tenSV) {
//		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
//		for(SinhVien sv: dssvToanTruong.getListSV()) {
//			if(sv.getTenSV().equalsIgnoreCase(tenSV)) {
//				list.add(sv);
//			}
//		}
//		return list;
		return dssvToanTruong.timSVTheoTen(tenSV);
	}

	public SinhVien timSVTheoMa(int ma) {
		return dssvToanTruong.timSVTheoMa(ma);
	}

	public boolean xoaSVTheoMa(int ma) {
		return dssvToanTruong.xoaSVTheoMa(ma);
	}

	private void xuatLine() {
		System.out.println(
				"===================================================================================================================");
	}

	private String formatCell(String paddLeft, String title, String paddRight) {
		return String.format(paddLeft, " ") + title + String.format(paddRight, " ");
	}

	private void xuatRowHeader() {
		String paddString1 = "%3s";
		String paddString2 = "%4s";
		String paddString3 = "%5s";
		String paddString4 = "%6s";

		xuatLine();
		String text;
		text = "||" + formatCell(paddString1, "STT", paddString1) + "|";
		text += formatCell(paddString2, "Mã SV", paddString2)+ "|";
		text += formatCell(paddString3, "Tên SV", paddString2)+ "|";
		text += formatCell(paddString3, "Toán", paddString2)+ "|";
		text += formatCell(paddString3, "Lý", paddString4)+ "|";
		text += formatCell(paddString3, "Hóa", paddString3)+ "|";
		text += formatCell(paddString3, "ĐTB", paddString3)+ "|";
		text += formatCell(paddString2, "Xếp Loại", paddString1) + "||";
		System.out.println(text);
		xuatLine();

	}

	private void xuatCellThuTu(int i) {
		String paddLeft = "%3s";
		String paddRight = "%-6s";
		String text = "||" + String.format(paddLeft, " ") + String.format(paddRight, "" + i) + "|";
		System.out.print(text);
	}

	public void xuatTheoFormat(ArrayList<SinhVien> list) {
		xuatRowHeader();
		int i = 1;
		for (SinhVien sv : list) {
			xuatCellThuTu(i);
			sv.xuatRowFormat();
			i++;
		}
		xuatLine();
	}

}
