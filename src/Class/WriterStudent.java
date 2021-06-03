package Class;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterStudent {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String TITLE= "Mã sinh viên,Email,Ngày sinh,Tên,Giới tính,Địa chỉ,Điểm trung bình";
    public void writerStudent(String path, List<Student> list)  {
        FileWriter writer = null;
        try{
            writer = new FileWriter(path);
            writer.write(TITLE);
            writer.append(NEW_LINE_SEPARATOR);
            for (Student student : list) {
                writer.append(student.getMsv());
                writer.append(COMMA_DELIMITER);
                writer.append(student.getEmail());
                writer.append(COMMA_DELIMITER);
                writer.append(student.getNgaySinh());
                writer.append(COMMA_DELIMITER);
                writer.append(student.getTen());
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(student.getGioiTinh()));
                writer.append(COMMA_DELIMITER);
                writer.append(student.getDiaChi());
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(student.getDiemTrungBinh()));
                writer.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Finish!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error fileCSV");
                e.printStackTrace();
            }
        }
    }
}
