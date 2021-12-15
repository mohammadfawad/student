package com.studentManagementSystem;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentManagementSystem.Entity.Student;
import com.studentManagementSystem.Repository.StudentRepository;

@SpringBootTest
class StudentApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreatStudent() {
		Student student = new Student();
		student.setStudentName("Mohammad Asad");
		student.setStudentCourse("Data Structures");
		student.setStudentFee(new BigDecimal("15000"));
		this.studentRepository.save(student);
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = this.studentRepository.findById(1).get();
		student.setStudentFee(new BigDecimal("19000"));
		this.studentRepository.save(student);
	}
	
	@Test
	public void testReadStudents() {
		this.studentRepository.findAll().forEach(s->{System.out.println(s.toString());});
	}
	
	@Test
	public void testReadStudent() {
	 	System.out.print("\n ::STUDENT :: " + this.studentRepository.findById(1).toString());
	}
	
	@Test
	public void testDeleteStudent() {
		this.studentRepository.deleteById(3);
	}

}
