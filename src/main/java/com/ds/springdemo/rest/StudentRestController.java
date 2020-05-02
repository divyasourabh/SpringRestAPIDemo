package com.ds.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/student")
	public List<Student> getStudent(){
		
		List<Student>  students = new ArrayList<Student>();
		
		students.add(new Student("Divya","Sourabh"));
		students.add(new Student("Sourabh","Aswal"));
		students.add(new Student("DivyaSourabh","Aswal"));
		students.add(new Student("Reena","Aswal"));
		students.add(new Student("Reena","DivyaSourabh"));
		
		return students;
	}
}
