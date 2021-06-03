package Class;

import java.util.function.UnaryOperator;

public class Student {
    private String msv;
    private String email;
    private String ngaySinh;
    private String ten;
    private int gioiTinh;
    private String diaChi;
    private double diemTrungBinh;

    public Student(String msv, String email, String ngaySinh, String ten, int gioiTinh, String diaChi, double diemTrungBinh) {
        this.msv = msv;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diemTrungBinh = diemTrungBinh;
    }

    public Student() {
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
            this.msv = msv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
            this.ngaySinh = ngaySinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGioiTinh() {
      return gioiTinh;
    }
    public String gioiTinh() {
        if (gioiTinh==1){
            return "Nam";
        }else if (gioiTinh==2){
            return "Nữ";
        }else {
            return "Giới tính thứ 3";
        }
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public int displayAge() {
        String [] str = ngaySinh.split("/");
        int age = 2021-Integer.parseInt(str[2]);
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Mã sinh viên : " + msv +
                ", email : " + email +
                ", tuổi : " + displayAge() +
                ", tên : " + ten +
                ", giới tính : " + gioiTinh() +
                ", địa chỉ : " + diaChi +
                ", điểm trung bình : " + diemTrungBinh +
                '}';
    }

}
