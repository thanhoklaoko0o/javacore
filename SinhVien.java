import java.util.Scanner;

/*
 * Mục đích: Quản lý các nghiệp vụ liên quan đến Sinh vien
 * Người tạo: CyberSoft
 * Ngày tạo: 14/04/2020
 * Version: 1.0
 * */
public class SinhVien {

	// 1. Thuộc tính
	private String tenSV;
	private int maSV;
	private float diemToan;
	private float diemHoa;
	private float diemLy;
	private float diemTB;
	private String xepLoai;
	// 2. Get, set methods

	/**
	 * @return the tenSV
	 */
	public String getTenSV() {
		return tenSV;
	}

	/**
	 * @param tenSV the tenSV to set
	 */
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	/**
	 * @return the maSV
	 */
	public int getMaSV() {
		return maSV;
	}

	/**
	 * @param maSV the maSV to set
	 */
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	/**
	 * @return the diemToan
	 */
	public float getDiemToan() {
		return diemToan;
	}

	/**
	 * @param diemToan the diemToan to set
	 */
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	/**
	 * @return the diemHoa
	 */
	public float getDiemHoa() {
		return diemHoa;
	}

	/**
	 * @param diemHoa the diemHoa to set
	 */
	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	/**
	 * @return the diemLy
	 */
	public float getDiemLy() {
		return diemLy;
	}

	/**
	 * @param diemLy the diemLy to set
	 */
	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	/**
	 * @return the diemTB
	 */
	public float getDiemTB() {
		return diemTB;
	}

	/**
	 * @return the xepLoai
	 */
	public String getXepLoai() {
		return xepLoai;
	}

	// 3. Constructors methods

	public SinhVien() {

	}

	/**
	 * @param tenSV
	 * @param maSV
	 * @param diemToan
	 * @param diemHoa
	 * @param diemLy
	 */
	public SinhVien(String tenSV, int maSV, float diemToan, float diemHoa, float diemLy) {
		this.tenSV = tenSV;
		this.maSV = maSV;
		this.diemToan = diemToan;
		this.diemHoa = diemHoa;
		this.diemLy = diemLy;
	}

	// 4. Input, output methods
	public void nhap(Scanner scan) {
		System.out.print("Nhập tên: ");
		this.tenSV = scan.nextLine();

		System.out.print("Nhập mã: ");
		this.maSV = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập điểm toán: ");
		this.diemToan = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập điểm lý: ");
		this.diemLy = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập điểm hóa: ");
		this.diemHoa = Float.parseFloat(scan.nextLine());
	}

	public void xuat() {
		System.out.println("Sinh vien - Mã: " + this.maSV + "\t Tên: " + this.tenSV + "\t Toán: " + this.diemToan
				+ "\t Lý: " + this.diemLy + "\t Hóa: " + this.diemHoa + "\t ĐTB: " + this.diemTB + "\t Xếp loại:"
				+ this.xepLoai);
	}

	// 5. Business methods
	public void tinhDTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa) / 3;
	}

	public void xepLoai() {
		if (this.diemTB >= 9) {
			this.xepLoai = "Xuất Sắc";
		} else if (this.diemTB >= 8) {
			this.xepLoai = "Giỏi";
		} else if (this.diemTB >= 7) {
			this.xepLoai = " Khá";
		} else if (this.diemTB >= 6) {
			this.xepLoai = "TB-Khá";
		} else if (this.diemTB >= 5) {
			this.xepLoai = "Trung bình";
		} else {
			this.xepLoai = "Yếu";
		}
	}

	private String formatNumCell(Number num) {
		String paddLeft = "%5s";
		String paddRight = "%-8s";
		return String.format(paddLeft, " ") + String.format(paddRight, num) + "|";
	}

	private String formatTextCell(String text) {
		String paddLeft = "%-15s";
		return String.format(paddLeft, " " + text);
	}

	public void xuatRowFormat() {
		String text;
		text = formatNumCell(this.maSV);
		text += formatTextCell(this.tenSV) + "|";
		text += formatNumCell(this.diemToan);
		text += formatNumCell(this.diemLy);
		text += formatNumCell(this.diemHoa);

		double dtb = Math.round(this.diemTB * 100.0) / 100.0; // lam tron den 2 chu so phan thap phan
		text += formatNumCell(dtb);
		text += formatTextCell(this.xepLoai) + "||";
		System.out.println(text);

	}

}
