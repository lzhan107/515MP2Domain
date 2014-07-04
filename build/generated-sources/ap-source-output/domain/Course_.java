package domain;

import domain.Assignment;
import domain.Instructor;
import domain.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-15T18:19:02")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Long> id;
    public static volatile SingularAttribute<Course, String> courseDescription;
    public static volatile ListAttribute<Course, Student> students;
    public static volatile SingularAttribute<Course, Instructor> instructor;
    public static volatile SingularAttribute<Course, Integer> courseRefNum;
    public static volatile ListAttribute<Course, Assignment> assignments;
    public static volatile SingularAttribute<Course, String> courseName;

}