package com.anna.projectdemo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 员工信息实例
 *
 * @author liuhy
 * @create 2019-07-31 18:47
 **/
@Document(indexName = "company",type = "employee",shards = 5,replicas = 0,refreshInterval = "-1")
public class Employee {
    @Id
    private String id;
    @Field(type = FieldType.keyword)
    private String name;
    @Field(type = FieldType.Integer)
    private int age;
    @Field(type = FieldType.text)
    private String position;
    @Field(type=FieldType.text)
    private String country;
    @Field(type = FieldType.Date)
    private Date join_date;
    @Field(type = FieldType.Double)
    private double salary;

    //不写构造方法会报错
    public Employee() {
    }

    public Employee(String id, String name, int age, String position, String country, Date join_date, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.country = country;
        this.join_date = join_date;
        this.salary = salary;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id  = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
