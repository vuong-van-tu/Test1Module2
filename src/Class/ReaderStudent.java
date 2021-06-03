package Class;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderStudent {
    private static final String COMMA_DELIMITER = ",";
    public List readerStudent(String path){
        List<Student> newStudentList = new ArrayList<Student>();
        FileReader reader =null;
        BufferedReader br = null;
        try {
            reader = new FileReader(path);
            br = new BufferedReader(reader);
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                    String[] lines = line.split(COMMA_DELIMITER);
                    newStudentList.add(new Student(lines[0],lines[1],lines[2],lines[3],Integer.parseInt(lines[4]),lines[5],Double.parseDouble(lines[6])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newStudentList;
    }

}
