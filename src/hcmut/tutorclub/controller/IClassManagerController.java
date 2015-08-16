package hcmut.tutorclub.controller;

import java.util.List;

import hcmut.tutorclub.model.classmanager.Class;
import hcmut.tutorclub.model.classmanager.Student;
public interface IClassManagerController {
	
	/**
	 * Get list of classes which has not handed over yet.
	 * @return List of classes
	 */
	List<Class> findClassNotHandOver();
	
	/**
	 * Get list of students which have already been handed over at least 1 class.
	 * @return List of students
	 */
	List<Student> findAll();
	
	/**
	 * Get list of class which have already been handed over to a specified student.
	 * @param studentId ID of student
	 * @return List of classes have been handed over to student
	 */
	List<Class> findClassHandOver2Student(String studentId);
	
	/**
	 * Hand over a class to a student
	 * @param student
	 */
	void handOverClass(Student student);
	
}
