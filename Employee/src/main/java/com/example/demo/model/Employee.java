package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	//private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(generator ="id")
	@GenericGenerator(name ="id", strategy="increment")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="fullname")
	private String fullname;
	@Column(name="emailid")
	private String emailid;
	@Column(name="date_of_birth")
	private String dateOfBirth;
	@Column(name="gender")
	private String gender;
	public Employee(Integer id, String username, String password, String fullname, String emailid, String dateOfBirth,
			String gender, String securityQuestion, String answer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.emailid = emailid;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	@Column(name="security_question")
	private String securityQuestion;
	@Column(name="answer")
	private String answer;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/*public static long getSerialversionuid() {
		return serialVersionUID;
	}*/
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", emailid=" + emailid + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", securityQuestion="
				+ securityQuestion + ", answer=" + answer + "]";
	}
	
	

}