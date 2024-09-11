package service;

import model.entity.Student;
import model.enums.CourseYear;

import java.util.List;

public interface StudentService {

    List<Student> getByCouseYear(CourseYear cy);

}
