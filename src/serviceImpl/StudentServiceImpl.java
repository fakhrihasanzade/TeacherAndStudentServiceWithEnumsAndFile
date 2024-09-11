package serviceImpl;

import exception.MyException;
import model.entity.Student;
import model.enums.CourseYear;
import service.CommonService;
import service.StudentService;
import util.FileWrite;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements CommonService<Student>, StudentService {

    static List<Student> stList = new ArrayList<>();

    static {
        stList.add(new Student(1, "Fexri Hesenzade", 26, "CS", 85, CourseYear.FOUR));
        stList.add(new Student(2, "Kamal Hesenli", 23, "CS", 66, CourseYear.TWO));
        stList.add(new Student(3, "Tural Orucov", 19, "Info", 85, CourseYear.FOUR));
        stList.add(new Student(4, "Xudayar Ibrahimov", 21, "Mexanika", 85, CourseYear.THREE));
        stList.add(new Student(5, "Sevinc Eliyeva", 36, "CS", 55, CourseYear.FOUR));
    }


    @Override
    public void add(Student object) {
        stList.add(object);
        String addedStudent=object.getFullName()+" "+object.getAge()+"\n";
        FileWrite.writeFile("AddedStudent.txt",addedStudent);
    }

    @Override
    public List<Student> getAll() {
        return stList;
    }

    @Override
    public Student getById(Integer id) {

        try {
            return stList.stream().filter(s -> s.getId().equals(id)).toList().get(0);
        } catch (Exception ex) {
            throw new MyException("Cagirilan telebe sistemde yoxdur");
        }
    }

    @Override
    public void updateById(Integer id, Student object) {
        try {
            for (Student t : stList) {
                if (t.getId().equals(id)) {
                    t.setFullName(object.getFullName());
                    t.setAge(object.getAge());
                    t.setSpeciality(object.getSpeciality());
                    t.setGpo(object.getGpo());
                    t.setYear(object.getYear());

                }
            }
        } catch (Exception ex) {
            throw new MyException("Cagirilan telebe sistemde yoxdur");
        }

        String updatedStudent=object.getFullName()+" "+object.getAge()+"\n";
        FileWrite.writeFile("UpdatedStudent.txt",updatedStudent);

    }

    @Override
    public void deleteById(Integer id) {
        String deletedStudent="";
        try{
            for (Student t : stList) {
                if (t.getId().equals(id)) {
                    stList.remove(t);
                    deletedStudent=t.getFullName()+" "+t.getAge()+"\n";
                }
            }
        }catch(Exception ex){
            throw new MyException("Cagirilan telebe sistemde yoxdur");
        }

        FileWrite.writeFile("DeletedStudent.txt",deletedStudent);

    }

    @Override
    public List<Student> getByCouseYear(CourseYear cy) {

        try {
            return stList.stream().filter(s -> s.getYear().equals(cy)).toList();
        }catch(Exception ex){
            throw new MyException("Bele bir kurs yoxdur!!");
        }
    }
}

