import java.util.List;
import java.util.ArrayList;

public class Student extends Person {
    private List<Course> enrolledCourses;
    private double gpa;

    public Student(String name,String email,String id){
        super(name,email,id);
        this.enrolledCourses=new ArrayList<>();
        this.gpa=0.0;

    }

    public void enrollCourse(Course course){
        enrolledCourses.add(course);
    }
    public void viewCourse(){
        if(enrolledCourses.isEmpty()){
            System.out.println("No courses enrolled.");
            return;
        }
        System.out.println("Courses enrolled by " +name+ ":");
        for (Course c :enrolledCourses){
            System.out.println(c.getCourseName());
        }

    }

    public void setGpa(double gpa){
        this.gpa=gpa;

    }
    @Override
    public String toString(){
        return super.toString()+", GPA: "+gpa;

    }
}