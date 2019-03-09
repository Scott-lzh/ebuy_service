package com.hhit.vo.user;

import java.util.Date;

public class User {
    private int id;//用户编码
    private String name;//用户姓名
    private String pwd;//用户密码
    private String sex;//用户性别
    private int age;//用户年龄
    private String tel;//用户电话
    private int type;//用户类型
    private int credit;//用户积分
    private Date birth;//用户生日
    private String address;//用户地址

    public User() {
    }

    public User(int id, String name, String pwd, String sex, int age, String tel, int type, int credit, Date birth, String address) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.type = type;
        this.credit = credit;
        this.birth = birth;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getTel() {
        return tel;
    }

    public int getType() {
        return type;
    }

    public int getCredit() {
        return credit;
    }

    public Date getBirth() {
        return birth;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", credit=" + credit +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                '}';
    }
}
