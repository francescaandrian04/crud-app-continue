package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;


@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// creating many Student objects
		System.out.println("Creating 4 student object ...");
		Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");



		// save the Student objects to the database using DAO
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);



		// display the ID of the saved students
		System.out.println("Saved students. Generated id: " + newStudent.getId());



	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		// creating many Student objects
		Student newStudent = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
		Student newStudent1 = new Student("Iulian", "Vataman", "iulic@pixelacademy.md");
		Student newStudent2 = new Student("Maria", "Mirabela", "mira@pixelacademy.md");


		// save the Student objects to the database using DAO
		studentDAO.save(newStudent);
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);


	}

}
