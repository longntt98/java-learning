package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.StudentDaoImp;
import model.StudentModel;

public class StudentServices {

    public static void add() {
        System.out.println("run");
        Map<String, String> map = new HashMap<>();

        map.put("full_name", "abc");
        map.put("address", "address1");
        map.put("age", "123");

        String fullname = map.get("full_name");
        String address = map.get("address");
        String age = map.get("age");

        StudentDaoImp studenDaoImp = new StudentDaoImp();
        if (studenDaoImp.CheckNumeric(age)) {
            StudentModel student = new StudentModel(fullname, address, Integer.parseInt(age));
            studenDaoImp.add(student);
        }
    }

    public static void update() {
        String id = "2";
        String fullname = "name" + Math.random();
        String address = "address" + Math.random();
        String age = 1 + (int) (Math.random() * ((100 - 1) + 1)) + "";
        StudentDaoImp studenDaoImp = new StudentDaoImp();

        if (studenDaoImp.CheckNumeric(age)) {
            Integer i = Integer.parseInt(id);
            Integer a = Integer.parseInt(age);
            StudentModel student = new StudentModel(i, fullname, address, a);
            studenDaoImp.update(student);
        }
    }

    public static void findAll(String[] args) {
        StudentDaoImp studenDaoImp = new StudentDaoImp();
        List<StudentModel> list = studenDaoImp.findAll();
        System.out.println("abc");
        System.out.println(list.get(0).getFullName() + list.get(1).getFullName());

    }

    public static void main(String[] args) {
        StudentDaoImp studenDaoImp = new StudentDaoImp();
        Integer id = 1;
        studenDaoImp.delete(id);
    }
}