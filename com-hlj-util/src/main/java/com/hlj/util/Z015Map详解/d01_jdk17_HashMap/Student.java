package com.hlj.util.Z015Map详解.d01_jdk17_HashMap;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HealerJean
 * @ClassName Student
 * @date 2019/10/14  17:03.
 * @Description
 */
@Data
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private int age;

    public Student(String id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        if(this == obj){
            return true;
        }

        if(obj.getClass() != this.getClass()){
            return false;
        }

        Student student = (Student)obj;
        if(!student.getName().equals(getName())){
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Student student) {
        return this.age - student.age;
    }


    //Student类实现Comparable接口和实现equals方法，其中compareTo是根据age来比对的，equals是根据name来比对的。
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("2", "chenssy1", 26));
        list.add(new Student("1", "chenssy1", 24));

        //排序 按照年龄
        Collections.sort(list);
        System.out.println(list);

        Student student = new Student("2", "chenssy1", 26);

        //检索student在list中的位置
        int index1 = list.indexOf(student);
        System.out.println("index1 = " + index1);

        int index2 = Collections.binarySearch(list, student);
        System.out.println("index2 = " + index2);
    }

}

