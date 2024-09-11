package serviceImpl;

import exception.MyException;
import model.entity.Student;
import model.entity.Teacher;
import model.enums.CourseYear;
import model.enums.Position;
import service.CommonService;
import service.StudentService;
import service.TeacherService;
import util.FileWrite;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements CommonService<Teacher>, TeacherService {

    static List<Teacher> teacherList = new ArrayList<>();

    static {
        teacherList.add(new Teacher(1, "Fexri Hesenzade", 26, 690, Position.TEACHER));
        teacherList.add(new Teacher(2, "Kenan Ibrahimli", 48, 1190, Position.TEACHER));
        teacherList.add(new Teacher(3, "Fuad Isgenderli", 65, 1690, Position.PROF));
        teacherList.add(new Teacher(4, "Resad Veliyev", 66, 1790, Position.TEACHER));
        teacherList.add(new Teacher(5, "Dursun Soltanov", 62, 1890, Position.DOSENT));
    }


    @Override
    public void add(Teacher object) {
        teacherList.add(object);
        String addedTeacher = object.getFullName() + " " + object.getAge() + "\n";
        FileWrite.writeFile("AddedTeacher.txt", addedTeacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherList;
    }

    @Override
    public Teacher getById(Integer id) {

        try {
            return teacherList.stream().filter(t -> t.getId().equals(id)).toList().get(0);
        } catch (Exception ex) {
            throw new MyException("Cagirilan muellim sistemde yoxdur");
        }
    }

    @Override
    public void updateById(Integer id, Teacher object) {

        String updatedTeacher = "";
        try {
            for (Teacher t : teacherList) {
                if (t.getId().equals(id)) {
                    t.setFullName(object.getFullName());
                    t.setAge(object.getAge());
                    t.setSalary(object.getSalary());
                    t.setStatus(object.getStatus());
                    updatedTeacher = t.getFullName() + " " + t.getAge() + "\n";
                }
            }
        } catch (Exception ex) {
            throw new MyException("Cagirilan muellim sistemde yoxdur");
        }
        FileWrite.writeFile("UpdatedTeacher.txt", updatedTeacher);
    }

    @Override
    public void deleteById(Integer id) {

        String deletedTeacher = "";
        try {
            for (Teacher t : teacherList) {
                if (t.getId().equals(id)) {
                    teacherList.remove(t);
                    deletedTeacher = t.getFullName() + " " + t.getAge() + "\n";
                }
            }
        } catch (Exception ex) {
            throw new MyException("Cagirilan muellim sistemde yoxdur");
        }

        FileWrite.writeFile("DeletedTeacher", deletedTeacher);

    }

    @Override
    public List<Teacher> getByPosition(Position pn) {

        try {
            return teacherList.stream().filter(t -> t.getStatus().equals(pn)).toList();
        } catch (Exception ex) {
            throw new MyException("Bele bir vezife sistemde yoxdur");
        }
    }
}
