package com.studentManagementSystem.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author spring
 */
@Entity
@Table(name = "student", catalog = "projectdb", schema = "")
@NamedQueries({ @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
		@NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
		@NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName"),
		@NamedQuery(name = "Student.findByStudentCourse", query = "SELECT s FROM Student s WHERE s.studentCourse = :studentCourse"),
		@NamedQuery(name = "Student.findByStudentFee", query = "SELECT s FROM Student s WHERE s.studentFee = :studentFee") })
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentId")
	private Integer studentId;
	@Column(name = "studentName", length = 20)
	private String studentName;
	@Column(name = "studentCourse", length = 30)
	private String studentCourse;
	@Column(name = "studentFee")
	private BigDecimal studentFee;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	// ALTER TABLE `student` CHANGE `studentFee` `studentFee` decimal(8,3) NULL
	// DEFAULT NULL;

	public Student() {
	}

	public Student(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public BigDecimal getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(BigDecimal studentFee) {
		this.studentFee = studentFee;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (studentId != null ? studentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Student)) {
			return false;
		}
		Student other = (Student) object;
		if ((this.studentId == null && other.studentId != null)
				|| (this.studentId != null && !this.studentId.equals(other.studentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCourse=" + studentCourse
				+ ", studentFee=" + studentFee + "]";
	}

}
