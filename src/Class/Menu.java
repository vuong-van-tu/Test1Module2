package Class;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ManagerStudent ms = new ManagerStudent();
    ReaderStudent rs = new ReaderStudent();

    public void case1() {
        ms.addStudent(themStudent());
    }

    public void case2() {
        if (ms.getStudents()==null){
            System.out.println("Danh sách rỗng");
        }else {
            ms.printStudent(ms.getStudents());
        }
    }

    public void case3() {
        System.out.println("Nhập msv :");
        String msv = sc.nextLine();
        if (ms.findByMsv(msv)!=null){
            ms.editStudent(msv, themStudent());
        }else {
            System.out.println("Mã sinh viên không tồn tại" );
        }
    }

    public void case4() {
        System.out.println("Nhập msv :");
        String msv = sc.nextLine();
        System.out.println("Bạn có chắc chắn xóa ?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                ms.deleteStudent(msv);
                break;
            case 2:
                ms.printStudent(ms.getStudents());
                break;
        }
    }

    public void case5() {
        System.out.println("Tìm kiếm theo :");
        System.out.println("1. Tìm theo mã sinh viên");
        System.out.println("2. Tìm theo tên");
        System.out.println("3. Tìm theo khoảng tuổi");
        System.out.println("4. Tìm theo khoảng điểm");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Nhập msv :");
                String msv = sc.nextLine();
                ms.printStudent(ms.findByMsv(msv));
                break;
            case 2:
                System.out.println("Nhập tên :");
                String name = sc.nextLine();
                ms.printStudent(ms.findByName(name));
                break;
            case 3:
                System.out.println("Nhập firstAge:");
                int firstAge = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập lastAge:");
                int lastAge = sc.nextInt();
                sc.nextLine();
                ms.printStudent(ms.findByAge(firstAge, lastAge));
                break;
            case 4:
                System.out.println("Nhập firstPoint:");
                int firstPoint = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập lastPoint:");
                int lastPoint = sc.nextInt();
                sc.nextLine();
                ms.printStudent(ms.findByPoint(firstPoint, lastPoint));
                break;
        }
    }

    public void case6() {
        System.out.println("Sắp xếp");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo điểm trung bình");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                ms.sortByPoint();
                ms.printStudent(ms.getStudents());
                break;
            case 2:
                ms.sortByName();
                ms.printStudent(ms.getStudents());
                break;
        }
    }

    public void case7() {
        ms.printFile();
    }

    public void case8() {
        ms.printStudent(rs.readerStudent("src/writerfile.csv"));
    }

    public static Student themStudent() {
        Scanner sc = new Scanner(System.in);
        ManagerStudent ms = new ManagerStudent();
        System.out.println("Nhập học sinh ");
        String mav = null;
        do {

                do {
                    System.out.print("Nhập mã sinh viên (Cxxxx[G|H|I|K]xx) : ");
                    mav = sc.nextLine();
                    if (ms.findByMsv(mav)==null) {
                        if (!RegexStudent.validateID(mav)) {
                            System.out.println("Sai cú pháp yêu cầu nhập lại");
                        }
                    }else {
                        System.out.println("Mã sinh viên đã tồn tại yêu cầu nhập lại");
                    }
                } while (!RegexStudent.validateID(mav));
        }while(ms.findByMsv(mav)!=null);
        String email;
        do {
            System.out.print("Nhập Email (ten.ho@codegym.vn): ");
            email = sc.nextLine();
            if (!RegexStudent.validateEmail(email)){
                System.out.println("Sai cú pháp yêu cầu nhập lại");
            }
        } while (!RegexStudent.validateEmail(email));
        String dateOfBirth;
        do {
            System.out.print("Nhập ngày sinh(dd/mm/yyyy):");
            dateOfBirth = sc.nextLine();
            if (!RegexStudent.validateDate(dateOfBirth)){
                System.out.println("Sai cú pháp yêu cầu nhập lại");
            }
        } while (!RegexStudent.validateDate(dateOfBirth));
        System.out.print("Nhập tên:");
        String name = sc.nextLine();
        System.out.print("Nhập giới tính:");
        int gender = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = sc.nextLine();
        System.out.print("Nhập điểm trung bình :");
        double avg = sc.nextDouble();
        sc.nextLine();
        return new Student(mav, email, dateOfBirth, name, gender, address, avg);
    }
}
