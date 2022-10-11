package com.Spring.Jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Spring.Jdbc.dao.StudentDao;
import com.Spring.Jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// ApplicationContext con = new ClassPathXmlApplicationContext("Config.xml");
		ApplicationContext con = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = con.getBean("studentDao", StudentDao.class); // interface
		Student student = new Student(); // creating object of student

		// inserting data
		student.setId(614);
		student.setName("Kunal");
		student.setCity("Nagpur");
		int result = studentDao.insert(student);
		System.out.println("student added" + result);

//		update query
//      student.setId(123);
//		student.setName("Manish");
//		student.setCity("Gujarat");
//		int result = studentDao.change(student);
//		System.out.println("insert data"+result);

		// deleting statement
//		int result = studentDao.delete(a);
//		System.out.println("Delete statement" + result);

		// single date get
//		Student stu= studentDao.getStudent(121);
//		System.out.println(stu);

		// multiple data get
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
