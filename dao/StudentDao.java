package dao;

import java.util.List;

import model.StudentModel;

public interface StudentDao {
    void add(StudentModel student);
    boolean CheckNumeric(String str);
    List<StudentModel> findAll();
    void delete(Integer id);
    void update(StudentModel student);
    // List<StudentDaoImp> search(String value);
}
