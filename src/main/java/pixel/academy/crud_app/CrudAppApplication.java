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
//			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a Student object
		System.out.println("Creating new student object ... ");
		Student newStudent = new Student("Mircea", "Popescu", "mircea@pixel.academy");

		// save the Student object to the database
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// show the Student id that you saved
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve the student based on the ID (PK
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findbyId(theId);

		// display the student's details
		System.out.println("Found the student: " + myStudent);

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
