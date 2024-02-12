package main.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList {
    private ArrayList<Student> danhSach;

    public StudentList() {
        this.danhSach = new ArrayList<Student>();
    }

    // 1. Thêm sinh viên vào danh sách.
    public void themSinhVien(Student sv) {
        this.danhSach.add(sv);
    }

    // 2. In danh sách sinh viên ra màn hình.
    public void inDanhSachSinhVien() {
        for (Student sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }

    // 3. Kiểm tra danh sách có rỗng hay không.
    public boolean kiemTraDanhSachRong() {
        return this.danhSach.isEmpty();
    }

    // 4. Lấy ra số lượng sinh viên trong danh sách.
    public int laySoLuongSinhVien() {
        return this.danhSach.size();
    }

    // 5. Làm rỗng danh sách sinh viên.
    public void lamRongDanhSach() {
        this.danhSach.removeAll(danhSach);
    }

    // 6. Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh
    // viên.
    public boolean kiemTraTonTai(Student sv) {
        return this.danhSach.contains(sv);
    }

    // 7. Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.
    public boolean xoaSinhVien(Student sv) {
        return this.danhSach.remove(sv);
    }

    // 8. Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.
    public void timSinhVien(String ten) {
        for (Student sinhVien : danhSach) {
            if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
                System.out.println(sinhVien);
            }
        }
    }

    // 9. Xuất ra danh sách sinh viên có điểm từ cao đến thấp.
    public void sapXepSinhVienGiamDanTheoDiem() {
        Collections.sort(this.danhSach, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                if (sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh()) {
                    return -1;
                } else if (sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
