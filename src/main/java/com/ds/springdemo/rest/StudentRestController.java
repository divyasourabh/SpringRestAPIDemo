package com.ds.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student>  studentList;
		
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
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		List<Student>  students = new ArrayList<Student>();
		
		students.add(new Student("Divya","Sourabh"));
		students.add(new Student("Sourabh","Aswal"));
		students.add(new Student("DivyaSourabh","Aswal"));
		students.add(new Student("Reena","Aswal"));
		students.add(new Student("Reena","DivyaSourabh"));
		
		//Check th student Id against list size
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id Not found - " + studentId); 
		}
		
		return students.get(studentId);
	}

}
