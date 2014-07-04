/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lei
 * This entity class represents course table in database
 */
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int courseRefNum;
    private String courseDescription;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    private Instructor instructor;
    //One course has many assignments, once course is removed, all corresponding
    //assignments are removed
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Assignment> assignments = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName, int courseRefNum, String courseDescription) {
        this.courseName = courseName;
        this.courseRefNum = courseRefNum;
        this.courseDescription = courseDescription;
    }

    public void addAssignments(Assignment assignment){
        if (! this.assignments.contains(assignment)){
            assignments.add(assignment);
        }
        if (assignment.getCourse() != this){
            assignment.setCourse(this);
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseRefNum() {
        return courseRefNum;
    }

    public void setCourseRefNum(int courseRefNum) {
        this.courseRefNum = courseRefNum;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", courseName=" + courseName + ", courseRefNum=" + courseRefNum + ", courseDescription=" + courseDescription + ", students=" + students + ", instructor=" + instructor + ", assignments=" + assignments + '}';
    }
}
