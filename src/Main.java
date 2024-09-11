import model.entity.Teacher;
import model.enums.Position;
import serviceImpl.TeacherServiceImpl;

public class Main {
    public static void main(String[] args) {
        TeacherServiceImpl t=new TeacherServiceImpl();

        t.add(new Teacher(6,"Adem",28,690, Position.DEKAN));

        System.out.println(t.getAll());
    }
}