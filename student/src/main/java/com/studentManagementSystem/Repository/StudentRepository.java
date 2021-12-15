package com.studentManagementSystem.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.studentManagementSystem.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	//Custom Finder Methods
	List<Student> findByStudentId(Integer studentId);
	List<Student> findByStudentName(String studentName);
	List<Student> findByStudentCourse(String studentCourse);
	List<Student> findByStudentNameAndStudentCourse(String studentName, String studentCourse);
}
