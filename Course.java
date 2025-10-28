import java.util.List;
import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private Faculty faculty;
    private List<Student> enrolledStudents;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
        faculty.assignCourse(this);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.enrollCourse(this);
    }

    public void viewEnrolledStudents() {
        System.out.println("Students in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println(" - " + s.getName());
        }
    }
}


