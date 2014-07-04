package domain;

import domain.Course;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-15T18:19:02")
@StaticMetamodel(Assignment.class)
public class Assignment_ { 

    public static volatile SingularAttribute<Assignment, Long> id;
    public static volatile SingularAttribute<Assignment, Course> course;
    public static volatile SingularAttribute<Assignment, String> assignmentName;
    public static volatile SingularAttribute<Assignment, Date> dueDate;

}