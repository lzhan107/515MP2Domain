/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Address;
import domain.Assignment;
import domain.Course;
import domain.Gender;
import domain.Instructor;
import domain.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.persistence.TypedQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.DomainUtil;

/**
 *
 * @author Lei
 * JUnit test class for testing the domain model
 */
public class DomainTest extends DomainUtil {

    private List<Address> addrs = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public DomainTest() {
    }

    @Before
    public void prepareData() {
        //Initializing address data
        Address addr1 = new Address("33RD ST.", "Chicago", "IL", 60636, "US");
        Address addr2 = new Address("34RD ST.", "Los Angeles", "CA", 90003, "US");
        Address addr3 = new Address("35RD ST.", "Champaign", "IL", 61245, "US");
        Address addr4 = new Address("36RD ST.", "Chicago", "IL", 60636, "US");
        Address addr5 = new Address("37RD ST.", "Chicago", "IL", 60616, "US");
        Address addr6 = new Address("66RD ST.", "Chicago", "IL", 60124, "US");
        addrs.add(addr1);
        addrs.add(addr2);
        addrs.add(addr3);
        addrs.add(addr4);
        addrs.add(addr5);
        addrs.add(addr6);
        //Initializing assignments
        Assignment assignment1 = new Assignment("MP2 for Adv. Software Programming", new GregorianCalendar(2013, 10, 13).getTime());
        Assignment assignment2 = new Assignment("Home assignment for Intro. Open Source Operating System", new GregorianCalendar(2013, 10, 14).getTime());
        Assignment assignment3 = new Assignment("Midterm for Database Security", new GregorianCalendar(2013, 10, 15).getTime());
        assignments.add(assignment1);
        assignments.add(assignment2);
        assignments.add(assignment3);
        
        //Initializing course data
        Course cour1 = new Course("Advanced Software Programning", 101, "Learning Java EE 7 Specs and Enterprise Web Applications");
        Course cour2 = new Course("Introduction to Opern Source Operating System", 102, "Introduction to Linux installation, setup, administration");
        Course cour3 = new Course("Database Secuity", 103, "Introduction to security measures and potential database attacks.");
        Course cour4 = new Course("Introduction to Macroeconomics", 104, "Learning performance, structure of economics");
        Course cour5 = new Course("Polymer Synthesis", 105, "Learning the constructions of polymer");
        Course cour6 = new Course("Basic Gas Chromatography", 106, "Learning basics of chromatography");
        Course cour7 = new Course("Algorithm in Java", 107, "Learning data structure and algorithm using Java");
        cour1.addAssignments(assignment1);
        cour2.addAssignments(assignment2);
        cour3.addAssignments(assignment3);
        courses.add(cour1);
        courses.add(cour2);
        courses.add(cour3);
        courses.add(cour4);
        courses.add(cour5);
        courses.add(cour6);
        courses.add(cour7);

        //Initializing instructor data
        Instructor instructor1 = new Instructor("Scott", Gender.MALE, "Professor", "ITM");
        Instructor instructor2 = new Instructor("Jeremy", Gender.MALE, "Professor", "ITM");
        Instructor instructor3 = new Instructor("Nancy", Gender.FEMALE, "Instructor", "C.S.");
        Instructor instructor4 = new Instructor("Jessi", Gender.FEMALE, "Professor", "CHEM");
        instructor1.addCourses(cour1);
        instructor1.addCourses(cour7);
        instructor2.addCourses(cour3);
        instructor3.addCourses(cour3);
        instructor4.addCourses(cour6);
        instructors.add(instructor1);
        instructors.add(instructor2);
        instructors.add(instructor3);
        instructors.add(instructor4);
        
        //Initializing student data
        Student stu1 = new Student("Lei", Gender.MALE, "ITM", new Date());
        Student stu2 = new Student("Hao", Gender.FEMALE, "Chemistry", new Date());
        Student stu3 = new Student("Mike", Gender.MALE, "CS", new Date());
        Student stu4 = new Student("John", Gender.MALE, "Biology", new Date());
        Student stu5 = new Student("Cindy", Gender.FEMALE, "Economics", new Date());
        Student stu6 = new Student("Cass", Gender.FEMALE, "Chemistry", new Date());
        stu1.addCourses(cour1);
        stu1.addCourses(cour2);
        stu2.addCourses(cour6);
        stu3.addCourses(cour7);
        stu4.addCourses(cour5);
        stu5.addCourses(cour4);
        stu1.addCourses(cour5);
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        students.add(stu6);
        


    }

    @Test
    public void testDomain() {
        tx.begin();
        Random randomGenerator = new Random();
        //Assigning addresses to students
        for (Student student : students) {
            student.setAddress(addrs.get(randomGenerator.nextInt(6)));
            em.persist(student);
        }

        for (Instructor instructor : instructors) {
            instructor.setAddress(addrs.get(randomGenerator.nextInt(4)));
            em.persist(instructor);
        }

        for (Course course : courses) {
            em.persist(course);
        }

        for (Assignment assignment : assignments) {
            em.persist(assignment);
        }
        tx.commit();
        
        
        //Displaying and updating info
        TypedQuery<Instructor> instQuery = em.createQuery("SELECT i FROM Instructor i", Instructor.class);
        List<Instructor> insts = instQuery.getResultList();
        Assert.assertNotNull(insts);
        for (Instructor inst : insts) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Instructor: " + inst.getName());
            for (Course course : inst.getCourses()) {
                System.out.println("\tCourse: " + course.getCourseName());
                for (Student stu: course.getStudents()){
                    System.out.println("\t\tStudent: " + stu.getName());
                }
                for (Assignment assignment: course.getAssignments()){
                    System.out.println("\t\t\tAssignment: " + assignment.getAssignmentName() + " | " + "Due date: " + assignment.getDueDate());
                }
            }
        }
        
        //Updating Instructor info
        tx.begin();
        TypedQuery<Instructor> iQuery = em.createQuery("SELECT i FROM Instructor i WHERE i.name = 'scott'", Instructor.class);
        Instructor i = iQuery.getSingleResult();
        Assert.assertNotNull(i);
        i.setAddress(new Address("66RD ST.", "Chicago", "IL", 60111, "US"));
        System.out.println("Instructor " + i + "'s address is now: " + i.getAddress());
        tx.commit();
        
        //delete a student entity
        tx.begin();
        Student s = em.find(Student.class, 1L);
        Assert.assertNotNull(s);
        System.out.println("Student deleted: " + s);
        em.remove(s);
        tx.commit();
    }
}