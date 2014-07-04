package domain;

import domain.Address;
import domain.Course;
import domain.Gender;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-15T18:19:02")
@StaticMetamodel(Instructor.class)
public class Instructor_ { 

    public static volatile SingularAttribute<Instructor, Long> id;
    public static volatile SingularAttribute<Instructor, String> title;
    public static volatile ListAttribute<Instructor, Course> courses;
    public static volatile SingularAttribute<Instructor, Address> address;
    public static volatile SingularAttribute<Instructor, String> department;
    public static volatile SingularAttribute<Instructor, String> name;
    public static volatile SingularAttribute<Instructor, Gender> gender;

}