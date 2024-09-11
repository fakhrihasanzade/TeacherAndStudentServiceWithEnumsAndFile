package model.entity;

import model.enums.Position;

public class Teacher extends Person{


    private Integer salary;
    private Position status;

    public Teacher(Integer id, String fullName, Integer age, Integer salary, Position status) {
        super(id, fullName, age);
        this.salary = salary;
        this.status = status;
    }

//    public Teacher(Integer salary, Position status) {
//        this.salary = salary;
//        this.status = status;
//    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Position getStatus() {
        return status;
    }

    public void setStatus(Position status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "salary=" + salary +
                ", status=" + status +
                "} " + "\n";
    }


}
