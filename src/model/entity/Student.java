package model.entity;

import model.enums.CourseYear;

public class Student extends Person{


    private String speciality;
    private Integer gpo;
    private CourseYear year;

    public Student(Integer id, String fullName, Integer age, String speciality, Integer gpo, CourseYear year) {
        super(id, fullName, age);
        this.speciality = speciality;
        this.gpo = gpo;
        this.year = year;
    }

    public Student(String speciality, Integer gpo, CourseYear year) {
        this.speciality = speciality;
        this.gpo = gpo;
        this.year = year;
    }



    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getGpo() {
        return gpo;
    }

    public void setGpo(Integer gpo) {
        this.gpo = gpo;
    }

    public CourseYear getYear() {
        return year;
    }

    public void setYear(CourseYear year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "speciality='" + speciality + '\'' +
                ", gpo=" + gpo +
                ", year=" + year +
                "} " + "\n";
    }

}
