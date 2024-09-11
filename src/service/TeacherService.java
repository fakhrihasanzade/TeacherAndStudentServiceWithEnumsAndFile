package service;

import model.entity.Teacher;
import model.enums.Position;

import java.util.List;

public interface TeacherService {

    List<Teacher> getByPosition(Position pn);

}
