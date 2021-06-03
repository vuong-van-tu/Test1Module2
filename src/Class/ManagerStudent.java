package Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManagerStudent {
    private List<Student> students = null;
    ReaderStudent rs = new ReaderStudent();
    WriterStudent ws = new WriterStudent();
    public ManagerStudent() {
        try {
            students = rs.readerStudent("src/writerfile.csv");
        }catch (Exception e){
            this.students = new ArrayList<Student>();
        }
    }
    public void printFile(){
        ws.writerStudent("src/writerfile.csv",getStudents());
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void printStudent(List<Student> list) {
        for (Student student : list){
            System.out.println(student);
        }
    }
    public int checkStudentIndex(String msv) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMsv().equals(msv)){
                return i;
            }
        }
        return -1;
    }
    public void deleteStudent(String msv) {
        int findIndex = checkStudentIndex(msv);
        if (findIndex==-1){
            System.out.println("Student not found");
        }else {
            students.remove(findIndex);
        }
    }
    public List<Student> findByName(String name){
        List<Student> listName = new ArrayList<Student>();
        int count = 0;
        for (Student student : students){
            if (student.getTen().equals(name)){
                listName.add(student);
                count++;
            }
        }
        if (count!=0){
            return listName;
        }else {
            return null;
        }
    }
    public List<Student> findByMsv(String msv){
        List<Student> listMsv = new ArrayList<Student>();
        int count = 0;
        for (Student student : students){
            if (student.getMsv().equals(msv)){
                listMsv.add(student);
                count++;
            }
        }
        if (count!=0){
            return listMsv;
        }else {
            return null;
        }
    }
    public List<Student> findByPoint(double firstPoint,double lastPoint){
        List<Student> listPoint = new ArrayList<Student>();
        int count = 0;
        for (Student student : students){
            if (student.getDiemTrungBinh()>=firstPoint&&student.getDiemTrungBinh()<=lastPoint){
                listPoint.add(student);
                count++;
            }
        }
        if (count!=0){
            return listPoint;
        }else {
            return null;
        }
    }
    public List<Student> findByAge(int firstAge,int lastAge){
        List<Student> listAge = new ArrayList<Student>();
        int count = 0;
        for (Student student : students){
            if (student.displayAge()>=firstAge&&student.displayAge()<=lastAge){
                listAge.add(student);
                count++;
            }
        }
        if (count!=0){
            return listAge;
        }else {
            return null;
        }
    }


    public void sortByPoint(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getDiemTrungBinh()- o2.getDiemTrungBinh());
            }
        });
        List<Student> sortByPoint = new ArrayList<Student>();
        for (Student student : students){
            sortByPoint.add(student);
        }
        students = sortByPoint;
    }
    public void sortByName(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getTen().compareTo(o2.getTen())==0){
                    return (int) (o1.getDiemTrungBinh()- o2.getDiemTrungBinh());
                }else {
                    return o1.getTen().compareTo(o2.getTen());
                }
            }
        });
        List<Student> sortByName = new ArrayList<Student>();
        for (Student student : students){
            sortByName.add(student);
        }
        students = sortByName;
    }
    public void editStudent(String msv,Student student){
        int index = students.indexOf(findByMsv(msv));
        for (Student st : students){
            if (findByMsv(msv).equals(st.getMsv())){
                students.set(index,student);
            }else {
                System.out.println("Không tìm thấy sinh viên");
            }
        }
    }

}
