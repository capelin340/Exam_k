package bean;

import java.io.Serializable;

public class Student implements Serializable {
    private String no; // 学生番号
    private String name; // 氏名
    private int entYear; // 入学年度
    private String classNum; // クラス番号
    private boolean isAttend; // 在籍フラグ
    private School school; // beanで学校名と学校コード

    // noのセッタ、ゲッタ
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // nameのセッタ、ゲッタ
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // entYearのセッタ、ゲッタ
    public int getEntYear() {
        return entYear;
    }

    public void setEntYear(int entYear) {
        this.entYear = entYear;
    }

    // classNumのセッタ、ゲッタ
    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    // isAttendのセッタ、ゲッタ (isで表現)
    public boolean isAttend() {
        return isAttend;
    }

    public void setAttend(boolean isAttend) {
        this.isAttend = isAttend;
    }

    // schoolのセッタ、ゲッタ
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    // 用途不明
    public int getSchoolYear() {
        return 0;
    }
}
