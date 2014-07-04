package domain;

import domain.Address;
import domain.Course;
import domain.Gender;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-15T18:19:02")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, Date> registrationDate;
    public static volatile ListAttribute<Student, Course> courses;
    public static volatile SingularAttribute<Student, Address> address;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Gender> gender;
    public static volatile SingularAttribute<Student, String> major;

}