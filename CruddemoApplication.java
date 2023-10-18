package com.luv2code.cruddemo;
import com.luv2code.cruddemo.DAO.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			findStudent(studentDAO);
			deletetable(studentDAO);
			updatetable(studentDAO);
			ListofStudent(studentDAO);
		};
	}
	private void deletetable(StudentDAO studentDAO) {
		int sid = 2;
		studentDAO.delete(sid);
	}
	private void findStudent(StudentDAO studentDAO) {
		Student temp1 = new Student("ram1", "cdghu2", "ram@gmail1.com");
		Student temp2 = new Student("ram1", "bdghu2", "ram@gmail1.com");
		Student temp3 = new Student("ram1", "adghu2", "ram@gmail1.com");
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
	}
	private void updatetable(StudentDAO studentDAO) {
		int sid = 1;
		Student details = studentDAO.findById(sid); // Call the method on the instance
		details.setLast_name("user");
		studentDAO.update(details);
	}
	private void  ListofStudent(StudentDAO studentDAO) {
		Student tem=new Student();
		List<Student> studentList=studentDAO.display(tem);
		for (Student student: studentList)
			System.out.println(student);
	}
}
























