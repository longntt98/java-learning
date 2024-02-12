package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.StudentModel;
import database.DBConnection;

public class StudentDaoImp implements StudentDao {
    Connection cnt = null;
    PreparedStatement stm = null;
    ResultSet res = null;

    public void close() {
        try {
            if (cnt != null) {
                cnt.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (res != null) {
                res.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override
    public void add(StudentModel student) {
        try {
            StringBuilder sql = new StringBuilder("INSERT INTO student ");
            sql.append("(full_name, address, age) ");
            sql.append("VALUES (?, ?, ?)");
            cnt = DBConnection.getConnection();
            stm = cnt.prepareStatement(sql.toString());
            stm.setString(1, student.getFullName());
            stm.setString(2, student.getAddress());
            stm.setInt(3, student.getAge());
            System.out.println(sql + " /// " + stm);
            stm.executeUpdate();
            System.out.println("add done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void update(StudentModel student) {
        try {
            StringBuilder sql = new StringBuilder("UPDATE student ");
            sql.append("SET full_name = ?, address = ?, age = ? ");
            sql.append("WHERE id = ?");
            cnt = DBConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql.toString());
            stm.setString(1, student.getFullName());
            stm.setString(2, student.getAddress());
            stm.setInt(3, student.getAge());
            stm.setInt(4, student.getId());
            System.out.println(sql + " /// " + stm);
            stm.executeUpdate();
            cnt.commit();

        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                cnt.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            close();
        }
    }

    @Override
    public boolean CheckNumeric(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.chars().allMatch(Character::isDigit);
    }


    @Override
    public List<StudentModel> findAll() {
        List<StudentModel> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            cnt = DBConnection.getConnection();
            stm = cnt.prepareStatement(sql);
            res = stm.executeQuery();
            while (res.next()) {
                Integer id = res.getInt("id");
                String fullName = res.getString("full_name");
                String address = res.getString("address");
                Integer age = res.getInt("age");
                StudentModel s = new StudentModel(id, fullName, address, age);
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
        } finally {
            close();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            cnt = DBConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            cnt.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                cnt.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            close();
        }
    }
}
