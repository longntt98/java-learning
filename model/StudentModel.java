package model;

public class StudentModel {
    private Integer id;
    private String fullName;
    private String address;
    private Integer age;

    public StudentModel(Integer id, String fullName, String address, Integer age) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.age = age;
    }
    
    public StudentModel(String fullName, String address, Integer age) {
        this.fullName = fullName;
        this.address = address;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // public String getStudentId() {
    //     return studentId;
    // }

    // public void setStudentId(String studentId) {
    //     this.studentId = studentId;
    // }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Object[] toObject(){
        return new Object[]{id, fullName, address, age};
    }
}