package com.example.SpringBootSoapWebService;

import https.ro_wikipedia_org.wiki.world_wide_web.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData(){
        Student student = new Student();
        student.setName("Test1");
        student.setStandard(1);
        student.setAddress("test1");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Test2");
        student.setStandard(2);
        student.setAddress("test2");
        students.put(student.getName(), student);
    }

    public Student findStudent(String name){
        Assert.notNull(name, "Numele studentului trebuie sa nu fie null");
        return students.get(name);
    }
}
