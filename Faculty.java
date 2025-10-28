import java.util.List;
import java.util.ArrayList;

public class Faculty extends Person {
    private String department;
    private List<Course> assignedCourses;


public Faculty(String name,String id,String email,String department){
    super(name,email,id);
    this.department=department;
    this.assignedCourses=new ArrayList<>();

}
public void assignCourse(Course course){
    
        assignedCourses.add(course);
    }

    public void viewAssignedCourses(){

        if(assignedCourses.isEmpty()){
            System.out.println(name+ "no courses assignes");
            return;
        }
        System.out.println("Courses assigned to " +name+":");
        for (Course c: assignedCourses){
            System.out.println(c.getCourseName());
        }
    }

    @Override
    public String toString(){
        return super.toString() +",Department: "+department;
    }
    
}